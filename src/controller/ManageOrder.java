package controller;
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
	
	public static void submitOrderToDatabase(Order order){
		order.addOrderToDatabase();
	}
	

}
