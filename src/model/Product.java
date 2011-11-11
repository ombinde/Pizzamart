package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class for products.
 * @author sigurd
 *
 */
public class Product {
	
	private String name;
	private double price;
	private int idproduct;
	private String comment;
	

	/**
	 * Creates a new Product with a given name and price.
	 * @param name
	 * @param price
	 */
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT idproduct, comments FROM product WHERE name='" 
									+ name + "' and price ='" + price + "'");
			if (rs.next()){
				this.idproduct = rs.getInt("idproduct");
				this.comment = rs.getString("comments");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Creates a new Product with a given name, price, comment and id.
	 * @param name
	 * @param price
	 * @param id
	 */
	public Product (String name, double price, int id, String comment){
		this.name = name;
		this.price = price;
		this.idproduct = id;
		this.comment = comment;
	}

	/**
	 * Returns the name of the product as a String.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the price as a double.
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	/**
	 * Returns the productid of a product.
	 * @return
	 */
	public int getIdproduct(){
		return idproduct;
	}
	
	/**
	 * Returns the product name from the database with the given id.
	 * @param productID
	 * @return
	 * @throws SQLException
	 */
	public static String getProductName(int productID) throws SQLException{
		String name = null;
		Database db = Database.getDatabase();
		ResultSet rs = db.select("SELECT name FROM product WHERE idproduct = " + productID);
		while (rs.next()){
			name = rs.getString(1);
		}
		return name;
	}
	
	/**
	 * Returns the product price from the database with the given id.
	 * @param productID
	 * @return
	 * @throws SQLException
	 */
	public static String getProductPrice(int productID) throws SQLException{
		String price = null;
		Database db = Database.getDatabase();
		ResultSet rs = db.select("SELECT price FROM product WHERE idproduct = " + productID);
		while (rs.next()){
			price = rs.getString(1);
		}
		return price;
	}
	
	/**
	 * Takes a product name in and returns a product with the values from the database.
	 * Returns null if no products exists in the database with that name.
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public static Product dbGetProduct(String name) throws SQLException{
		Database db = Database.getDatabase();
		ResultSet rs = db.select("SELECT * FROM product WHERE name='" + name + "'");
		if (rs.next()){
			int id = rs.getInt("idproduct");
			double price = rs.getDouble("price");
			String comment = rs.getString("comments");
			return new Product(name, price, id, comment);
		}
		return null;
	}
	
	/**
	 * Adds a product to the database with the given name and price
	 * if the product does not already exist.
	 * @param name
	 * @param price
	 * @return true if the product was sucsessfully added, and false if the product already exists.
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
			String query = "DELETE FROM product where name='" + p.name + "')";
			db.insert(query);
			return true;
		} catch (SQLException e) {
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
							"', comment='" + comment +"' WHERE name='" + p.name + "')";
			db.insert(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return false;		
	}
	
	/**
	 * Checks that the product doesn't already exist in the database.
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
	 * Returns an ArrayList with the relevant products to the query.
	 * @param query
	 * @return
	 */
	public static ArrayList<Product> getRelevantProducts(String query){
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM product where name LIKE '" + query + "%'");
			while (rs.next()){
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				if(name.equals("Frakt"))
					products.add(DeliveryFee.getDeliveryFee());
				else
					products.add(new Product(name, price));
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Product> getAllProducts(){
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM product ORDER BY name ASC");
			while (rs.next()){
				products.add(new Product(rs.getString("name"), rs.getDouble("price")));
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String toString(){
		return this.name;
	}
	
	public String formatPrice(){
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(this.price)+",-";
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
