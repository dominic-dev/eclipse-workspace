package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Product;

public class CustomerDAO {

	private DBaccess db;

	public CustomerDAO(DBaccess db) {
		super();
		this.db = db;
	}

	// in de database heeft tabel Klant een autonummering, bij de insert geen
	// klantnr meegeven
	// vraag aan Database de key terug, daarom executeInsertPS gebruiken
	public void storeCustomer(Customer customer) {
		String sql = "insert into Klant(klantnaam, plaats) values(?,?);";
		try {
			PreparedStatement ps = db.getStatementWithKey(sql);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCity());
			int generatedKey = db.executeInsertPreparedStatement(ps);
			customer.setCustomerId(generatedKey);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
	}

	public Customer getCustomerById(int id) {
		String sql = "Select * from Klant where klantnr = ?;";
		Customer result = null;
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			if (rs.next()) {
				int customerId = rs.getInt("klantnr");
				String customerName = rs.getString("klantnaam");
				String city = rs.getString("plaats");
				result = new Customer(customerId,customerName, city);
			} else
				System.out.println("Customer met dit nummer bestaat niet");
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
	
	public List<Customer> getCustomerByCity(String city) {
		String sql = "Select * from Klant where plaats = ?";
		
		List<Customer> result = new ArrayList<Customer>();
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setString(1, city);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			
			while (rs.next()) {
				int customerId = rs.getInt("klantnr");
				String customerName = rs.getString("klantnaam");
				String customerCity = rs.getString("plaats");
				Customer resultElement = new Customer(customerId, customerName, city);
				result.add(resultElement);
			}
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
}
