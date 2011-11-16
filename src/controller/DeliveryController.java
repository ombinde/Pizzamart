package controller;

import java.util.ArrayList;
import model.Customer;
import model.Order;

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
	
	public static ArrayList<String> getAddressForMap(){
		ArrayList<Order> freshOrders = getFreshOrders();
		ArrayList<String> addresses = new ArrayList<String>();
		for (int i = 0; i < freshOrders.size(); i++) {
			Customer temp = freshOrders.get(i).getCustomer();
			addresses.add(temp.getAddress() + " " + temp.getzipCode());
		}
		return addresses;
	}

}
