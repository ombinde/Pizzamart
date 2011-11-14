package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import model.*;
import controller.DeliveryController;
import controller.ManageEmployee;
import controller.ManageOrder;

public class Test {

	public static void main(String[] args) throws SQLException, IOException {
		
		
		Database db = Database.getDatabase();
		System.out.println("Database kobling er opprettet");
		Connection con = db.getConnection();
		Locale locale = new Locale("no");
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Oslo");
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeZone(timeZone);
		Date dateAdded = calendar.getTime();
		DateFormat df = DateFormat.getTimeInstance(3, locale);

		ArrayList<Order> orders = Order.getAllOrders();
		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i).getDate());
		}
		
		ArrayList<String> addresser = DeliveryController.getAddressForMap();
		for (String string : addresser) {
			System.out.println(string);
		}
		
		System.out.println(ManageOrder.getLimitFreeDelivery());
		System.out.println(ManageOrder.getDeliveryFee());

	}
	
	
	
	
}
