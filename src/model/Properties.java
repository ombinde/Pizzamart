package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Properties {
	
	private static String name;
	private static String address;
	private static String zipCode;
	private static String postalAddress;
	private static String phone;
	private static double limitFreeDelivery;
	private static Properties properties;
	
	private Properties(String name, String address, String zipCode,
						String postalAddress, String phone, double limitFreeDelivery) {
		Properties.name = name;
		Properties.address = address;
		Properties.zipCode = zipCode;
		Properties.postalAddress = postalAddress;
		Properties.phone = phone;
		Properties.limitFreeDelivery = limitFreeDelivery;
	}
	
	public static Properties getProperties(){
		if (properties!=null)
			return properties;
		else{
			try {
				Database db;
				db = Database.getDatabase();
				ResultSet rs = db.select("SELECT * FROM properties");
				if (rs.next()){
					double limitFreeDelivery = rs.getDouble("limitFreeDelivery");
					String name = rs.getString("name");
					String address = rs.getString("address");
					String zipCode = rs.getString("postcode");
					String postalAddress = rs.getString("postaladdress");
					String phone = rs.getString("phone");
					properties = new Properties(name, address, zipCode, postalAddress, phone, limitFreeDelivery);
				}
				return properties;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public static void setProperties(String name, String address, String zipCode, 
		  				String postalAddress, String phone, double limitFreeDelivery){
		try {
			Database db = Database.getDatabase();
			String query = "UPDATE properties SET limitFreeDelivery='" + limitFreeDelivery + "', name='" + name + "', " +
						"address='" + address + "', postcode='" + zipCode + "', postaladdress='" + postalAddress + "', phone='" 
						+ phone + "'";
			db.insert(query);
			properties = new Properties(name, address, zipCode, postalAddress, phone, limitFreeDelivery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getName() {
		if (properties==null)
			getProperties();
		return name;
	}
	public static String getAddress() {
		if (properties==null)
			getProperties();
		return address;
	}
	public static String getZipCode() {
		if (properties==null)
			getProperties();
		return zipCode;
	}
	public static String getPostalAddress() {
		if (properties==null)
			getProperties();
		return postalAddress;
	}
	public static String getPhone() {
		if (properties==null)
			getProperties();
		return phone;
	}
	public static double getLimitFreeDelivery() {
		if (limitFreeDelivery==0)
			getProperties();
		return limitFreeDelivery;
	}
}
