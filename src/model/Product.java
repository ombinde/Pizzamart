package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A class for products.
 * @author Sigurd Lund
 *
 */
public class Product {

	private int quantity;
	private String name;
	private double price;
	private int idproduct;
	private String comment;
	
	/**
	 * Creates a new Product with the given id, name, price, quantity and comment.
	 * The constructor will look up the product id in the database.
	 * This should be used when initializing a product in a order.
	 * @param id
	 * @param name
	 * @param price
	 * @param quantity
	 * @param comment
	 */
	public Product(int id, String name, double price, int quantity, String comment) {
		this.idproduct = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Creates a new Product with the given name, price and comment.
	 * The constructor will look up the product id in the database.
	 * @param name
	 * @param price
	 * @param quantity
	 * @param comment
	 */
	public Product(String name, double price, String comment) {
		
		this.name = name;
		this.price = price;
		this.comment = comment;
		this.quantity = 1;
		Database db = Database.getDatabase();
		try {
			ResultSet rs = db.select("SELECT idproduct FROM product WHERE name='" 
									+ name + "' and price ='" + price + "'");
			if (rs.next()){
				this.idproduct = rs.getInt("idproduct");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Returns the name of the product as a String.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the price as a double.
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the product price.
	 * @param price
	 */
	public void setPrice(double price){
		this.price = price;
	}
	
	/**
	 * Returns the product id of a product.
	 * @return
	 */
	public int getIdproduct(){
		return idproduct;
	}
	
	/**
	 * Returns all the products of an order as an ArrayList.
	 * @param idOrder
	 * @return ArrayList
	 */
	public static ArrayList<Product> getProductsFromOrder(int idOrder){
		
		Database db = Database.getDatabase();
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			ResultSet rs = db.select("SELECT idproduct, name, price, comments, quantity FROM product_has_order " +
					"JOIN product ON idproduct=product_idproduct WHERE orders_idorder=" + idOrder );
			
			while (rs.next()){
				int idProduct = rs.getInt("idproduct");
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				String comment = rs.getString("comments");
				int q = rs.getInt("quantity");
				if(name.equals("Frakt"))
					products.add(DeliveryFee.getDeliveryFee());
				else
					products.add(new Product(idProduct, name, price, q, comment));
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	/**
	 * Returns an ArrayList with the relevant products to the query.
	 * The products are ordered by name ascending.
	 * @param query
	 * @return ArrayList
	 */
	public static ArrayList<Product> getRelevantProducts(String query){
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM product where name LIKE '" + query + "%' ORDER BY name ASC");
			while (rs.next()){
				int idProduct = rs.getInt("idproduct");
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				String comment = rs.getString("comments");
				if(name.equals("Frakt"))
					products.add(DeliveryFee.getDeliveryFee());
				else
					products.add(new Product(idProduct, name, price, 1, comment));
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Returns an ArrayList with all the products in the database.
	 * The products are ordered by name ascending.
	 * @return ArrayList
	 */
	public static ArrayList<Product> getAllProducts(){
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM product ORDER BY name ASC");
			while (rs.next()){
				products.add(new Product(rs.getInt("idproduct"), rs.getString("name"), rs.getDouble("price"), 1, 
													rs.getString("comments")));
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Adds a product to the database with the given name and price
	 * if the product does not already exist.
	 * @param name
	 * @param price
	 * @return true if the product was successfully added, and false if the product already exists.
	 */
	public static boolean addProductToDatabase(String name, double price, String comment){
		if (prodictIsUnike(name)){
			try {
				Database db = Database.getDatabase();
				String query = "INSERT INTO product (name, price, comments) " +
				  			   "VALUES ('"+ name + "', '" + price + "','" + comment + "')";
				db.insert(query);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * Deletes a product from the database.
	 * Returns true if the product was deleted, else it's false.
	 * @param p
	 * @return
	 */
	public static boolean deleteProductFromDatabase(Product p){
		if(p instanceof DeliveryFee)
			return false;
		try {
			Database db = Database.getDatabase();
			String query = "DELETE FROM product where name='" + p.name + "'";
			db.insert(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Updates a product p in the database with the given parameters.
	 * Returns true if the product was updated successfully. If false something wrong happend, 
	 * and it wasn't updated.
	 * @param p
	 * @param name
	 * @param price
	 * @param comment
	 * @return
	 */
	public static boolean updateProduct(Product p, String name, double price, String comment){
		if (!prodictIsUnike(name))
			return false;
		try {
			Database db = Database.getDatabase();
			String query = "UPDATE product SET name='" + name + "', price='" + price + 
							"', comments='" + comment +"' WHERE name='" + p.name + "'";
			db.insert(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return false;		
	}
	
	/**
	 * Checks that the product doesn't already exist in the database.
	 * Only one product can have the same name.
	 * @param name
	 * @return
	 */
	private static boolean prodictIsUnike(String name){
		try {
			Database db = Database.getDatabase();
			String query = "SELECT * FROM product WHERE name = '" + name + "'";
			ResultSet rs = db.select(query);
			if (!rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Sets the quantity of the product.
	 * @param quantity
	 */
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	/**
	 * Returns the quantity of the product.
	 * @return quantity
	 */
	public int getQuantity(){
		return this.quantity;
	}

	/**
	 * Adds quantity to the product.
	 * @param quantity
	 */
	public void addQuantity(int quantity){
		this.quantity += quantity;
	}
	
	/**
	 * Removes quantity of the product.
	 * @param quantity
	 */
	public void removeQuantity(int quantity){
		this.quantity -= quantity;
	}
	
	/**
	 * Returns the price as a formated string.
	 * @return
	 */
	public String formatPrice(){
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(this.price)+",-";
	}
	
	/**
	 * Returns the product comment.
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

}
