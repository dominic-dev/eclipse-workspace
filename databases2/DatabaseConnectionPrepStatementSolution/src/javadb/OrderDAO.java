package javadb;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.Order;
import model.Orderline;
import model.Product;

public class OrderDAO {

	private DBaccess db;

	public OrderDAO(DBaccess db) {
		super();
		this.db = db;
	}

	// in de database heeft tabel Bestelling een autonummering, bij de insert
	// geen bestelnr meegeven
	// vraag aan Database de key terug, daarom insertQuery gebruiken
	// De orderregel van een order samen met de order toevoegen aan de database

	public void storeOrder(Order order) {
		// Voeg het order record toe, vraag de key terug en geef order de juiste
		// id
		try {
			String sqlOrder = "insert into bestelling(klantnr, besteldatum) values(?,?)";
			PreparedStatement ps = db.getStatementWithKey(sqlOrder);
			ps.setInt(1, order.getOrderCustomer().getCustomerId());
			ps.setString(2, order.getOrderDate());
			int generatedKey = db.executeInsertPreparedStatement(ps);

			order.setOrderId(generatedKey);

		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}

		// Voeg nu per orderline een record toe aan de orderregel tabel, de
		// orderlines moet het orderId meekrijgen
		OrderlineDAO olDao = new OrderlineDAO(db);
		for (Orderline ol : order.getOrderlines()) {
			ol.getOrder().getOrderId();
			olDao.storeOrderline(ol);
		}
	}

	// Haal alleen de bestelling uit de database zonder bestelregels en maak een Order object
	// zonder Orderlines en totalPriceOrder.
	public Order getOrderById(int id) {
		// Haal de bestelling uit de database.
		String sql = "Select * from Bestelling where bestelnr = ?";
		Order result = null;
		Customer orderCustomer = null;
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			if (rs.next()) {
				int orderId = rs.getInt("bestelnr");
				int customerId = rs.getInt("klantnr");
				String orderDate = rs.getString("besteldatum");
				// Haal de Klant op uit de database.
				orderCustomer = new CustomerDAO(db).getCustomerById(customerId);
				result = new Order(orderCustomer, orderDate);
				result.setOrderId(orderId);
			} else
				System.out.println("Order met dit nummer bestaat niet");
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
	
	//  Haal een bestelling met bestelregels uit de database en bereken de totaalprijs van de Order
	public Order getOrderWithDetailsById(int id) {
		Order result = getOrderById(id);
		List<Orderline> orderDetails = new OrderlineDAO(db).getOrderlineByOrderId(id);
		result.setOrderlines(orderDetails);
		result.setTotalOrderPrice();
		return result;
	}
}
