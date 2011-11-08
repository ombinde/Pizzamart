package controller;
import java.util.ArrayList;
import java.util.HashMap;

import model.Customer;
import model.Order;
import model.Product;

public class ManageOrder {
	
	public static Customer addNewCustomer(String forename, String lastname, String phone,
			String address, String zipCode, String postalAddress){
		return new Customer(forename, lastname, phone,
							address, zipCode, postalAddress);
	}
	
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
	
	
	public static Order addNewOrder(Customer customer){
		return new Order(customer);
	}
	
	public static void addProductToOrder(Order order, Product product, int quantity){
		order.addProductToOrder(product, quantity);
	}
	
	public static void  addOneMoreProductToOrdre(Order order, Product product){
		order.addProductToOrder(product, 1);
	}
	
	public static HashMap<Product, Integer> getProductsInOrder(Order order){
		return order.getProductsInOrder();
	}
	
	/**
	 * Searches for products matching the query in the database and return the result as a
	 * hashmap with name and price of the products
	 * @param query
	 * @return
	 */
	public static ArrayList<Product> getRelevantProducts(String query){
		return Product.getRelevantProducts(query);
	}
	
	public static ArrayList<Customer> getRelevantCustomers(String query){
		return null;
	}
	
	public static double getTotalPrice(Order order){
		return order.getOrderTotalPrice();
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
