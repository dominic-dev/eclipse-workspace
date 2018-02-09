package javadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO {
	
	private DBaccess db;

	public StudentDAO(DBaccess db) {
		super();
		this.db = db;
	}
	
	public void storeStudent(Student student) {
		String sql = "insert into Student(studentnr, s_voornaam, s_tussenvoegsel, s_achternaam, adres, postcode, woonplaats) values(?,?,?,?,?,?,?);";
		try {
			PreparedStatement ps = db.getStatementWithKey(sql);
			ps.setInt(1, student.getStudentId());
			ps.setString(2, student.getFirstName());
			ps.setString(3, student.getAffix());
			ps.setString(4, student.getLastName());
			ps.setString(5, student.getAddress());
			ps.setString(6, student.getPostalCode());
			ps.setString(7, student.getCity());
			db.executeInsertPreparedStatement(ps);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
  	}
	
	public List<Student> getStudentByCity(String city) {
		List<Student> result = new ArrayList<Student>();
		String sql = "Select * from student where woonplaats = ?;";
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setString(1, city);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			while (rs.next()) {
				int studentId = rs.getInt("studentnr");
				String firstName = rs.getString("s_voornaam");
				String affix = rs.getString("s_tussenvoegsel");
				String lastName = rs.getString("s_achternaam");
				String address = rs.getString("adres");
				String postalCode = rs.getString("postcode");
	            Student student = new Student(studentId, firstName, affix, lastName, address, postalCode, city);
				result.add(student);
			}
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
	
}
