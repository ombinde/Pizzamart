package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.*;
public class ChefController {
	
	//returnerer all nye ordrer
	public static ArrayList<HashMap<Product,Integer>> getFreshOrders(){
		ArrayList<HashMap<Product,Integer>> freshOrders= new ArrayList<HashMap<Product, Integer>>();
		ArrayList<Integer> idOrders = Order.getOrdersById("Bestilt");
		for(int i=0; i<idOrders.size(); i++){
			freshOrders.add(Order.getProductsFromOrder(idOrders.get(i)));
		}
		return freshOrders;
	}
	//input: tar et ordre-objekt
	//setter status pŒ ordre til 
	public static void setFinishedOrder(Order order){
		order.setStatus("laget ferdig");
	}
	public static void startOrder(Order order){
		order.setStatus("ordre pŒbegynt");
	}
		
}
