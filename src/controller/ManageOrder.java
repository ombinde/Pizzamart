package controller;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import model.Customer;
import model.Order;
import model.Product;
import model.Product;

/**
 * A controller for orders.
 * @author Sigurd Lund and Øivind Binde
 *
 */
public class ManageOrder {
	
	/**
	 * Creates a new Customer with all fields.
	 * @param forename
	 * @param lastname
	 * @param phone
	 * @param address
	 * @param zipCode
	 * @param postalAddress
	 * @return customer
	 */
	public static Customer addNewCustomer(String forename, String lastname, String phone,
			String address, String zipCode, String postalAddress){
		return new Customer(forename, lastname, phone,
							address, zipCode, postalAddress);
	}
	
	/**
	 * Adds a Customer to the database.
	 * @param customer
	 */
	public static void addCustomerToDatabase(Customer c){
		int feedback = c.addToDatabase();
		if (feedback==1){
			System.out.println("Customer was added");
		}
		else if(feedback==2){
			System.out.println("Customer was just updated since he already exist");
		}
		else{
			System.out.println("Something went wrong");
		}
	}
	
	/**
	 * Creates a new Order with only the Customer in it.
	 * @param customer
	 * @return order
	 */
	public static Order addNewOrder(Customer customer){
		return new Order(customer);
	}
	
	/**
	 * Adds product to the order. Quantity is specified.
	 * @param order
	 * @param product
	 * @param quantity
	 */
	public static void addProductToOrder(Order order, Product product, int quantity){
		order.addProductToOrder(product, quantity);
	}
	
	/**
	 * Adds one product to the order.
	 * @param order
	 * @param product
	 */
	public static void  addOneMoreProductToOrder(Order order, Product product){
		order.addProductToOrder(product, 1);
	}
	
	/**
	 * Removes one product from the order.
	 * @param order
	 * @param product
	 */
	public static void removeOneProductFromOrder(Order order, Product product){
		order.removeProductFromOrder(product, 1);
	}
	
	/**
	 * Sets the order to be either delivered or not.
	 * @param order
	 */
	public static void setDelivery(Order order, boolean b){
		order.setDelivery(b);
	}
	
	/**
	 * Sets the order to have an allergic customer or not
	 * @param order
	 */
	public static void setAllergy(Order order, boolean b){
		order.setAllergy(b);
	}
	
	/**
	 * Returns all the products in the order.
	 * It's a HashMap where product is the key, and quantity is the value.
	 * @param order
	 * @return productsInOrder
	 */
	public static ArrayList<Product> getProductsInOrder(Order order){
		return order.getProductsInOrder();
	}
	
	/**
	 * Searches for products matching the query in the database and return the result as a
	 * hashmap with name and price of the products
	 * @param query
	 * @return relevantProducts
	 */
	public static ArrayList<Product> getRelevantProducts(String query){
		return Product.getRelevantProducts(query);
	}
	
	/**
	 * Returns an ArrayList with the relevant customers.
	 * @param query
	 * @return customer
	 */
	public static ArrayList<Customer> getRelevantCustomers(String query){
		return Customer.getRelevantCustomers(query);
	}
	
	/**
	 * Returns the total price of an order.
	 * @param order
	 * @return totalPrice
	 */
	public static double getTotalPrice(Order order){
		return order.getOrderTotalPrice();
	}
	
	/**
	 * Adds the order to the database.
	 * @param order
	 */
	public static void submitOrderToDatabase(Order order){
		
		if(order.addOrderToDatabase()==1){
			//add jLabel feedback
			System.out.println("Order was submitted successfully!");
		}
		else
			System.out.println("Order was NOT submitted due to some funky error.");
	}
	
	/**
	 * Formats the price to a String with two decimals.
	 * @param price
	 * @return
	 */
	public static String formatPrice(double price){
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(price)+",-";
	}
	
	

}
