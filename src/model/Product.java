package model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Product {
	
	private String name;
	private double price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public static String getProductName(int productID) throws SQLException{
		String name = null;
		Database db = Database.getDatabase();
		ResultSet rs = db.select("SELECT name FROM product where idproduct = " + productID);
		while (rs.next()){
			name = rs.getString(1);
		}
		return name;
	}
	
	public static String getProductPrice(int productID) throws SQLException{
		String price = null;
		Database db = Database.getDatabase();
		ResultSet rs = db.select("SELECT price FROM product where idproduct = " + productID);
		while (rs.next()){
			price = rs.getString(1);
		}
		return price;
	}
	
	

}
