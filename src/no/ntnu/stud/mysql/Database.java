package no.ntnu.stud.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.Error;
/**
 * Creates a connection with the database with the singleton pattern.
 * @author Sigurd Lund and Øivind Binde
 *
 */
public class Database {
	
	public static Database ref;
	private Connection con=null;
	public static final String HOSTNAME = "mysql.stud.ntnu.no";
	public static final String USERNAME = "sigurlu_it1901";
	public static final String DATABASE = "sigurlu_pizzamart";
	public static final String PASSWORD = "pizza";
	public static final String PORT = "3306";
	
	/**
	 * A constructor that should be called if the connection with the database doesn't exist.
	 */
	private Database() {
		try {
			String url= "jdbc:mysql://" + HOSTNAME + "/" + DATABASE;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, USERNAME, PASSWORD);
		} catch (Exception e) {
			Error.showErrorMessage("Error: Kunne ikke koble til databasen. \n" +
								"Forsikre deg om at du har internettilkobling, og prøv igjen.");
			System.exit(0);
		}
	}
	/**
	 * Is the method for creating the database connection.
	 * It calls the private constructor if the connection doesn't already exist.
	 * If the connection is already made, it will just return that.
	 * @return database
	 */
	public static Database getDatabase() {
		if(ref == null){
			ref = new Database();
		}
		return ref;
	}
	
	/**
	 * Cloning is not supported with the singleton pattern.
	 */
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	/**
	 * Gets the connection with the database.
	 * @return connection
	 */
	public Connection getConnection(){
		return con;
	}
	
	/**
	 * Takes in a String that is the query and executes it. 
	 * @param query
	 */
	public void insert(String query) {
		PreparedStatement sporring;
		try {
			sporring = con.prepareStatement(query);
			sporring.executeUpdate();
		} catch (SQLException e) {
			Error.databaseError();
		}
	}
	
	/**
	 * Takes a query and executes it on the database. If the database generated a key
	 * with the inserted data, you will get this key back.
	 * @param query
	 * @return generated key
	 */
	public int insertWithIdReturn(String query) {
		PreparedStatement q;
		try {
			q = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			q.executeUpdate();
			ResultSet rs = q.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			Error.databaseError();
		}
		return 0;
	}
	
	/**
	 * Takes in a String that is the query, and return the ResultSet of the query.
	 * @param query
	 * @return ResultSet
	 */
	public ResultSet select(String query) {
		ResultSet rs = null;
		PreparedStatement sporring;
		try {
			sporring = con.prepareStatement(query);
			rs = sporring.executeQuery();
		} catch (SQLException e) {
			Error.databaseError();
		}
		return rs;
	}
}
