package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.*;
public class ChefController {
	
	//helpe metode til
	private ArrayList<Integer> getOrdersById(){
		ArrayList<Integer> freshOrders = new ArrayList<Integer>();
		try {
			Database db;
			db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM orders WHERE status='Bestilt'");
			while(rs.next()){
				freshOrders.add(rs.getInt("idorder"));
			}
			return freshOrders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<HashMap<Product,Integer>> getFreshOrders(){
		ArrayList<HashMap<Product,Integer>> freshOrders= new ArrayList<HashMap<Product, Integer>>();
		ArrayList<Integer> idOrders = getOrdersById();
		for(int i=0; i<idOrders.size(); i++){
			Order.getProductsFromOrdre(idOrders.get(i));
		}
		return freshOrders;
	}
}
