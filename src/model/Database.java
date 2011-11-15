package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Creates a connection with the database with the singleton pattern.
 * @author Sigurd Lund and �ivind Binde
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
		
//	private Database() throws SQLException{
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost/" + DATABASE + "?user="
//                +  USERNAME
//                + "&password="
//                +  PASSWORD;
//			con = DriverManager.getConnection(url);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	private Database() throws SQLException{
		try {
			String url= "jdbc:mysql://" + HOSTNAME + "/" + DATABASE;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * Is the method for creating the database connection.
	 * It calls the private constructor if the connection doesn't already exist.
	 * If the connection is already made, it will just return that.
	 * @return database
	 * @throws SQLException
	 */
	public static Database getDatabase() throws SQLException{
		if(ref == null){
			ref = new Database();
		}
		return ref;
	}
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
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
		String enavn;
		ResultSet rs = null;
		PreparedStatement sporring = con.prepareStatement(query);
		rs = sporring.executeQuery();

//		try {
//			prep = con.prepareStatement(query);
//			result = prep.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		while (result.next()){
//			result.add(result.getString(1));
//			
//			
//		}
//		while(rs.next()){
//			enavn = rs.getString(column);
//			System.out.println(enavn);
//		}
//		System.out.println(rs);
		return rs;
	}
}
