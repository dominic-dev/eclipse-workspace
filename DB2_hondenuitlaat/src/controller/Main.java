package controller;

import java.util.ArrayList;

import javadb.DBaccess;
import javadb.HondDAO;
import javadb.KlantDAO;

import model.Hond;
import model.Klant;

public class Main {

	private DBaccess db;
	private KlantDAO kdao;
	private HondDAO hdao;
	private static final String DASHED_LINE = "------------------------";

	public Main() {
		super();
		db = new DBaccess();
		kdao = new KlantDAO(db);
		hdao = new HondDAO(db);
	}

	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}

	private void run() {
	
		try {
			db.openConnection();
			System.out.println("Connection open...");
			System.out.println(DASHED_LINE);
		} 
		catch (Exception e) {
			System.out.println("\nEr is iets fout gegaan\n");
			e.printStackTrace();
		}
		
		System.out.println(DASHED_LINE);

        Klant klant = new Klant("Dominic", "", "Dingena", 107954151);
        //kdao.storeKlant(klant);
        //System.out.println(klant.getKlantNr());

        klant = kdao.getKlantById(4);
        System.out.println(klant);

        Hond hond = hdao.getHondByChipNr("4");
        System.out.println(hond);
        System.out.println(hond.getKlant());

        for (int i = 1; i <= 5; i++) {
            klant = kdao.getKlantById(i);
            System.out.println("Honden van " + klant);
            ArrayList<Hond> honden = hdao.getHondByKlant(klant);
            for (Hond h : honden) {
                System.out.println(h);
            }
        }
		
        System.out.println("Connection closed.");
		db.closeConnection();

	}
}
