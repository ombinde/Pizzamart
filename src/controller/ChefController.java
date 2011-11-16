package controller;

import java.util.ArrayList;
import model.*;

public class ChefController {
	
	/**
	 * Returns all the orders that is ready for cooking or being cooked.
	 * @return
	 */
	public static ArrayList<Order> getFreshOrders(){
		ArrayList<Order> freshOrders= Order.getRelevantOrders("Bestilt", "Lages");
		return freshOrders;
	}
	
	/**
	 * Sets the order status to it's finished in the kitchen.
	 * If the order is going to be delivered, it's set to "Klar til levering",
	 * and if the customer is going to get it self, it's set to "Klar til henting".
	 * @param order object
	 */
	public static void setFinishedOrder(Order order){
		if (order.getDelivery())
			order.setStatus("Klar til levering");
		else
			order.setStatus("Klar til henting");
	}
	
	/**
	 * Sets the order status to that the cook has started making it.
	 * @param order is an order object
	 */
	public static void startOrder(Order order){
		order.setStatus("Lages");
	}
		
}
