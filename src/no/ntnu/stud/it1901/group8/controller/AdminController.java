package no.ntnu.stud.it1901.group8.controller;

import java.util.ArrayList;

import no.ntnu.stud.it1901.group8.model.Order;
import no.ntnu.stud.it1901.group8.model.Product;
import no.ntnu.stud.it1901.group8.model.Properties;

/**
 * Controller for the administrator pages.
 */
public class AdminController {

	/**
	 * Adds a product to the database. Returns true if the product is added, and
	 * false if something went wrong.
	 * 
	 * @param name
	 *            product name
	 * @param price
	 *            product price
	 * @param comment
	 *            product comment
	 * @return true if the product is added, and false if something went wrong.
	 */
	public static boolean addProduct(String name, double price, String comment) {
		return Product.addProductToDatabase(name, price, comment);
	}

	/**
	 * Deletes a product from the database.
	 * 
	 * @param p
	 *            is product
	 * @return true if the product was deleted, else it's false.
	 */
	public static boolean deleteProduct(Product p) {
		return Product.deleteProductFromDatabase(p);
	}

	/**
	 * Deletes an order from the database.
	 * 
	 * @param o
	 *            is order
	 */
	public static void deleteOrder(Order o) {
		Order.deleteOrderFromDatabase(o);
	}

	/**
	 * Returns all the products from the database.
	 * 
	 * @param query
	 *            is string that should specify a product name
	 * @return arraylist of product names that match the search string
	 */
	public static ArrayList<Product> getRelevantProducts(String query) {
		return Product.getRelevantProducts(query);
	}

	/**
	 * Updates a product p in the database with the given parameters.
	 * 
	 * @param p
	 *            is product
	 * @param name
	 *            is product name
	 * @param price
	 *            is product price
	 * @param comment
	 *            is product description
	 * @return true if the product was updated successfully. And false if
	 *         something unexpected happened.
	 */
	public static boolean updateProduct(Product p, String name, double price,
			String comment) {
		return Product.updateProduct(p, name, price, comment);
	}

	/**
	 * Sets the limit for when delivery is going to be free.
	 * 
	 * @param name
	 *            restaurant name
	 * @param address
	 *            restaurant address
	 * @param zipCode
	 *            restaurant zipcode
	 * @param postalAddress
	 *            restaurant postalAddress
	 * @param phone
	 *            restaurant phone
	 * @param limitFreeDelivery
	 *            limit for when free delivery will take place.
	 */
	public static void setRestaurantProperties(String name, String address,
			String zipCode, String postalAddress, String phone,
			double limitFreeDelivery) {
		Properties.setProperties(name, address, zipCode, postalAddress, phone,
				limitFreeDelivery);
	}

	/**
	 * Returns the properties for the restaurant
	 * 
	 * @return Properties
	 */
	public static Properties getProperties() {
		return Properties.getProperties();
	}

}
