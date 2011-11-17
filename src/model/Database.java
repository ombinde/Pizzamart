package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
	 * @throws SQLException
	 */
	private Database() {
		try {
			String url= "jdbc:mysql://" + HOSTNAME + "/" + DATABASE;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, USERNAME, PASSWORD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Could not connect with the database. \n" +
					"							Make sure your internet connection is OK, and try again");
			System.exit(0);
		}
	}
	/**
	 * Is the method for creating the database connection.
	 * It calls the private constructor if the connection doesn't already exist.
	 * If the connection is already made, it will just return that.
	 * @return database
	 * @throws SQLException
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
	 * @throws SQLException
	 */
	public void insert(String query) throws SQLException{
		PreparedStatement sporring = con.prepareStatement(query);
		sporring.executeUpdate();
	}
	
	/**
	 * Takes a query and executes it on the database. If the database generated a key
	 * with the inserted data, you will get this key back.
	 * @param query
	 * @return generated key
	 * @throws SQLException
	 */
	public int insertWithIdReturn(String query) throws SQLException{
		PreparedStatement q = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		q.executeUpdate();
		ResultSet rs = q.getGeneratedKeys();
		if (rs.next())
			return rs.getInt(1);
		return 0;
	}
	
	/**
	 * Takes in a String that is the query, and return the ResultSet of the query.
	 * @param query
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet select(String query) throws SQLException{
		ResultSet rs = null;
		PreparedStatement sporring = con.prepareStatement(query);
		rs = sporring.executeQuery();
		return rs;
	}
}
