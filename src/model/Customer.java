package model;

import java.sql.SQLException;


public class Customer {

	private String forename;
	private String lastname;
	private String phone;
	private String adress;
	private String postcode;
	
	
	public Customer(String forename, String lastname, String phone,
			String adress, String postcode) {
		this.forename = forename;
		this.lastname = lastname;
		this.phone = phone;
		this.adress = adress;
		this.postcode = postcode;
		addToDatabase();
	}
	
	private void addToDatabase(){
		try{
			Database db = Database.getDatabase();
			String query = "INSERT INTO customer (forename, lastname, phone, adress, postcode) " +
			  			   "VALUES ('" + forename + "','" + lastname + "','" + phone + "','"
			  			   + adress + "','" + postcode +"')";
			db.insert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	
	
}
