package model;

import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * A class for employees. Takes in an username, forename and the last name of an employee.
 * It checks that the user doesn't exist in the database before, and adds it to the database if it's unik.
 * @author sigurd
 *
 */

public class Employee {
	
	private String username;
	private String forename;
	private String lastname;
	
	public Employee(String username, String forename, String lastname) {
		this.username = username;
		this.forename = forename;
		this.lastname = lastname;
		if (userIsUnike())
			addUserToDatabase();
	}
	
	private void addUserToDatabase(){
		try {
			Database db = Database.getDatabase();
			String query = "INSERT INTO employee (username, forename, lastname) " +
			  			   "VALUES ('"+this.username+"', '"+this.forename+"', '"+this.lastname+"')";
			db.insert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean userIsUnike(){
		try {
			Database db = Database.getDatabase();
			String query = "SELECT * FROM employee WHERE username = '" + username + "'";
			ResultSet rs = db.select(query);
			if (!rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getForename() {
		return forename;
	}
	
	public String getLastname() {
		return lastname;
	}

}
