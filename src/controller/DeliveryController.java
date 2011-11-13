package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Order;
import model.Product;

public class DeliveryController {
	
	/**
	 * Returns all the orders that is either ready for delivery or that delivery is going on.
	 * @return
	 */
	public static ArrayList<Order> getFreshOrders(){
		ArrayList<Order> freshOrders= Order.getRelevantOrders("Klar til levering", "Under levering");
		return freshOrders;
	}
	

	/**
	 * Sets the order status to finished. The order is delivered.
	 * @param order
	 */
	public static void setFinishedOrder(Order order){
		order.setStatus("Levert");
	}
	
	/**
	 * Sets the order status to under delivery. Delivery is going on.
	 * @param order
	 */
	public static void startOrder(Order order){
		order.setStatus("Under levering");
	}

}
