package nl.hva.dmci.ict.miw.c9.progr.proeftoets;

import java.util.Scanner;

public class Kassabon {

	public static void main(String[] args) {
		// stap 1
		System.out.println("Huub van Thienen - 007");
		
		// stap 2
		String[] productNamen = new String[] {"Papier", "Pennen", "Paperclips", "Potloden"};
		
		// stap 3
		double[] productPrijzen = new double[] {2.50, 1.12, 3.60, 4.00};
		
		// stap 4
		System.out.println("Product catalogus:");
		for (int i=0; i<productNamen.length; i++) {
			System.out.println((i+1) + ": " + productNamen[i] + " " + productPrijzen[i]);
		}
		
		// stap 5
		Scanner input = new Scanner(System.in);
		System.out.print("Hoeveel producten wil je kopen? ");
		int aantalProducten = input.nextInt();
		System.out.println("Je hebt aangegeven dat je " + aantalProducten + " producten wil kopen");
		
		// stap 6
		if (aantalProducten > 0 && aantalProducten < 5) {
			//stap 7
			int productNummer[] = new int[aantalProducten];
			int productAantal[] = new int[aantalProducten];
			for (int i=0; i<aantalProducten; i++) {
				// stap 8
				int nr;
				do {
					System.out.print("Welk product wilt u kopen? (" + i + ")");
					// stap 9
					nr = input.nextInt();
					if ((nr < 1) || (nr > 4)) {
						System.out.println("Dit product bestaat niet!");
					}
				} while (!(1 <= nr && nr <= 4));
				
				// stap 10
				int index = nr-1;
				String naam = productNamen[index];
				double prijs = productPrijzen[index];
				
				// stap 11
				System.out.print("Hoeveel " + naam + " a " + prijs + " wilt u hebben? ");
				int aantal = input.nextInt();
				productNummer[i] = nr;
				productAantal[i] = aantal;
			}
			// stap 13
			double totaalPrijs = 0.00;
			for (int i=0; i<productNummer.length; i++) {
				int ix = productNummer[i]-1;
				double pr = bestellingsPrijs(productPrijzen[ix], productAantal[i]);
				totaalPrijs += pr;
				System.out.println(
						productAantal[i] + 
						" ex. " + 
						productNamen[ix] + 
						" a " + 
						productPrijzen[ix] +
						" = " +
						pr);
			}
			System.out.println("Totaal: " + totaalPrijs);
		} else {
			System.out.println("Het aantal producten valt buiten de range 0..5");
			System.out.println("Oen!");
		}
	}
	
	// stap 12
	private static double bestellingsPrijs(double prijs, int aantal) {
		double bp = aantal*prijs;
		return bp;
	}
	
}
