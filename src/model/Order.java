package model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Order {
	
	private Customer customer;
	private HashMap<Product, Integer> productsInOrder;
	private String status;
	private String idorder;
	
	public Order(Customer customer, HashMap<Product, Integer> products, String status){
		this.customer = customer;
		this.productsInOrder = products;
		this.status = status;
	}
	
	public Order(Customer customer){
		this.customer = customer;
	}
	public HashMap<Product, Integer> getProductsFromOrdre(){
		return this.productsInOrder;
	}
	
	public double getOrderTotalPrice(Order order){
		double totalprice = 0;
	    Iterator it = productsInOrder.entrySet().iterator();
	    while(it.hasNext()){
	    	Product p = (Product) it.next();
	    	int quantity = productsInOrder.get(p);	
	        totalprice += p.getPrice()*quantity;
	    }
		return totalprice;
	}
	
	public int getProductQuanta(Product product){
	    if(productsInOrder.containsKey(product))
	    	return productsInOrder.get(product);
	    return 0;
	}
	
	public void addOrderToDatabase(){
		try {
			Database db = Database.getDatabase();
			String query = "INSERT INTO orders (status) " +
			  			   "VALUES ('"+this.status + "')";
			db.insert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addProductToOrder(Product product, int quantity){
		productsInOrder.put(product, quantity);
	}
	
	public void setStatus(String status){
		this.status = status;
		try {
			Database db = Database.getDatabase();
			String query = "INSERT INTO orders (status) " +
			  			   "VALUES ('"+this.status + ")";
			db.insert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
