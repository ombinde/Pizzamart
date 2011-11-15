package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Database;
import model.DeliveryFee;
import model.Product;
import model.Properties;

/**
 * Controller for the admin pages.
 * @author sigurd
 *
 */
public class AdminController {
	
	/**
	 * Adds a product to the database.
	 * Returns true if the product is added, and false if something went wrong.
	 * If the product isn't added it's most likely already exist.
	 * @param name
	 * @param price
	 * @param comment
	 * @return
	 */
	public static boolean addProduct(String name, double price, String comment){
		return Product.addProductToDatabase(name, price, comment);
	}
	
	/**
	 * Deletes a product from the database.
	 * Returns true if the product was deleted, else it's false.
	 * @param p
	 * @return
	 */
	public static boolean deleteProduct(Product p){
		return Product.deleteProductFromDatabase(p);
	}
	
	/**
	 * Returns all the products from the database.
	 * @return
	 */
	public static ArrayList<Product> getRelevantProducts(String query){
		return Product.getRelevantProducts(query);
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
		return Product.updateProduct(p, name, price, comment);
	}
	
	/**
	 * Sets the limit for when delivery is going to be free.
	 * Returns true if the value was updated, and false if not.
	 * @param price
	 * @return
	 */
	public static boolean setRestaurantProperties(String name, String address, String zipCode, 
												  	String postalAddress, String phone, double limitFreeDelivery){
		try {
			Database db = Database.getDatabase();
			String query = "UPDATE properties SET limitFreeDelivery='" + limitFreeDelivery + "', name='" + name + "', " +
						"address='" + address + "', postcode='" + zipCode + "', postaladdress='" + postalAddress + "', phone='" + phone + "'";
			db.insert(query);
			System.out.println("Oppdatert");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Properties getProperties(){
		return Properties.getProperties();
	}

}
