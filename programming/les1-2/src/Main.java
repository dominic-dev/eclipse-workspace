import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Geeft twee getallen.");
		System.out.println("Het eerste getal:");
		int first = Main.getNumber();
		System.out.println("Het tweede getal:");
		int second = Main.getNumber();
		
		System.out.println("Het product is " + first * second);
		System.out.println("Het verschil is " + Math.abs(first - second));
		System.out.println("Het grootste getal is " + Math.max(first, second));
	}
	
	public static int getNumber() {
		int userInput = 0;
		while (userInput == 0) {
			try {
				userInput = Main.input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Geef een geldige invoer.");
				Main.input = new Scanner(System.in);
			}
		}
		return userInput;
	}

}
