package no.ntnu.stud.it1901.group8.controller;

import java.util.ArrayList;

import no.ntnu.stud.it1901.group8.model.Customer;
import no.ntnu.stud.it1901.group8.model.Order;

/**
 * Controller for the delivery.
 */
public class DeliveryController {

	/**
	 * Returns all the orders that is either ready for delivery or that delivery
	 * is going on.
	 * 
	 * @return freshOrders as an array list
	 */
	public static ArrayList<Order> getFreshOrders() {
		ArrayList<Order> freshOrders = Order.getRelevantOrders(
				"Klar til levering", "Under levering");
		return freshOrders;
	}

	/**
	 * Sets the order status to finished. The order is delivered.
	 * 
	 * @param order
	 */
	public static void setFinishedOrder(Order order) {
		order.setStatus("Levert");
	}

	/**
	 * Sets the order status to under delivery. Delivery is going on.
	 * 
	 * @param order
	 */
	public static void startOrder(Order order) {
		order.setStatus("Under levering");
	}

	/**
	 * Returns a array list with all the addresses and the zip codes as a
	 * String.
	 * 
	 * @return arraylist with all the addresses
	 */
	public static ArrayList<String> getAddressForMap() {
		ArrayList<Order> freshOrders = getFreshOrders();
		ArrayList<String> addresses = new ArrayList<String>();
		for (int i = 0; i < freshOrders.size(); i++) {
			Customer temp = freshOrders.get(i).getCustomer();
			addresses.add(temp.getAddress() + " " + temp.getzipCode());
		}
		return addresses;
	}

}
