package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.Orderline;
import model.Product;

public class OrderlineDAO {

	private DBaccess db;

	public OrderlineDAO(DBaccess db) {
		super();
		this.db = db;
	}
	
	public void storeOrderline(Orderline ol) {
		String sqlOrderline = "insert into bestelregel(bestelnr, artikelcode, aantal) values(?,?,?)";
		try {
			PreparedStatement ps = db.getStatement(sqlOrderline);
			ps.setInt(1, ol.getOrder().getOrderId());
			ps.setString(2, ol.getOrderedProduct().getProductId());
			ps.setInt(5, ol.getNumberOrdered());
			db.executeUpdatePreparedStatement(ps);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
	}
	
	public List<Orderline> getOrderlineByOrderId(int orderId) {
		// Haal de bestelregels uit de database van een specifieke order
		String sql = "Select * from Bestelregel where bestelnr = ?";
		List<Orderline> result = new ArrayList<Orderline>();
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			
			while (rs.next()) {
				String productId = rs.getString("artikelcode");
				// Haal het artikel uit de database en maak een Product object
				Product product = new ProductDAO(db).getProductByID(productId);
				int numberOrdered = rs.getInt("aantal");
				// Haal de bestelling van de bestelregels uit de database en maak een order zonder details
				Order order = new OrderDAO(db).getOrderById(orderId);
				Orderline resultElement = new Orderline(product, numberOrdered, order);
				// Bereken de prijs van de Orderline
				resultElement.setTotalPrice();
				result.add(resultElement);
			}
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
}
