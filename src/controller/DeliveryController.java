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
	public static ArrayList<HashMap<Product,Integer>> getFreshOrders(){
		ArrayList<HashMap<Product,Integer>> freshOrders= new ArrayList<HashMap<Product, Integer>>();
		ArrayList<Integer> idOrders = Order.getOrdersById("Klar til levering", "Leveres");
		for(int i=0; i<idOrders.size(); i++){
			freshOrders.add(Order.getProductsFromOrder(idOrders.get(i)));
		}
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
