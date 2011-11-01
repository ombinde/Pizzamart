package model;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	}
	/**
	 * Creates a new Order with only a customer. More can be added later on.
	 * @param customer
	 */
	public Order(Customer customer){
		this.customer = customer;
		this.status = "Under bestilling";
	}
	
	/**
	 * A static method that returns all products from a given order 
	 * as a HashMap with products as key, and quantity as value. 
	 * @param idorder
	 * @return HashMap<Product, Integer>
	 */
	public static HashMap<Product, Integer> getProductsFromOrdre(int id){
		Database db;
		try {
			db = Database.getDatabase();
			HashMap<Product, Integer> products = new HashMap<Product, Integer>();
			ResultSet rs = db.select("select name, price, quantity from product_has_order " +
					"join product on idproduct=product_idproduct where orders_idorder=" + id );
			while (rs.next()){
				double price = rs.getInt("price");
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
	public double getOrderTotalPrice(Order order){
		double totalprice = 0;
	    for (Object p : order.productsInOrder.keySet()) {
	    	if (p instanceof Product){
		    	int quantity = order.productsInOrder.get(p);	
		        totalprice += ((Product) p).getPrice()*quantity;
	    	}
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
			String query = "INSERT INTO orders (status, comment, customer_idcustomer) " +
			  			   "VALUES ('"+this.status + "','" + comment + "','" + customer.getIdCustomer() + "')";
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
			return 0;
		}
	}
	
	/**
	 * Adds a given product to the order
	 * @param product
	 * @param quantity
	 */
	public void addProductToOrder(Product product, int quantity){
		productsInOrder.put(product, quantity);
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
	 * Returns the id of all orders with a given status
	 * @param status
	 * @return
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
	 * Returns a HashMap with the relevant products to the query containing the name and the price
	 * of the products.
	 * @param query
	 * @return
	 */
	public static HashMap<String, Double> getRelevantProducts(String query){
		HashMap<String, Double> products = new HashMap<String, Double>();
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM product where name like '" + query + "%'");
			while (rs.next()){
				products.put(rs.getString("name"), rs.getDouble("price"));
			}
			return products;
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
	
	public HashMap<Product, Integer> getProductsInOrder(){
		return productsInOrder;
	}

}
