package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Werknemer;

public class WerknemerDAO {

    public Werknemer getWerknemerById(int id){
        String sql = "select * from Werknemer w inner join Persoon p on p.persoon_nr = w.persoon_nr where persoon_nr = ?";
        Werknemer werknemer = null;
        try {
            PreparedStatement st = DB.getStatement(sql);
            st.setInt(1, id);
            ResultSet rs = DB.executeSelectPreparedStatement(st);
            while(rs.next()){
                int persoonNr = rs.getInt("persoon_nr");
                String naam = rs.getString("naam");
                double salaris = rs.getDouble("salaris");
                werknemer = new Werknemer(salaris, naam);
                werknemer.setPersoonNr(persoonNr);
            }
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
        return werknemer;
    }


	public void storeWerknemer(Werknemer werknemer) {
        String sql = "insert into Werknemer (?)";
        try {
            PreparedStatement st = DB.getStatementWithKey(sql);
            st.setString(1, werknemer.getNaam());
            int key = DB.executeInsertPreparedStatement(st);
            werknemer.setPersoonNr(key);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}   
  	}

}
