package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.*;
import controller.ManageEmployee;
import controller.ManageOrder;

public class Test {

	public static void main(String[] args) throws SQLException, IOException {
		
		
		Database db = Database.getDatabase();
		System.out.println("Database kobling er opprettet");
		Connection con = db.getConnection();
		
//		
//		BufferedReader br = new BufferedReader(new FileReader("./src/Database/dummydata.sql"));
//		
//		ScriptRunner sr = new ScriptRunner(con, false, true);
//		sr.runScript(br);

		
		
		//ordrelinjen.
		HashMap<Product, Integer> products = new HashMap<Product, Integer>();
		products.put(Product.dbGetProduct("Genoa"), 10);
		products.put(Product.dbGetProduct("Naples"), 5);

		Customer c = new Customer("sigurd", "lund", "9292929", "asdfg", "8956", "Oslo");
		Order order = new Order(c, products, "Bestillt", "Uten gluten");
		order.addOrderToDatabase();
		order.setStatus("Lages");
		System.out.println(order.getOrderTotalPrice());
		
		
		//Teste søk
		ArrayList<Product> relevanteProdukter = new ArrayList<Product>();
		relevanteProdukter = ManageOrder.getRelevantProducts("m");
		System.out.println(relevanteProdukter.toString());
	
			
//		System.out.println(db.getConnection());
//		System.out.println(db.select("SELECT lastname FROM employee"));
//		db.insert("INSERT into employee (forename, lastname, username) values('Per', 'Ludviksen', 'per')");
//		System.out.println(db.select("SELECT lastname FROM employee"));
//		
//		ManageEmployee.addNewEmployee("ombinde", "oivind", "binde");

		//String productname = Product.getProductName(1);
		//System.out.println(productname);
		
		
		Employee emp = new Employee("heiii", "Ola", "Nordmann");
		ArrayList<String> list = new ArrayList<String>();
		ResultSet rs = db.select("SELECT * FROM employee");
		
		while (rs.next())
			System.out.println(rs.getString(2));
		con.close();
	}
	
	
	
	
}
