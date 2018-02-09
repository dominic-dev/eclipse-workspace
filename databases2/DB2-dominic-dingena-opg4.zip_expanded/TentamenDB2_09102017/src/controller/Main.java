package controller;

import java.util.List;

import javadb.DBaccess;
import javadb.StudentDAO;

import model.Student;

public class Main {

	private DBaccess db;
	private StudentDAO dao;

	public Main() {
		super();
		db = new DBaccess();
		dao = new StudentDAO(db);
	}

	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}

	private void run() {
	
		try {
			db.openConnection();
			System.out.println("Connection open ...");
		} 
		catch (Exception e) {
			System.out.println("\nEr is iets fout gegaan\n");
			e.printStackTrace();
		}
		
		
//		Maak een Student object aan en sla die op in de database.
		Student student = new Student(123, "Dominic", "", "Dingena", "Wulpenhof 7", "2903EV", "Capelle a/d IJssel");   
        dao.storeStudent(student);
//		Haal de studenten uit Amsterdam op uit de database en print alle studenten uit.
        List<Student> studenten = dao.getStudentByCity("Amsterdam");
        for (Student s: studenten) {
            System.out.println(s);
        }
		
		db.closeConnection();

	}
}
