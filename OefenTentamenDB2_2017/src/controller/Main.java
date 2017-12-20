package controller;

import java.util.List;

import javadb.DBaccess;
import javadb.OfficialDAO;

import model.Official;

public class Main {

	private DBaccess db;
	private OfficialDAO dao;

	public Main() {
		super();
		db = new DBaccess();
		dao = new OfficialDAO(db);
	}

	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}

	private void run() {
	
		try {
			db.openConnection();
			System.out.println("Connection open");
		} 
		catch (Exception e) {
			System.out.println("\nEr is iets fout gegaan\n");
			e.printStackTrace();
		}
		
		
//		Maak een Official object aan en sla die op in de database.
//		Haal de medewerkers van NED uit de database en print alle medewerkers uit.
//		De Official class heeft een toString() methode die je hierbij kunt gebruiken.
//
//c.    Om het programma te testen moet je in de Main class een Official object aanmaken met jouw voor- en achternaam met officialId = 9 en role = referee en dit object opslaan in de database. Kopieer hier de juiste regels code.
//
//
        Official official = new Official(0, "Dominic", "Dingena", "NED", "referee");
        dao.storeOfficial(official);
// 
// Voeg ook code toe in de Main class om alle Medewerkers uit Nederland uit de database op te halen en uit te printen. Kopieer hier de juiste regels code.
        List<Official> officials = dao.getOfficialByCountryCode("NED");
        for(Official o: officials){
            System.out.println(o);
        }
        
		db.closeConnection();
        System.out.println("Connection closed");

	}
}
