package Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Class.Employee;

public class Test {

	public static void main(String[] args) throws SQLException, IOException {
		
		
		Database db = Database.getDatabase();
		System.out.println("Database kobling er opprettet");
		Connection con = db.getConnection();
		
		
		BufferedReader br = new BufferedReader(new FileReader("/home/sigurd/dummydata.sql"));
		
		ScriptRunner sr = new ScriptRunner(con, false, true);
		sr.runScript(br);
//
//		
//		System.out.println(db.getConnection());
//		System.out.println(db.select("SELECT etternavn FROM ansatt"));
//		db.insert("INSERT into ansatt (fornavn, etternavn, adresse, postnr, tlf) values('Per', 'Ludviksen', 'Høgskoloeringen 3', '7050','87654321') ");
//		System.out.println(db.select("SELECT etternavn FROM ansatt"));

//		con.close();
		
		Employee emp = new Employee("heiii", "Ola", "Nordmann");
		ArrayList<String> list = new ArrayList<String>();
		ResultSet rs = db.select("SELECT * FROM employee");
		
		while (rs.next())
			System.out.println(rs.getString(2));

	}
	
	
	
	
}
