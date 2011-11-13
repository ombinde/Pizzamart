package model;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
/**
 * A class for orders
 * 
 * @author Sigurd Lund and Øvind Binde
 *
 */
public class Order {
	
	private Customer customer;
	private ArrayList<Product> products;
	private String status;
	private String comment;
	private int idOrder;
	private DeliveryFee deliveryFee;
	private double limitFreeDelivery;
	private int allergy;
	private int delivery;
	private Date dateAdded;
	
	private final static Locale locale = new Locale("no");
	private final static TimeZone timeZone = TimeZone.getTimeZone("Europe/Oslo");
	private static Calendar calendar = Calendar.getInstance(timeZone, locale);
	
	/**
	 * Creates a new order with all the information needed.
	 * @param customer
	 * @param products
	 * @param status
	 * @param comment
	 */
	private Order(int idOrder, Customer customer, ArrayList<Product> products, String status, String comment, int allergy, int delivery, long date){
		this.idOrder = idOrder;
		this.customer = customer;
		this.products = products;
		this.status = status;
		this.comment = comment;
		this.allergy = allergy;
		this.delivery = delivery;
		this.dateAdded = new Date(date);
		this.getLimitFreeDelivery();
		this.deliveryFee = DeliveryFee.getDeliveryFee();
	}
	/**
	 * Creates a new Order with only a customer. More can be added later on.
	 * @param customer
	 */
	public Order(Customer customer){
		this.customer = customer;
		this.status = "Under bestilling";
		this.products = new ArrayList<Product>();
		this.comment = "";
		this.getLimitFreeDelivery();
		this.deliveryFee = DeliveryFee.getDeliveryFee();
		this.setDelivery(true);
		this.setAllergy(false);
	}
	
	/**
	 * A static method that returns all products from a given order 
	 * as a HashMap with products as key, and quantity as value. 
	 * @param idOrder
	 * @return HashMap<Product, Integer> som innholder produkter og anntallet.
	 */
/*	public static HashMap<Product, Integer> getProductsFromOrder(int id){
		Database db;
		try {
			db = Database.getDatabase();
			HashMap<Product, Integer> products = new HashMap<Product, Integer>();
			ResultSet rs = db.select("select name, price, comments, quantity from product_has_order " +
					"join product on idproduct=product_idproduct where orders_idorder=" + id );
			while (rs.next()){
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				if(name.equals("Frakt"))
					products.put(DeliveryFee.getDeliveryFee(), 1);
				else
					products.put(new Product(name, price), rs.getInt("quantity"));
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	

	
	/**
	 * Returns the totalprice of an given Order.
	 * @param order
	 * @return
	 */
	/*public double getOrderTotalPrice(){
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
	    else if (productsInOrder.containsKey(deliveryFee)){
	    	deliveryFee.setPriceToOriginal();
	    }
		return totalprice;
	}*/
	
	public double getOrderTotalPrice(){
		double totalprice = 0;
		if (products.size()<1)
			return 0;
	    for (Product p : products) {
	    	int quantity = p.getQuantity();	
	        totalprice += ((Product) p).getPrice()*quantity;
	    }
	    if (products.contains(deliveryFee) && totalprice > limitFreeDelivery){
	    	double fee = deliveryFee.getPrice();
	    	deliveryFee.setPrice(0);
	    	totalprice -= fee;
	    }
	    else if (products.contains(deliveryFee)){
	    	deliveryFee.setPriceToOriginal();
	    }
		return totalprice;
	}

	/**
	 * Returns the quantity of an product in an order.
	 * @param product
	 * @return quantity as an integer
	 */
//	public int getProductQuanta(ProductInOrder product){
//	    for (ProductInOrder p : products) {
//			if (p.equals(product)){
//				return p.getQuantity();
//			}
//		}
//	    return 0;
//	}
	
	/**
	 * Adds the order to the Database.
	 * @return
	 */
	public int addOrderToDatabase(){
		Integer quantity = 0;
		this.dateAdded = calendar.getTime();
		try {
			Database db = Database.getDatabase();
			String query = "INSERT INTO orders (status, comments, customer_idcustomer, allergy, delivery, time) " +
			  			   "VALUES ('"+this.status + "','" + comment + "','" + customer.getIdCustomer() + "','" + allergy + "','" + delivery + "','" + dateAdded + "')";
			idOrder = db.insertWithIdReturn(query);
		    for (Product p : products) {
		    	quantity = p.getQuantity();
		    	int idproduct = ((Product) p).getIdproduct();
		    	query = "INSERT INTO product_has_order (product_idproduct, orders_idorder, quantity) " +
		    	"values('" + idproduct + "','" + idOrder + "','" + quantity + "')";
		    	db.insert(query);
		    	
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
		if (!(product instanceof DeliveryFee) && products.contains(product)){
			for (Product p : products) {
				if (p.equals(product)){
					p.addQuantity(quantity);
				}
			}
		}
		else
			products.add(product);
		if (delivery==1 && !(product instanceof DeliveryFee) && !products.contains(deliveryFee)){
			products.add(deliveryFee);
		}
	}
	
	/**
	 * Removes products from the order. If the order has no other products
	 * than the delivery fee after the removal, the delivery fee is also removed
	 * @param product
	 * @param quantity
	 */
	public void removeProductFromOrder(Product product, int quantity){
		if (products.contains(product)){
			for (Product p : products){
				if (p.equals(product)){
					if (p.getQuantity() > quantity){
						p.removeQuantity(quantity);
						break;
					}
					else{
						products.remove(p);
						break;
					}
				}
			}
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
			String query = "UPDATE orders SET status='" + status + "' WHERE idorder=" + idOrder;
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
		if (!products.contains(deliveryFee))
			this.addProductToOrder(deliveryFee, 1);
	}
	
	/**
	 * Removes the delivery fee
	 */
	private void removeDeliveryFee(){
		if (products.contains(deliveryFee))
			products.remove(deliveryFee);
	}
	
	/**
	 * Returns the id of all orders with a given status
	 * @param status
	 * @return ArrayList with orders
	 */
	public static ArrayList<Integer> getOrdersById(String status1, String status2){
		ArrayList<Integer> freshOrders = new ArrayList<Integer>();
		try {
			Database db;
			db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM orders WHERE status='" + status1 + "' OR status='" + status2 + "'");
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
	
	public static ArrayList<Order> getAllOrders(){
		ArrayList<Order> allOrders = new ArrayList<Order>();
		try {
			Database db;
			db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM orders");
			while(rs.next()){
				ArrayList<Product> products = Product.getProductsFromOrder(rs.getInt("idorder"));
				Customer customer = Customer.getCustomerFromOrder(rs.getInt("customer_idcustomer"));
				int idOrder = rs.getInt("idorder");
				String status = rs.getString("status");
				String comment = rs.getString("comments");
				int allergy = rs.getInt("allergy");
				int delivery = rs.getInt("delivery");
				long date = rs.getLong("time");
				allOrders.add(new Order(idOrder, customer, products, status, comment, allergy, delivery, date));
			}
			return allOrders;
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
	public ArrayList<Product> getProductsInOrder(){
		return products;
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
	
	/**
	 * Sets the allergy status to true or false.
	 * @param b
	 */
	public void setAllergy(boolean b){
		if (b){
			allergy = 1;
		}
		else{
			allergy = 0;
		}
	}
	
	/**
	 * Returns true if the customer is allergic
	 * @return
	 */
	public boolean getAllergy(){
		return (allergy==1) ? true : false;
	}
	
	public String getDateAndTime(){
		DateFormat df = DateFormat.getDateInstance(1);
		return df.format(dateAdded);
	}
	
	public String getDate(){
		dateAdded = calendar.getTime();
		DateFormat df = DateFormat.getDateInstance(3);
		return df.format(dateAdded);
	}


}
