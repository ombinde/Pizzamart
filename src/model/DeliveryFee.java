package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;

public class DeliveryFee extends Product {

	private DeliveryFee(String name, double price) {
		super(name, price);
	}
	
	public static DeliveryFee getDeliveryFee(){
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM product WHERE name='Frakt'");
			if (rs.next()){
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				return new DeliveryFee(name, price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
