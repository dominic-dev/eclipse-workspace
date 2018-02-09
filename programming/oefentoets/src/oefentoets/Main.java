package oefentoets;

import java.util.Scanner;

public class Main {
    // Store
    public static String[] itemNames = {
    };

    public static double[] itemPrices = {
        2.5,
        1.12,
        3.6,
        4.0
    };

    // Cart
    private int[] cartTet;
    private int[] cartAmounts;
    private int aantalProducten;
    private double totalPrice;

    public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
        System.out.println("Dit programma is gemaakt door Dominic Dingena\n");
        printCatalog();

        System.out.println("\nHoeveel producten wilt u kopen?");
        aantalProducten = input.nextInt();
        if (aantalProducten < 0 || aantalProducten > 4){
            System.out.println("Deze invoer is niet geldig");
            System.exit(0);
        }

        cartProductNrs = new int[aantalProducten];
        cartAmounts = new int[aantalProducten];

        for (int i=0; i < aantalProducten; i++) {
           buyItem(i); 
        }

        printReceipt();
	}

    public static void printCatalog(){
        System.out.println("Product catalogus");
        for (int i=0; i < itemNames.length; i++) {
            System.out.printf("%2d: %-15s %5.2f\n", i+1, itemNames[i], itemPrices[i]);
        }
    }

    public static void printReceipt(){
        System.out.println("\nBestellingsoverzicht:\n");
        for (int i=0; i < aantalProducten; i++) {
            int prodNr = cartProductNrs[i];
            int amount = cartAmounts[i];
            double price = itemPrices[prodNr];
            System.out.printf("%2d ex.  %-15s a %5.2f\n", amount, itemNames[prodNr], orderPrice(price, amount));
        }
        System.out.printf("\n\nTotaal: %5.2f", totalPrice);
    }

    public static void buyItem(int index){
        int prodNr = 0;
        // Wat?
        System.out.print("\nVoer het productnummer in van het product dat u wil kopen: ");

        prodNr = input.nextInt() - 1;
        while (prodNr < 0 || prodNr > 3){
            System.out.print("\nDit is geen geldige invoer. Probeer opnieuw: ");
            prodNr = input.nextInt() - 1;
        }
        cartProductNrs[index] = prodNr;

        // Hoeveel?
        System.out.printf("Hoeveel %s a %.2f wilt u kopen? ", itemNames[prodNr], itemPrices[prodNr]);
        int amount = input.nextInt();
        cartAmounts[index] = amount;
        totalPrice += amount * itemPrices[prodNr];
    }

    public static double orderPrice(double price, int amount){
        return price * amount;
    }

}
