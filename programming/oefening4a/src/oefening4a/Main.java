package oefening4a;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
        while (true){

            System.out.print("Welke tafel wilt u printen? ");
            int number = input.nextInt();
            if (number == 0) break;


            System.out.printf("\nDe tafel van %d:\n", number);
            for (int i=1; i<11; i++){
                System.out.print(i * number);

                if (i % 5 == 0){
                    System.out.print("\n");
                } else{
                    System.out.print("\t");
                }
            }

        }

	}




}
