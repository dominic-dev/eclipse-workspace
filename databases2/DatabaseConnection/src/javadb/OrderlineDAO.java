package javadb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Orderline;

public class OrderlineDAO {
    private DBaccess db;

    public OrderlineDAO(DBaccess db){
        this.db = db;
    }

	public void storeOrderline(Orderline orderline, int orderId) {
        String sql = "insert into Bestelregel(bestelnr, artikelcode, aantal) values (?, ?, ?)";
        try {
            PreparedStatement st = db.getStatementWithKey(sql);
            System.out.println(st);
            st.setInt(1, orderId);
            st.setString(2, orderline.getProduct().getProductId());
            st.setInt(3, orderline.getAmount());
            db.executeInsertPreparedStatement(st);
            System.out.println("ploep");
		} catch (SQLException e) {
            System.out.println("pwap");
			System.out.println("SQL error " + e.getMessage());
		}
	}

}
