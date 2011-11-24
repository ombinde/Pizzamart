package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import no.ntnu.stud.mysql.Database;

import view.Error;

/**
 * A class for restaurant properties. It uses the singleton pattern to make sure
 * that only one instance of the object exists.
 * 
 */
public class Properties {

	private static String name;
	private static String address;
	private static String zipCode;
	private static String postalAddress;
	private static String phone;
	private static double limitFreeDelivery;
	private static Properties properties;

	/**
	 * Creates a instance of the properties Object.
	 * 
	 * @param name
	 * @param address
	 * @param zipCode
	 * @param postalAddress
	 * @param phone
	 * @param limitFreeDelivery
	 */
	private Properties(String name, String address, String zipCode,
			String postalAddress, String phone, double limitFreeDelivery) {
		Properties.name = name;
		Properties.address = address;
		Properties.zipCode = zipCode;
		Properties.postalAddress = postalAddress;
		Properties.phone = phone;
		Properties.limitFreeDelivery = limitFreeDelivery;
	}

	/**
	 * If the properties object is already initialized the object will be
	 * returned. Else it ill first construct it, and then return it.
	 * 
	 * @return Properties
	 */
	public static Properties getProperties() {
		if (properties != null)
			return properties;
		else {
			Database db;
			db = Database.getDatabase();
			try {
				ResultSet rs = db.select("SELECT * FROM properties");
				if (rs.next()) {
					double limitFreeDelivery = rs
							.getDouble("limitFreeDelivery");
					String name = rs.getString("name");
					String address = rs.getString("address");
					String zipCode = rs.getString("postcode");
					String postalAddress = rs.getString("postaladdress");
					String phone = rs.getString("phone");
					properties = new Properties(name, address, zipCode,
							postalAddress, phone, limitFreeDelivery);
				}
				return properties;
			} catch (SQLException e) {
				Error.databaseError();
				return null;
			}
		}
	}

	/**
	 * Deletes the previous properties from the database, and inserts the new
	 * data.
	 * 
	 * @param name
	 * @param address
	 * @param zipCode
	 * @param postalAddress
	 * @param phone
	 * @param limitFreeDelivery
	 */
	public static void setProperties(String name, String address,
			String zipCode, String postalAddress, String phone,
			double limitFreeDelivery) {
		Database db = Database.getDatabase();
		db.insert("DELETE FROM properties");
		String query = "INSERT INTO properties (limitFreeDelivery, name, address, postcode, postaladdress, phone) values('"
				+ limitFreeDelivery
				+ "','"
				+ name
				+ "','"
				+ address
				+ "','"
				+ zipCode + "','" + postalAddress + "','" + phone + "')";
		db.insert(query);
		properties = new Properties(name, address, zipCode, postalAddress,
				phone, limitFreeDelivery);
	}

	/**
	 * Returns the restaurant name.
	 * 
	 * @return name
	 */
	public static String getName() {
		if (properties == null)
			getProperties();
		return name;
	}

	/**
	 * Returns the address of the restaurant.
	 * 
	 * @return address
	 */
	public static String getAddress() {
		if (properties == null)
			getProperties();
		return address;
	}

	/**
	 * Returns the zip code of the restaurant.
	 * 
	 * @return zipcode
	 */
	public static String getZipCode() {
		if (properties == null)
			getProperties();
		return zipCode;
	}

	/**
	 * Returns the postal address of the restaurant.
	 * 
	 * @return postal address
	 */
	public static String getPostalAddress() {
		if (properties == null)
			getProperties();
		return postalAddress;
	}

	/**
	 * Returns the phone number of the restaurant.
	 * 
	 * @return phone number
	 */
	public static String getPhone() {
		if (properties == null)
			getProperties();
		return phone;
	}

	/**
	 * Returns the limit for when the delivery should be free.
	 * 
	 * @return limitFreeDelivery
	 */
	public static double getLimitFreeDelivery() {
		if (limitFreeDelivery == 0)
			getProperties();
		return limitFreeDelivery;
	}
}
