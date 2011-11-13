package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * A class for customers.
 * @author sigurd
 *
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
	 * Creates a new customer and adds it to the database.
	 * @param forename
	 * @param lastname
	 * @param phone
	 * @param adress
	 * @param postcode
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
	public int addToDatabase(){
		if (!customerIsUnike(phone)){
			updateCustomer();
			return 2;
		}
		try{
			Database db = Database.getDatabase();
			String query = "INSERT INTO customer (forename, lastname, phone, address, postcode, postaladdress) " +
			  			   "VALUES ('" + forename + "','" + lastname + "','" + phone + "','"
			  			   + address + "','" + zipCode +"','" + postalAddress + "')";
			idCustomer = db.insertWithIdReturn(query);
			return 1;
		} catch (SQLException e)  {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Updates a customer in the database.
	 */
	private void updateCustomer(){
		try{
			Database db = Database.getDatabase();
			String query = "UPDATE customer SET forename='" + this.forename + "', lastname='" 
							+ this.lastname + "', address='" + this.address + "', postcode='" 
							+ this.zipCode + "' WHERE phone='" + this.phone + "'";
			db.insert(query);
			ResultSet rs = db.select("SELECT idcustomer from customer WHERE phone = '" + this.phone + "'");
			if (rs.next()){
				idCustomer = rs.getInt("idcustomer");
			}
		} catch (SQLException e)  {
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks that the customer does not already exist in the database.
	 * A phone number can only have one customer.
	 * @param phone
	 * @return
	 */
	private boolean customerIsUnike(String phone){
		try {
			Database db = Database.getDatabase();
			String query = "SELECT * FROM customer WHERE phone = '" + phone + "'";
			ResultSet rs = db.select(query);
			if (!rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<Customer> getRelevantCustomers(String query){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM customer where forename like '" + query + "%'" +
									"or lastname like '" + query + "%' or phone like '" + query + "%'");
			while (rs.next()){
				String forename = rs.getString("forename");
				String lastname = rs.getString("lastname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String zipCode = rs.getString("postcode");
				String postalAddress = rs.getString("postaladdress");
				Customer c = new Customer(forename, lastname, phone, address, zipCode, postalAddress);
				customers.add(c);
			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Customer getCustomerFromOrder(int idCustomer){
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM customer WHERE idcustomer=" + idCustomer);
			if (rs.next()){
				String forename = rs.getString("forename");
				String lastname = rs.getString("lastname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String zipCode = rs.getString("postcode");
				String postalAddress = rs.getString("postaladdress");
				Customer c = new Customer(forename, lastname, phone, address, zipCode, postalAddress, idCustomer);
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getForename() {
		return forename;
	}
	
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getzipCode() {
		return zipCode;
	}
	
	public void setzipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getIdCustomer(){
		return this.idCustomer;
	}
	
	public String getPostalAddress(){
		return postalAddress;
	}
	
}
