package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.*;
public class ChefController {
		
	public ArrayList<HashMap<Product,Integer>> getFreshOrders(){
		ArrayList<HashMap<Product,Integer>> freshOrders= new ArrayList<HashMap<Product, Integer>>();
		ArrayList<Integer> idOrders = Order.getOrdersById("Bestilt");
		for(int i=0; i<idOrders.size(); i++){
			freshOrders.add(Order.getProductsFromOrdre(idOrders.get(i)));
		}
		return freshOrders;
	}
}