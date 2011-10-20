package model;

import java.sql.SQLException;
import java.util.HashMap;

public class Order {
	
	private Customer customer;
	private HashMap<Product, Integer> productsInOrder;
	private String status;
	private int idorder;
	
	public Order(Customer customer, HashMap<Product, Integer> products, String status){
		this.customer = customer;
		this.productsInOrder = products;
		this.status = status;
	}
	
	public Order(Customer customer){
		this.customer = customer;
		this.status = "Under bestilling";
	}
	public static HashMap<Product, Integer> getProductsFromOrdre(int id){
		Database db = Database.getDatabase();
		ResultSet rs = db.select("SELECT * FROM )
		
		
		
		return this.productsInOrder;
	}
	
	public double getOrderTotalPrice(Order order){
		double totalprice = 0;
	    for (Object p : productsInOrder.keySet()) {
	    	if (p instanceof Product){
		    	int quantity = productsInOrder.get(p);	
		        totalprice += ((Product) p).getPrice()*quantity;
	    	}
	    }
		return totalprice;
	}
	
	public int getProductQuanta(Product product){
	    if(productsInOrder.containsKey(product))
	    	return productsInOrder.get(product);
	    return 0;
	}
	
	public void addOrderToDatabase(){
		Integer quantity = 0;
		try {
			Database db = Database.getDatabase();
			String query = "INSERT INTO orders (status) " +
			  			   "VALUES ('"+this.status + "')";
			idorder = db.insertWithIdReturn(query);
		    for (Object p : productsInOrder.keySet()) {
		    	if (p instanceof Product){
			    	quantity = productsInOrder.get(p);
			    	int idproduct = ((Product) p).getIdproduct();
			    	query = "INSERT INTO product_has_order (product_idproduct, orders_idorder, quantity) " +
			    	"values('" + idproduct + "','" + idorder + "','" + quantity + "')";
			    	db.insert(query);
		    	}
			}
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
			String query = "UPDATE orders SET status='" + status + "' WHERE idorder=" + idorder;
			db.insert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
