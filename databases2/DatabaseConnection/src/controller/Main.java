package controller;

import java.util.List;

import config.Config;

import javadb.CustomerDAO;
import javadb.DBaccess;
import javadb.OrderDAO;
import javadb.ProductDAO;

import model.Customer;
import model.Order;
import model.Orderline;
import model.Product;

public class Main {

	private DBaccess db;
	private ProductDAO pdao;
	private CustomerDAO cdao;
	private OrderDAO odao;
    private Config config = new Config();
	
	public Main() {
		super();
		db = new DBaccess(config);
		pdao = new ProductDAO(db);
		cdao = new CustomerDAO(db);
		odao = new OrderDAO(db);
	}

	public static void main(String[] args) {
		Main myself = new Main();
		       System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
		myself.run();
	}

	private void run() {
	
		try {
			db.openConnection();
			System.out.println("Connection open");
		} 
		catch (Exception e) {
			System.out.println("\nEr is iets fout gegaan\n");
			e.printStackTrace();
		}
		

		
		
		//Product tv = new Product("A9","Sony A6300", "hoog", 1099.99, 6);
		//pdao.storeProduct(tv);
        //
        //
        //Customer klantje = new Customer("klantje", "Plopsaland");
        //cdao.storeCustomer(klantje);
        //
        //Customer klantje = new Customer("kloekak", "Plopsaland");
        //cdao.storeCustomer(klantje);
        //klantje = new Customer("kloekakkliek", "Troef");
        //cdao.storeCustomer(klantje);

        //System.out.println(cdao.getCustomerById(1));
        //System.out.println(cdao.getCustomerByCity("Plopsaland"));
        
        Product tv = pdao.getProductByID("A9");
        Customer customer = cdao.getCustomerById(1);
        System.out.println(customer);

        Order order = new Order(customer);
        order.addOrderline(new Orderline(12, order, tv));
        odao.storeOrder(order);

        /*
		String id = "A9";
		Product product = pdao.getProductByID(id);
		if (product == null) {
				System.out.println("Product with productId " + id + " does not exist");
			}
		else {
			System.out.println(product);
		}
		
		List<Product> products = pdao.getProductByTaxgroup("laag");
		for (Product p : products) {
			System.out.println(p);
		}
        */
		
		db.closeConnection();

	}
}
