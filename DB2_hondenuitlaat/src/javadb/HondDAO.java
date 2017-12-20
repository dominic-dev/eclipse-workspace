package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hond;
import model.Klant;

public class HondDAO {

	private DBaccess db;

	public HondDAO(DBaccess db) {
		super();
		this.db = db;
	}

	// in de database heeft tabel Hond een autonummering, bij de insert geen
	// hondnr meegeven
	// vraag aan Database de key terug, daarom executeInsertPS gebruiken
	public void storeHond(Hond hond) {
		String sql = "insert into Hond(chipnr, naam, ras, klantnr) values(?,?,?,?);";
		try {
			PreparedStatement ps = db.getStatementWithKey(sql);
			ps.setString(1, hond.getChipNr());
			ps.setString(2, hond.getHondnaam());
			ps.setString(3, hond.getRas());
			ps.setInt(4, hond.getKlant().getKlantNr());
			db.executeInsertPreparedStatement(ps);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
	}

	public Hond getHondByChipNr(String chipNr) {
		String sql = "Select * from Hond where chipnr = ?;";
		Hond result = null;
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setString(1, chipNr);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			if (rs.next()) {
                String hondnaam = rs.getString("hondnaam");
                String ras = rs.getString("ras");
                int klantNr = rs.getInt("klantnr");
                KlantDAO kdao = new KlantDAO(db);
                Klant klant = kdao.getKlantById(klantNr);
				result = new Hond(chipNr, hondnaam, ras, klant);
			} else
				System.out.println("Hond met dit nummer bestaat niet");
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
	
	public ArrayList<Hond> getHondByKlant(Klant klant) {
		String sql = "Select * from Hond where klantnr = ?;";
		ArrayList<Hond> result = new ArrayList<>();
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setInt(1, klant.getKlantNr());
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			if (rs.next()) {
                String chipNr = rs.getString("chipnr");
                String hondnaam = rs.getString("hondnaam");
                String ras = rs.getString("ras");
				result.add(new Hond(chipNr, hondnaam, ras, klant));
			} else
				System.out.println("Hond met deze klant bestaat niet");
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
}
