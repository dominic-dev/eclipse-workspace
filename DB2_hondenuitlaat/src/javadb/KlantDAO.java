package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Klant;
import model.Klant;
import model.Product;

public class KlantDAO {

	private DBaccess db;

	public KlantDAO(DBaccess db) {
		super();
		this.db = db;
	}

	// in de database heeft tabel Klant een autonummering, bij de insert geen
	// klantnr meegeven
	// vraag aan Database de key terug, daarom executeInsertPS gebruiken
	public void storeKlant(Klant klant) {
		String sql = "insert into Klant(voorletters, voorvoegsels, achternaam, telefoon) values(?,?,?,?);";
		try {
			PreparedStatement ps = db.getStatementWithKey(sql);
			ps.setString(1, klant.getVoorletters());
			ps.setString(2, klant.getVoorvoegsel());
			ps.setString(3, klant.getAchternaam());
			ps.setInt(4, klant.getTelefoon());
			int generatedKey = db.executeInsertPreparedStatement(ps);
            klant.setKlantNr(generatedKey);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
	}

	public Klant getKlantById(int id) {
		String sql = "Select * from Klant where klantnr = ?;";
		Klant result = null;
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			if (rs.next()) {
				int klantNr = rs.getInt("klantnr");
				String voorletters = rs.getString("voorletters");
                String voorvoegsels = rs.getString("voorvoegsels");
                String achternaam = rs.getString("achternaam");
                int telefoon = rs.getInt("telefoon");
				result = new Klant(voorletters, voorvoegsels, achternaam, telefoon);
                result.setKlantNr(klantNr);
			} else
				System.out.println("Klant met dit nummer bestaat niet");
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
	
	public List<Klant> getKlantByCity(String city) {
		String sql = "Select * from Klant where plaats = ?";
		
		List<Klant> result = new ArrayList<Klant>();
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setString(1, city);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			
			while (rs.next()) {
				int klantId = rs.getInt("klantnr");
				String klantName = rs.getString("klantnaam");
				String klantCity = rs.getString("plaats");
				Klant resultElement = new Klant(klantId, klantName, city);
				result.add(resultElement);
			}
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
}
