package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Order;
import model.Orderline;

public class OrderDAO {
    private DBaccess db;

    public OrderDAO(DBaccess db){
        this.db = db;
    }

    public void storeOrder(Order order){
        String sql = "insert into Bestelling(klantnr, besteldatum) values (?, ?)";
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement st = db.getStatementWithKey(sql);
            System.out.println(order.getCustomer().getId());
            st.setInt(1, order.getCustomer().getId());
            st.setTimestamp(2, date);
            int key = db.executeInsertPreparedStatement(st);
            order.setId(key);
            System.out.println("Order added");

            System.out.println(order.getOrderlines());
            OrderlineDAO oloa = new OrderlineDAO(db);
            for(Orderline orderline : order.getOrderlines()){
                oloa.storeOrderline(orderline, key);
            }
        } catch (SQLException e) {
            System.out.println("SQL error " + e.getMessage());
        }

    }

    public Order getOrderById(int id){
        Order order = new Order();
        String sql = "select * from bestelling where bestelnr= ?";
        try {
            PreparedStatement st = db.getStatement(sql);
            st.setInt(1, id);
            ResultSet rs = db.executeSelectPreparedStatement(st);
            while(rs.next()){
                CustomerDAO cdao = new CustomerDAO(db);
                int customerId = rs.getInt("klantnr");
                order.setCustomer(cdao.getCustomerById(customerId));
                order.setId(rs.getInt("bestelnr"));
                order.setDate(rs.getString("datum"));
            }
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
        return order;
    }

    public Order getOrderByCustomerId(int id){
        Order order = new Order();
        String sql = "select * from bestelling where klantnr= ?";
        try {
            PreparedStatement st = db.getStatement(sql);
            st.setInt(1, id);
            ResultSet rs = db.executeSelectPreparedStatement(st);
            while(rs.next()){
                CustomerDAO cdao = new CustomerDAO(db);
                int customerId = rs.getInt("klantnr");
                order.setCustomer(cdao.getCustomerById(customerId));
                order.setId(rs.getInt("bestelnr"));
                order.setDate(rs.getString("datum"));
            }
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
        return order;

    }
}
