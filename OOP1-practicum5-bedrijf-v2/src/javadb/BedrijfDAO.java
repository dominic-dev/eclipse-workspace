package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Bedrijf;
import models.Persoon;

public class BedrijfDAO {

    public Bedrijf getBedrijfByName(String name){
        String sql = "select * from Bedrijf where naam = ?";
        String naam = "";
        try {
            PreparedStatement st = DB.getStatement(sql);
            st.setString(1, name);
            ResultSet rs = DB.executeSelectPreparedStatement(st);
            while(rs.next()){
                naam = rs.getString("naam");
            }
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
        return new Bedrijf(naam);
    }


	public void storeBedrijf(Bedrijf bedrijf) {
        String sql = "insert into Bedrijf (?)";
        try {
            PreparedStatement st = DB.getStatementWithKey(sql);
            st.setString(1, bedrijf.getNaam());
            DB.executeInsertPreparedStatement(st);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}   
  	}

    public ArrayList<Persoon> getWerknemers(String naam){
        ArrayList<Persoon> werknemers = new ArrayList<>();
        String sql = "select * from Persoon p where bedrijf = ? inner join Bedrijf b on b.naam = p.bedrijf inner join Werknemer w on w.persoon_nr = p.persoon_nr inner join Manager m on m.persoon_nr = w.persoon_nr";
        try {
            PreparedStatement st = DB.getStatement(sql);
            st.setString(1, naam);
            ResultSet rs = DB.executeSelectPreparedStatement(st);
            while(rs.next()){
            }
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
        return werknemers;


    }

}
