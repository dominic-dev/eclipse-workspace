package controller;

import java.sql.SQLException;
import java.util.List;

import javadb.ProductDAO;
import javadb.CustomerDAO;
import javadb.DBaccess;
import javadb.OrderDAO;
import model.Customer;
import model.Order;
import model.Product;

public class Main {

	private DBaccess db;
	private ProductDAO pdao;
	private CustomerDAO cdao;
	private OrderDAO odao;
	private static final String DASHED_LINE = "------------------------";

	public Main() {
		super();
		db = new DBaccess();
		pdao = new ProductDAO(db);
		cdao = new CustomerDAO(db);
		odao = new OrderDAO(db);
	}

	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}

	private void run() {
	
		try {
			db.openConnection();
			System.out.println("Connection open");
			System.out.println(DASHED_LINE);
		} 
		catch (Exception e) {
			System.out.println("\nEr is iets fout gegaan\n");
			e.printStackTrace();
		}
		
//		Customer sdb = new Customer("de Boer", "Kerkdriel");
//		cdao.storeCustomer(sdb);
//		System.out.println(sdb);
		
		Customer wieIs = cdao.getCustomerById(9);
		System.out.println(wieIs);
		System.out.println(DASHED_LINE);
		
		List<Customer> customers = cdao.getCustomerByCity("Haarlem");
		System.out.println("Klanten uit Haarlem: ");
		for (Customer c : customers) {
			System.out.println(c);
		}
		System.out.println(DASHED_LINE);
		
		Order order9 = odao.getOrderWithDetailsById(9);
		System.out.println(order9);
		
		
//		Product tv = new Product("A9","Sony A6300", "hoog", 1099.99, 6);
//		dao.storeProduct(tv);
//		
//		
//		String id = "A5";
//		Product product = dao.getProductByID(id);
//		if (product == null) {
//				System.out.println("Product with productId " + id + " does not exist");
//			}
//		else {
//			System.out.println(product);
//		}
//		
//		List<Product> products = dao.getProductByTaxgroup("hoog");
//		for (Product p : products) {
//			System.out.println(p);
//		}
		
		db.closeConnection();

	}
}
