package main;

import model.Benodigdheid;
import model.Gereedschap;
import model.Hout;

public class Meubelmakerij {
	
	private String naam = "De Schrijn, Langbroek";
	private String website = "www.cursusmeubelmaken.nl";
	private double[] houtOpslag;
	private Benodigdheid[] benodigdheden;
	
	public Meubelmakerij(String naam, String website) {
		super();
		this.naam = naam;
		this.website = website;
		this.houtOpslag = new double [] {2.00, 2.25, 0.80, 3.00};
		benodigdheden = new Benodigdheid[5];
	}

	public static void main(String[] args) {
		Meubelmakerij deSchrijn = new Meubelmakerij("De Schrijn, Langbroek", "www.cursusmeubelmaken.nl");
		deSchrijn.run();
	}
	
	private void run() {
		testStap0();
		testStap1();
		testStap2();
		testStap3();
		testStap4();
	}
	
	private void testStap0() {
		System.out.println("Dit is de OOP1 toets van Dominic Dingena (cohort MIW10 )");
		System.out.println();
	}

	private void testStap1() {
    //	System.out.println("OM STAP 1 TE TESTEN: ON-COMMENTARIEER testStap1() IN Meubelmakerij.java");
		System.out.println("Stap 1:");
		System.out.println("--------------------------------------");
		Benodigdheid ehboKist = new Benodigdheid("EHBO kist", 69.82);
		Benodigdheid pinApparaat = new Benodigdheid("Pin apparaat", 23.51);
		System.out.println(ehboKist);
		System.out.println(pinApparaat);
		System.out.println();
	}

	private void testStap2() {
	//	System.out.println("OM STAP 2 TE TESTEN: ON-COMMENTARIEER testStap2() IN Meubelmakerij.java");
		System.out.println("Stap 2:");
		System.out.println("--------------------------------------");
		Gereedschap gereedschap = new Gereedschap();
		Gereedschap hamer = new Gereedschap("Hamer", "Sla de spijker op z'n kop!", 15.00);
		System.out.println(gereedschap);
		System.out.println(hamer);
		System.out.println();
	}

	private void testStap3() {
//		System.out.println("OM STAP 3 TE TESTEN: ON-COMMENTARIEER testStap3() IN Meubelmakerij.java");
		System.out.println("Stap 3:");
		System.out.println("--------------------------------------");
		Hout partij1 = new Hout("eiken", 1.20, 0.28, 0.05, 40, "Mooie partij eiken", 3950.00);
		Hout partij2 = new Hout("europees noten", 0.80, 0.15, 0.05, 15, "Klein partijtje noten", 5680.00);
		System.out.println(partij1);
		System.out.println();
		System.out.println(partij2);
		System.out.println();
	}

	private void testStap4() {
//		System.out.println("OM STAP 4 TE TESTEN: ON-COMMENTARIEER testStap4() IN Meubelmakerij.java");
		System.out.println("Stap 4:");
		System.out.println("--------------------------------------");
		
		// Initialiseer een aantal partijen hout.
		Hout partij1 = new Hout("eiken", 1.10, 0.28, 0.05, 40, "Mooie partij eiken", 3950.00);
		Hout partij2 = new Hout("scandinavisch dennen", 2.10, 0.15, 0.05, 15, "Koopje", 750.00);
		Hout partij3 = new Hout("beuken", 1.50, 0.30, 0.05, 10, "Beukenhout", 1725.00);

		// Initialiseer een array met 6 houtrekken met varierende dieptes.
		double[] diepten = new double[] {0.75, 2.00, 1.15, 1.60, 2.10, 1.60};

		// Roep de methode zoekPassendeOpslag aan om het vak te vinden met de minste verspilling voor een partij hout
		int ix1 = partij1.zoekPassendeOpslag(diepten);
		int ix2 = partij2.zoekPassendeOpslag(diepten);
		int ix3 = partij3.zoekPassendeOpslag(diepten);
		
		// Print het resultaat.
		System.out.println("Lengte partij 1: 1.10m, index best passende vak: " + ix1);
		System.out.println("Lengte partij 2: 2.10m, index best passende vak: " + ix2);
		System.out.println("Lengte partij 3: 1.50m, index best passende vak: " + ix3);
		System.out.println();
	}
}
