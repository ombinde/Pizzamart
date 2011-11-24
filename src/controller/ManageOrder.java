package controller;

import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import view.Error;

import com.itextpdf.text.DocumentException;

import model.Customer;
import model.DeliveryFee;
import model.Order;
import model.Product;
import model.Properties;
import model.Receipt;

/**
 * A controller for orders.
 */
public class ManageOrder {

	/**
	 * Creates a new Customer with all fields.
	 * 
	 * @param forename
	 * @param lastname
	 * @param phone
	 * @param address
	 * @param zipCode
	 * @param postalAddress
	 * @return customer
	 */
	public static Customer addNewCustomer(String forename, String lastname,
			String phone, String address, String zipCode, String postalAddress) {
		return new Customer(forename, lastname, phone, address, zipCode,
				postalAddress);
	}

	/**
	 * Adds a Customer to the database.
	 * 
	 * @param customer
	 */
	public static void addCustomerToDatabase(Customer c) {
		c.addToDatabase();
	}

	/**
	 * Creates a new Order with only the Customer in it.
	 * 
	 * @param customer
	 *            is an customer object
	 * @param order
	 *            is an order object
	 */
	public static Order addNewOrder(Customer customer) {
		return new Order(customer);
	}

	/**
	 * Adds product to the order. Quantity is specified.
	 * 
	 * @param order
	 *            is an order object
	 * @param product
	 *            is a product object
	 * @param quantity
	 *            is a integer
	 */
	public static void addProductToOrder(Order order, Product product,
			int quantity) {
		order.addProductToOrder(product, quantity);
	}

	/**
	 * Adds one product to the order.
	 * 
	 * @param order
	 *            is an order object
	 * @param product
	 *            is a product object
	 */
	public static void addOneMoreProductToOrder(Order order, Product product) {
		order.addProductToOrder(product, 1);
	}

	/**
	 * Removes one product from the order.
	 * 
	 * @param order
	 *            is an order object
	 * @param product
	 *            is a product object
	 */
	public static void removeOneProductFromOrder(Order order, Product product) {
		order.removeProductFromOrder(product, 1);
	}

	/**
	 * Sets the order to be either delivered or not.
	 * 
	 * @param order
	 *            is an order object
	 */
	public static void setDelivery(Order order, boolean b) {
		order.setDelivery(b);
	}

	/**
	 * Sets the order to have an allergic customer or not
	 * 
	 * @param order
	 *            is an order object
	 */
	public static void setAllergy(Order order, boolean b) {
		order.setAllergy(b);
	}

	/**
	 * Returns all the products in the order. It's a HashMap where product is
	 * the key, and quantity is the value.
	 * 
	 * @param order
	 *            is an order object
	 * @return productsInOrder
	 */
	public static ArrayList<Product> getProductsInOrder(Order order) {
		return order.getProductsInOrder();
	}

	/**
	 * Searches for products matching the query in the database and return the
	 * result as a arraylist with name and price of the products
	 * 
	 * @param query
	 *            is a string
	 * @return relevantProducts is a arraylist containing products and their
	 *         price
	 */
	public static ArrayList<Product> getRelevantProducts(String query) {
		return Product.getRelevantProducts(query);
	}

	/**
	 * Returns an ArrayList with the relevant customers.
	 * 
	 * @param query
	 *            is string
	 * @return customer is arraylist of customers
	 */
	public static ArrayList<Customer> getRelevantCustomers(String query) {
		return Customer.getRelevantCustomers(query);
	}

	/**
	 * Returns the total price of an order.
	 * 
	 * @param order
	 *            is an order object
	 * @return totalPrice is a double
	 */
	public static double getTotalPrice(Order order) {
		return order.getOrderTotalPrice();
	}

	/**
	 * Returns all orders that are not finished.
	 * 
	 * @return orders in process
	 */
	public static ArrayList<Order> getOrdersInProcess() {
		return Order.getOrdersInProcess();
	}

	/**
	 * Adds the order to the database.
	 * 
	 * @param order
	 *            is an order object
	 */
	public static void submitOrderToDatabase(Order order) {
		order.addOrderToDatabase();
	}

	/**
	 * Updates an existing order in the database.
	 * 
	 * @param order
	 *            is an order object
	 */
	public static void updateExistingOrderInDatabase(Order order) {
		order.updateOrder();
	}

	/**
	 * Formats the price to a String with two decimals.
	 * 
	 * @param price
	 * @return a string formatted with 2 decimals
	 */
	public static String formatPrice(double price) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(price) + ",-";
	}

	/**
	 * Returns the limit for when delivery fee is free.
	 * 
	 * @return fee limit is a double
	 */
	public static double getLimitFreeDelivery() {
		return Properties.getLimitFreeDelivery();
	}

	/**
	 * Returns the fee for delivery.
	 * 
	 * @return delivery fee is a double
	 */
	public static double getDeliveryFee() {
		return DeliveryFee.getOriginalFee();
	}

	/**
	 * Returns all the orders that are ready for pick up.
	 * 
	 * @return orders ready for pick up
	 */
	public static ArrayList<Order> getOrdersReadyForPickup() {
		return Order.getRelevantOrders("Klar til henting", "--");
	}

	/**
	 * Sets the orders status to picked up by customer.
	 * 
	 * @param order
	 *            The order that is picked up.
	 */
	public static void setStatusToPickedUp(Order order) {
		order.setStatus("Utlevert");
	}

	/**
	 * Prints out the receipt.
	 * 
	 * @param order
	 *            The order that should be printed
	 */
	public static void printReceipt(Order order) {
		try {
			Receipt.makeReceipe(order);
			Receipt.openReceipt();
			Receipt.printFile();
		} catch (FileNotFoundException e) {
			Error.showMessage("Finner ikke filen.");
		} catch (DocumentException e) {
			Error
					.showMessage("En feil oppsto under opprettingen av kvitteringen");
		} catch (IOException e) {
			Error
					.showMessage("En feil oppsto under opprettingen av kvitteringen");
		} catch (PrinterException e) {
			Error
					.showMessage("En feil oppsto under sending av kvittering til printer \n "
							+ "Du må være koblet til en standard skriver for at dette skal fungere.");
		}
	}

}
