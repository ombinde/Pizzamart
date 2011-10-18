package controller;
import model.Employee; 

public class ManageEmployee {

	public static void addNewEmployee(String username, String forename, String lastname){
		new Employee(username, forename, lastname);
	}
	
	
}

	