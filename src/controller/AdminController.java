package controller;

import java.util.ArrayList;

import model.DeliveryFee;
import model.Product;

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
	public static boolean removeProduct(Product p){
		return Product.removeProductFromDatabase(p);
	}
	
	/**
	 * Returns all the products from the database.
	 * @return
	 */
	public static ArrayList<Product> getAllProducts(){
		return Product.getAllProducts();
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
	public static boolean setLimitFreeDelivery(double price){
		return DeliveryFee.setLimitDeliveryFeeInDB(price);
	}

}
