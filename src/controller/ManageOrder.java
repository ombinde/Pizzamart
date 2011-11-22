package controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.Error;

import model.Customer;
import model.DeliveryFee;
import model.Order;
import model.Product;
import model.Properties;

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
		try {
			c.addToDatabase();
		} catch (SQLException e) {
			Error.showMessage("Kunden kunne ikke bli lagt til i databasen.");
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
		try {
			return Customer.getRelevantCustomers(query);
		} catch (SQLException e) {
			Error.databaseError();
			return null;
		}
	}
	
	/**
	 * Returns the total price of an order.
	 * @param order
	 * @return totalPrice
	 */
	public static double getTotalPrice(Order order){
		return order.getOrderTotalPrice();
	}
	
	public static ArrayList<Order> getFinishedOrders(){
		return Order.getFinishedOrders();
	}
	
	/**
	 * Adds the order to the database.
	 * @param order
	 */
	public static void submitOrderToDatabase(Order order){
		order.addOrderToDatabase();
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
	
	/**
	 * Returns the limit for when delivery fee is free.
	 * @return
	 */
	public static double getLimitFreeDelivery(){
		return Properties.getLimitFreeDelivery();
	}
	
	/**
	 * Returns the fee for delivery.
	 * @return
	 */
	public static double getDeliveryFee(){
		return DeliveryFee.getOriginalFee();
	}
	
	public static ArrayList<Order> getOrdersReadyForPickup(){
		return Order.getRelevantOrders("Klar til henting", "--");
	}
	
	public static void setStatusToPickedUp(Order order){
		order.setStatus("Utlevert");
	}
    
    public static void setNextOrBackButton(JLabel button, String text, int choice){
    	Color background, foreground, border;
    	ImageIcon icon;
    	//FinishButton
    	if (choice>0){
    		background = new Color(230, 240, 200);
    		foreground = new Color(64, 80, 25);
    		border = new Color(180, 190, 130);
    		icon = new ImageIcon("src/icons/buy_32.png");
    	}
    	//NextButton
    	else if (choice==0){
    		background = new Color(230, 240, 200);
    		foreground = new Color(64, 80, 25);
    		border = new Color(180, 190, 130);
    		icon = new ImageIcon("src/icons/right_32.png");
    	}
    	//BackButton
    	else {
    		background = new Color(235, 207, 207);
    		foreground = new Color(113, 36, 36);
    		border = new Color(203, 135, 135);
    		icon = new ImageIcon("src/icons/leftred_32.png");
    		button.setText("Tilbake");
    	}
    	button.setIcon(icon);
        button.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(border, 2), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setIconTextGap(10);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(140, 20));
    }
	

}
