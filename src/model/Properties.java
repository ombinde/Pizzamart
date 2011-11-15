package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Properties {
	
	private String name;
	private String address;
	private String zipCode;
	private String postalAddress;
	private String phone;
	private double limitFreeDelivery;
	private static Properties properties;
	
	private Properties(String name, String address, String zipCode,
			String postalAddress, String phone, double limitFreeDelivery) {
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.postalAddress = postalAddress;
		this.phone = phone;
		this.limitFreeDelivery = limitFreeDelivery;
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
			}
			return null;
		}
	}
	
	
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public String getPhone() {
		return phone;
	}
	public double getLimitFreeDelivery() {
		return limitFreeDelivery;
	}

}
