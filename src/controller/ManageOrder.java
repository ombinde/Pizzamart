package controller;
import java.util.HashMap;

import model.Customer;
import model.Order;
import model.Product;

public class ManageOrder {
	
	public static Customer addNewCustomer(String forename, String lastname, String adress, String postcode, String phone){
		return new Customer(forename, lastname, phone, adress, postcode);
	}
	
	public static Order addNewOrder(Customer customer){
		return new Order(customer);
	}
	
	public static void addProductToOrder(Order order, Product product, int quantity){
		order.addProductToOrder(product, quantity);
	}
	public static void  addOneMoreProductToOrdre(Order order, Product product){
		addProductToOrder(order, product, 1);
	}
	
	/**
	 * Searches for products matching the query in the database and return the result as a
	 * hashmap with name and price of the products
	 * @param query
	 * @return
	 */
	public static HashMap<String, Double> getRelevantProducts(String query){
		return Order.getRelevantProducts(query);
	}
	
	public static void submitOrderToDatabase(Order order){
		
		if(order.addOrderToDatabase()==1){
			//add jLabel feedback
			System.out.println("Order was submitted successfully!");
		}
		else
			System.out.println("Order was NOT submitted due to some funky error.");
		
	}
	

}
