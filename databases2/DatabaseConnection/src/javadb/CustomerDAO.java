package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerDAO{
    private DBaccess db;

    public CustomerDAO(DBaccess db){
        this.db = db;
    }

    public void storeCustomer(Customer customer){
        String sql = "insert into Klant (klantnaam, plaats) values (?, ?)";
        try {
            PreparedStatement st = db.getStatementWithKey(sql);
            st.setString(1, customer.getName());
            st.setString(2, customer.getCity());
            int key = db.executeInsertPreparedStatement(st);
            customer.setId(key);
            System.out.println(String.format("Inserted customer %s with key %d", customer, key));
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
    }

    public Customer getCustomerById(int id){
        Customer customer = new Customer();
        String sql = "select * from Klant where klantnr = ?";
        try {
            PreparedStatement st = db.getStatement(sql);
            st.setInt(1, id);
            ResultSet rs = db.executeSelectPreparedStatement(st);
            while(rs.next()){
                customer.setId(rs.getInt("klantnr"));
                customer.setName(rs.getString("klantnaam"));
                customer.setCity(rs.getString("plaats"));
            }
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
        return customer;
    }

    public ArrayList<Customer> getCustomerByCity(String city){
        ArrayList<Customer> customers = new ArrayList<>();
        String sql = "select * from Klant where plaats = ?";
        try {
            PreparedStatement st = db.getStatement(sql);
            st.setString(1, city);
            ResultSet rs = db.executeSelectPreparedStatement(st);
            while(rs.next()){
                Customer customer = new Customer(
                        rs.getInt("klantnr"),
                        rs.getString("klantnaam"),
                        rs.getString("plaats")
                        );
                customers.add(customer);
            }
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
        return customers;

    }

}
