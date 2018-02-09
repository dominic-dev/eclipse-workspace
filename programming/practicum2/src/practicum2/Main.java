package practicum2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Inkoopprijs: ");
		float inkoop = input.nextFloat();
		System.out.print("Winstmarge (in %): ");
		int marge = input.nextInt();
		
		
		float verkoopprijsEx = inkoop * (1 + ((float) marge/100));
		System.out.println();
		System.out.printf("Verkoopprijs excl. BTW: %.2f%n", verkoopprijsEx);
		System.out.printf("Verkoopprijs incl. 6%% BTW: %.2f%n", verkoopprijsEx * 1.06);
		System.out.printf("Verkoopprijs incl. 21%% BTW: %.2f%n", verkoopprijsEx * 1.21);
		input.close();
		
	}

}
