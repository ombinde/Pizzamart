package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;
/**
 * Class for deliveryFee.
 * It uses the singleton patters to make sure that only one deliveryfee exist.
 * @author sigurd
 *
 */
public class DeliveryFee extends Product {
	
	private static DeliveryFee deliveryFee;
	private static double originalFee;
	/**
	 * Constructor that creates a product with the given name, price and comment.
	 * @param name
	 * @param price
	 */
	private DeliveryFee(String name, double price, String comment) {
		super(name, price, 1, comment);
		originalFee = price;
	}
	
	/**
	 * Returns the deliveryFee product. It looks up in the database if the deliveryFee isn't already loaded.
	 * @return
	 */
	public static DeliveryFee getDeliveryFee(){
		if (deliveryFee!=null)
			return deliveryFee;
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM product WHERE name='Frakt'");
			if (rs.next()){
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				String comment = rs.getString("comments");
				deliveryFee = new DeliveryFee(name, price, comment);
				return deliveryFee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setPriceToOriginal(){
		this.setPrice(originalFee);
	}
	
	public static double getOriginalFee(){
		if (deliveryFee==null){
			DeliveryFee df = DeliveryFee.getDeliveryFee();
		}
		return originalFee;
	}
	
	/**
	 * Sets the limit for free delivery. It looks up in the database for the value.
	 */
	public static double getLimitFreeDelivery(){
		double limitFreeDelivery = -1;
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT limitFreeDelivery FROM properties");
			if (rs.next())
				limitFreeDelivery = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return limitFreeDelivery;
	}


	
}
