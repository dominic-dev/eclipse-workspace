package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Official;

public class OfficialDAO {
	
	private DBaccess db;

	public OfficialDAO(DBaccess db) {
		super();
		this.db = db;
	}
	
	public void storeOfficial(Official official) {
        String sql = "insert into medewerker(voornaam, achternaam, landcode, functie) values (?, ?, ?, ?)";
        try {
            PreparedStatement st = db.getStatementWithKey(sql);
            //st.setInt(1, official.getOfficialId());
            st.setString(1, official.getFirstName());
            st.setString(2, official.getLastName());
            st.setString(3, official.getCountryCode());
            st.setString(4, official.getRole());
            int key = db.executeInsertPreparedStatement(st);
            official.setOfficialId(key);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}   
  	}
	

	
	public List<Official> getOfficialByCountryCode(String code) {
		String sql = "select * from medewerker where landcode = ?";
		List<Official> result = new ArrayList<Official>();
		try { 
            PreparedStatement st = db.getStatement(sql);
            st.setString(1, code);
            ResultSet rs = db.executeSelectPreparedStatement(st);
            while(rs.next()){
                int id = rs.getInt("idMedewerker");
                String voornaam = rs.getString("voornaam");
                String achternaam = rs.getString("achternaam");
                String landcode = rs.getString("landcode");
                String functie = rs.getString("functie");
                Official official = new Official(id, voornaam, achternaam, landcode, functie);
                result.add(official);
            }
        }
		catch (SQLException e){
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
	
}
