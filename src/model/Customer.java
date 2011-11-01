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
	private String adress;
	private String postcode;
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
		String adress, String postcode) {
		this.forename = forename;
		this.lastname = lastname;
		this.phone = phone;
		this.adress = adress;
		this.postcode = postcode;		
	}
	
	/**
	 * Adds the customer to the database.
	 */
	public void addToDatabase(){
		if (!customerIsUnike(phone)){
			updateCustomer();
			return;
		}
		try{
			Database db = Database.getDatabase();
			String query = "INSERT INTO customer (forename, lastname, phone, adress, postcode) " +
			  			   "VALUES ('" + forename + "','" + lastname + "','" + phone + "','"
			  			   + adress + "','" + postcode +"')";
			idCustomer = db.insertWithIdReturn(query);
		} catch (SQLException e)  {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates a customer in the database.
	 */
	private void updateCustomer(){
		try{
			Database db = Database.getDatabase();
			String query = "UPDATE customer SET forename='" + this.forename + "', lastname='" 
							+ this.lastname + "', adress='" + this.adress + "', postcode='" 
							+ this.postcode + "'";
			idCustomer = db.insertWithIdReturn(query);
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
			String query = "SELECT * FROM customers WHERE phone = '" + phone + "'";
			ResultSet rs = db.select(query);
			if (!rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Customer> getRelevantCustomers(String query){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			Database db = Database.getDatabase();
			ResultSet rs = db.select("SELECT * FROM customer where forename like '" + query + "%'" +
									"or lastname like '" + query + "%' or phone like '" + query + "%'");
			while (rs.next()){
				String forename = rs.getString("forename");
				String lastname = rs.getString("lastname");
				String phone = rs.getString("phone");
				String adress = rs.getString("adress");
				String postcode = rs.getString("postcode");
				Customer c = new Customer(forename, lastname, phone, adress, postcode);
				customers.add(c);
			}
			return customers;
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
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getIdCustomer(){
		return this.idCustomer;
	}
	
}
