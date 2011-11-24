package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import no.ntnu.stud.mysql.Database;

import view.Error;

/**
 * A class for customers.
 */
public class Customer {

	private String forename;
	private String lastname;
	private String phone;
	private String address;
	private String zipCode;
	private String postalAddress;
	private int idCustomer;

	/**
	 * Creates a new customer.
	 * 
	 * @param forename
	 * @param lastname
	 * @param phone
	 * @param address
	 * @param zipCode
	 */
	public Customer(String forename, String lastname, String phone,
			String address, String zipCode, String postalAddress) {

		this.forename = forename;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
		this.zipCode = zipCode;
		this.postalAddress = postalAddress;
	}

	/**
	 * Creates a new Customer with all the variables including the id of the
	 * customer in the database. This should be used if you need to initialize
	 * an already existing customer.
	 * 
	 * @param forename
	 * @param lastname
	 * @param phone
	 * @param address
	 * @param zipCode
	 * @param postalAddress
	 * @param idCustomer
	 */
	public Customer(String forename, String lastname, String phone,
			String address, String zipCode, String postalAddress, int idCustomer) {

		this.forename = forename;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
		this.zipCode = zipCode;
		this.postalAddress = postalAddress;
		this.idCustomer = idCustomer;
	}

	/**
	 * Adds the customer to the database.
	 */
	public void addToDatabase() {
		if (!customerIsUnike(phone)) {
			updateCustomer();
			return;
		}
		Database db = Database.getDatabase();
		String query = "INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress) "
				+ "VALUES ('"
				+ forename
				+ "','"
				+ lastname
				+ "','"
				+ phone
				+ "','"
				+ address
				+ "','"
				+ zipCode
				+ "','"
				+ postalAddress
				+ "')";

		idCustomer = db.insertWithIdReturn(query);
	}

	/**
	 * Updates a customer in the database.
	 */
	private void updateCustomer() {
		Database db = Database.getDatabase();
		String query = "UPDATE customer SET forename='" + this.forename
				+ "', lastname='" + this.lastname + "', address='"
				+ this.address + "', postcode='" + this.zipCode
				+ "' WHERE phone='" + this.phone + "'";

		db.insert(query);
		ResultSet rs = db
				.select("SELECT idcustomer from customer WHERE phone = '"
						+ this.phone + "'");
		try {
			if (rs.next()) {
				idCustomer = rs.getInt("idcustomer");
			}
		} catch (SQLException e) {
			Error.databaseError();
		}
	}

	/**
	 * Checks that the customer does not already exist in the database. A phone
	 * number can only have one customer.
	 * 
	 * @param phone
	 *            The phone number of a customer.
	 * @return boolean True if the customer is unike, and false else.
	 */
	private boolean customerIsUnike(String phone) {
		Database db = Database.getDatabase();
		String query = "SELECT * FROM customer WHERE phone = '" + phone + "'";

		ResultSet rs = db.select(query);
		try {
			if (!rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			Error.databaseError();
		}
		return false;
	}

	/**
	 * Takes a query in as a String and asks the database for relevant customers
	 * to the query. The query will be matched on first name, last name and
	 * phone number.
	 * 
	 * @param query
	 * @return ArrayList with the customers.
	 */
	public static ArrayList<Customer> getRelevantCustomers(String query) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Database db = Database.getDatabase();
		ResultSet rs = db.select("SELECT * FROM customer where forename like '"
				+ query + "%'" + "or lastname like '" + query
				+ "%' or phone like '" + query + "%' ORDER BY forename ASC");
		try {
			while (rs.next()) {
				String forename = rs.getString("forename");
				String lastname = rs.getString("lastname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String zipCode = rs.getString("postcode");
				String postalAddress = rs.getString("postaladdress");
				Customer c = new Customer(forename, lastname, phone, address,
						zipCode, postalAddress);
				customers.add(c);
			}
		} catch (SQLException e) {
			Error.databaseError();
		}
		return customers;
	}

	/**
	 * Takes a id of an customer and looks up in the database and check if the
	 * customer exist. The customer will be returned with all the info from the
	 * database.
	 * 
	 * @param idCustomer
	 * @return customer
	 */
	public static Customer getCustomerFromOrder(int idCustomer) {
		Database db = Database.getDatabase();
		ResultSet rs = db.select("SELECT * FROM customer WHERE idcustomer="
				+ idCustomer);
		try {
			if (rs.next()) {
				String forename = rs.getString("forename");
				String lastname = rs.getString("lastname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String zipCode = rs.getString("postcode");
				String postalAddress = rs.getString("postaladdress");
				Customer c = new Customer(forename, lastname, phone, address,
						zipCode, postalAddress, idCustomer);
				return c;
			}
		} catch (SQLException e) {
			Error.databaseError();
		}
		return null;
	}

	/**
	 * Returns the forename of a customer.
	 * 
	 * @return forename
	 */
	public String getForename() {
		return forename;
	}

	/**
	 * Returns the last name of a customer.
	 * 
	 * @return last name
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Returns the phone number of a customer.
	 * 
	 * @return phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Returns the address of a customer.
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns the zip code of a customer
	 * 
	 * @return zipCode
	 */
	public String getzipCode() {
		return zipCode;
	}

	/**
	 * Returns the id of a customer.
	 * 
	 * @return idCustomer
	 */
	public int getIdCustomer() {
		return this.idCustomer;
	}

	/**
	 * Returns the postal address of a customer.
	 * 
	 * @return postal address
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	/**
	 * Returns the whole name of a customer.
	 * 
	 * @return name
	 */
	public String getName() {
		return forename + " " + lastname;
	}

}
