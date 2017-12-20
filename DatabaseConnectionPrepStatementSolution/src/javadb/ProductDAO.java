package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {

	private DBaccess db;

	public ProductDAO(DBaccess db) {
		super();
		this.db = db;
	}

	public void storeProduct(Product product) {
		String sql = "insert into Artikel(artikelcode, artikelnaam, btwtarief, artikelprijs, voorraad) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getTaxGroup());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStockAmount());
			db.executeUpdatePreparedStatement(ps);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
	}

	public Product getProductByID(String id) {
		String sql = "Select * from Artikel where artikelcode = ?";
		Product result = null;
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setString(1, id);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			
			while (rs.next()) {
				String productId = rs.getString("artikelcode");
				String productName = rs.getString("artikelnaam");
				String tax = rs.getString("btwtarief");
				double price = rs.getDouble("artikelprijs");
				int stock = rs.getInt("voorraad");
				result = new Product(productId, productName, tax, price, stock);
			}
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}

	public List<Product> getProductByTaxgroup(String group) {
		String sql = "Select * from Artikel where btwtarief = ?";
		
		List<Product> result = new ArrayList<Product>();
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setString(1, group);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			
			while (rs.next()) {
				String productId = rs.getString("artikelcode");
				String productName = rs.getString("artikelnaam");
				String tax = rs.getString("btwtarief");
				double price = rs.getDouble("artikelprijs");
				int stock = rs.getInt("voorraad");
				Product resultElement = new Product(productId, productName, tax, price, stock);
				result.add(resultElement);
			}
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}

}
