package controller;

import java.util.ArrayList;
import model.Order;
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
	 * @param name product name
	 * @param price product price
	 * @param comment product comment
	 * @return true if the product is added, and false if something went wrong.
	 */
	public static boolean addProduct(String name, double price, String comment){
		return Product.addProductToDatabase(name, price, comment);
	}
	
	/**
	 * Deletes a product from the database.
	 * @param p is product 
	 * @return true if the product was deleted, else it's false.
	 */
	public static boolean deleteProduct(Product p){
		return Product.deleteProductFromDatabase(p);
	}
	
	/**
	 * Deletes
	 * @param o is order
	 * @return true if the order was deleted, else it's false.
	 */
	public static void deleteOrder(Order o){
		Order.deleteOrderFromDatabase(o);
	}
	
	/**
	 * Returns all the products from the database.
	 * @param query is string that should specify a productname
	 * @return arraylist of productnames that match the search string
	 */
	public static ArrayList<Product> getRelevantProducts(String query){
		return Product.getRelevantProducts(query);
	}
	
	/**
	 * Updates a product p in the database with the given parameters. 
	 * @param p is product
	 * @param name is product name
	 * @param price is product price
	 * @param comment is product description
	 * @return true if the product was updated successfully. And false if something unexpected happened.
	 */
	public static boolean updateProduct(Product p, String name, double price, String comment){
		return Product.updateProduct(p, name, price, comment);
	}
	
	/**
	 * Sets the limit for when delivery is going to be free.
	 * @param name restaurant name
	 * @param address restaurant address
	 * @param zipCode restaurant zipcode
	 * @param postalAddress restaurant postalAddress
	 * @param phone restaurant phone
	 * @param limitFreeDelivery limit for when free delivery will take place.
	 * @return true if the value was updated, and false if not
	 */
	public static void setRestaurantProperties(String name, String address, String zipCode, 
												  	String postalAddress, String phone, double limitFreeDelivery){
		Properties.setProperties(name, address, zipCode, postalAddress, phone, limitFreeDelivery);
	}
	
	public static Properties getProperties(){
		return Properties.getProperties();
	}

}
