package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class for products.
 * @author sigurd
 *
 */
public class Product {
	
	private String name;
	private double price;
	private int idproduct;
	
	/**
	 * Creates a new Product with a given name and price.
	 * @param name
	 * @param price
	 */
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Creates a new Product with a given name, price and id.
	 * @param name
	 * @param price
	 * @param id
	 */
	public Product (String name, double price, int id){
		this.name = name;
		this.price = price;
		this.idproduct = id;
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
		ResultSet rs = db.select("SELECT name FROM product where idproduct = " + productID);
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
		ResultSet rs = db.select("SELECT price FROM product where idproduct = " + productID);
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
		ResultSet rs = db.select("SELECT * FROM product where name='" + name + "'");
		if (rs.next()){
			int id = rs.getInt("idproduct");
			double price = rs.getDouble("price");
			return new Product(name, price, id);
		}
		return null;
	}
	
	/**
	 * Adds a product to the database with the given name and price
	 * if the product does not already exist.
	 * @param name
	 * @param price
	 * @return 1 if the product was sucsessfully added, and 0 if the product already exists.
	 */
	public static int addProductToDatabase(String name, double price){
		if (prodictIsUnike(name)){
			try {
				Database db = Database.getDatabase();
				String query = "INSERT INTO product (name, price) " +
				  			   "VALUES ('"+ name + "', '" + price + "')";
				db.insert(query);
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
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
	
	

}
