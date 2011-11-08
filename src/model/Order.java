package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * A class for orders
 * 
 * @author Sigurd Lund and Øvind Binde
 *
 */
public class Order {
	
	private Customer customer;
	private HashMap<Product, Integer> productsInOrder;
	private String status;
	private String comment;
	private int idorder;
	private DeliveryFee deliveryFee;
	private double limitFreeDelivery;
	private int delivery;
	
	/**
	 * Creates a new order with all the information needed.
	 * @param customer
	 * @param products
	 * @param status
	 * @param comment
	 */
	public Order(Customer customer, HashMap<Product, Integer> products, String status, String comment){
		this.customer = customer;
		this.productsInOrder = products;
		this.status = status;
		this.comment = comment;
		this.productsInOrder = new HashMap<Product, Integer>();
	}
	/**
	 * Creates a new Order with only a customer. More can be added later on.
	 * @param customer
	 */
	public Order(Customer customer){
		this.customer = customer;
		this.status = "Under bestilling";
		this.productsInOrder = new HashMap<Product, Integer>();
		this.comment = "";
		this.getLimitFreeDelivery();
		this.deliveryFee = DeliveryFee.getDeliveryFee();
		this.delivery = 0;
	}
	
	/**
	 * A static method that returns all products from a given order 
	 * as a HashMap with products as key, and quantity as value. 
	 * @param idorder
	 * @return HashMap<Product, Integer> som innholder produkter og anntallet.
	 */
	public static HashMap<Product, Integer> getProductsFromOrder(int id){
		Database db;
		try {
			db = Database.getDatabase();
			HashMap<Product, Integer> products = new HashMap<Product, Integer>();
			ResultSet rs = db.select("select name, price, quantity from product_has_order " +
					"join product on idproduct=product_idproduct where orders_idorder=" + id );
			while (rs.next()){
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				products.put(new Product(name, price), rs.getInt("quantity"));
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Returns the totalprice of an given Order.
	 * @param order
	 * @return
	 */
	public double getOrderTotalPrice(){
		double totalprice = 0;
		if (productsInOrder.size()<1)
			return 0;
	    for (Object p : productsInOrder.keySet()) {
	    	if (p instanceof Product){
		    	int quantity = productsInOrder.get(p);	
		        totalprice += ((Product) p).getPrice()*quantity;
	    	}
	    }
	    if (productsInOrder.containsKey(deliveryFee) && totalprice > limitFreeDelivery){
	    	double fee = deliveryFee.getPrice();
	    	deliveryFee.setPrice(0);
	    	totalprice -= fee;
	    }
		return totalprice;
	}

	/**
	 * Returns the quantity of an product in an order.
	 * @param product
	 * @return quantity as an integer
	 */
	public int getProductQuanta(Product product){
	    if(productsInOrder.containsKey(product))
	    	return productsInOrder.get(product);
	    return 0;
	}
	
	/**
	 * Adds the order to the Database.
	 * @return
	 */
	public int addOrderToDatabase(){
		Integer quantity = 0;
		try {
			Database db = Database.getDatabase();
			String query = "INSERT INTO orders (status, comments, customer_idcustomer, delivery) " +
			  			   "VALUES ('"+this.status + "','" + comment + "','" + customer.getIdCustomer() + "','" + delivery +"')";
			idorder = db.insertWithIdReturn(query);
		    for (Object p : productsInOrder.keySet()) {
		    	if (p instanceof Product){
			    	quantity = productsInOrder.get(p);
			    	int idproduct = ((Product) p).getIdproduct();
			    	query = "INSERT INTO product_has_order (product_idproduct, orders_idorder, quantity) " +
			    	"values('" + idproduct + "','" + idorder + "','" + quantity + "')";
			    	db.insert(query);
		    	}
			}
		    return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Adds a given product to the order
	 * @param product
	 * @param quantity
	 */
	public void addProductToOrder(Product product, int quantity){
		int oldQuantity = 0;
		if (productsInOrder.containsKey(product)){
			oldQuantity = productsInOrder.get(product);
			productsInOrder.remove(product);
		}
		productsInOrder.put(product, quantity + oldQuantity);
		if (!productsInOrder.containsKey(deliveryFee) && delivery==1){
			productsInOrder.put(deliveryFee, 1);
		}
	}
	
	/**
	 * Removes products from the order. If the order has no other products
	 * than the delivery fee after the removal, the delivery fee is also removed
	 * @param product
	 * @param quantity
	 */
	public void removeProductFromOrder(Product product, int quantity){
		if (productsInOrder.containsKey(product)){
			int oldQuantity = productsInOrder.get(product);
			if (productsInOrder.get(product) > quantity){
				productsInOrder.put(product, oldQuantity-quantity);
			}
			else{
				productsInOrder.remove(product);
			}
		}
		if (productsInOrder.size()==1 && productsInOrder.containsKey(deliveryFee)){
			productsInOrder.remove(deliveryFee);
		}
	}
	
	
	/**
	 * Takes a new status in and updates the order status in the database
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
		try {
			Database db = Database.getDatabase();
			String query = "UPDATE orders SET status='" + status + "' WHERE idorder=" + idorder;
			db.insert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the limit for free delivery. It looks up in the database for the value.
	 */
	private void getLimitFreeDelivery(){
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT limitFreeDelivery FROM properties");
			if (rs.next())
				limitFreeDelivery = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds delivery fee for the order.
	 */
	private void addDeliveryFee(){
		if (!productsInOrder.containsKey(deliveryFee))
			this.addProductToOrder(deliveryFee, 1);
	}
	
	/**
	 * Removes the delivery fee
	 */
	private void removeDeliveryFee(){
		if (productsInOrder.containsKey(deliveryFee))
			productsInOrder.remove(deliveryFee);
	}
	
	/**
	 * Returns the id of all orders with a given status
	 * @param status
	 * @return ArrayList with orders
	 */
	public static ArrayList<Integer> getOrdersById(String status){
		ArrayList<Integer> freshOrders = new ArrayList<Integer>();
		try {
			Database db;
			db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM orders WHERE status='" + status + "'");
			while(rs.next()){
				freshOrders.add(rs.getInt("idorder"));
			}
			return freshOrders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Sets a comment in the order.
	 * @param comment
	 */
	public void setComment(String comment){
		this.comment = comment;
	}
	
	/**
	 * Returns the comment of an order.
	 * @return
	 */
	public String getComment(){
		return this.comment;
	}
	
	/**
	 * Returns all the products in a HashMap with the product as the key,
	 * and the quantity of the product as value.
	 * @return
	 */
	public HashMap<Product, Integer> getProductsInOrder(){
		return productsInOrder;
	}
	
	/**
	 * Sets the delivery to true or false.
	 * Adds a delivery fee if it's true.
	 * @param b
	 */
	public void setDelivery(boolean b){
		if (b){
			delivery = 1;
			addDeliveryFee();
		}
		else{
			delivery = 0;
			removeDeliveryFee();
		}
	}
	
	/**
	 * Returns true if the order is going to be delivered
	 * and false if not.
	 * @return
	 */
	public boolean getDelivery(){
		return (delivery==1) ? true : false;
	}


}
