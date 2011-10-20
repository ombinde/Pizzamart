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
		
		if(order.addOrderToDatabase()==1){
			//add jLabel feedback
			System.out.println("Order was submitted successfully!");
		}
		else
			System.out.println("Order was NOT submitted due to some funky error.");
		
	}
	

}
