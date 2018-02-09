import java.util.Scanner;

public class Main {
	final static double PI = Math.PI;
	public static Scanner input;

	public static void main(String[] args) {
        Rectangle rect = new Rectangle(2,2);
        System.out.println(rect);
        /*
		input = new Scanner(System.in);
		
		while (true) {
			System.out.println("Would you like to calculate the area and circumference of a :");
			System.out.println("1. circle");
			System.out.println("2. rectangle");
			
			int userInput = input.nextInt();
			switch (userInput) {
				case 1: Main.handleCircle();
				break;
				case 2: Main.handleRectangle();
				break;
			}
		}
        */
		
	}
	
    /*
	public static void handleCircle() {
		System.out.println("---------------------------------------");
		System.out.println("    Wat is de radius van de cirkel?");
		System.out.println("---------------------------------------");
		double radius = input.nextDouble();
		
		Circle circle = new Circle(radius);
		
		System.out.println("");
		System.out.println("Radius: " + circle.radius);
		System.out.println("De oppervlakte is " + circle.area());
		System.out.println("De omtrek is " + circle.circum());
		System.out.println("");		
	}
	
	public static void handleRectangle() {
		System.out.println("---------------------------------------");
		System.out.println("Wat is de lengte van de rechthoek?");
		double height = input.nextDouble();
		System.out.println("Wat is de breedte van de rechthoek?");
		double width = input.nextDouble();
		System.out.println("---------------------------------------");
		
		Rectangle rectangle = new Rectangle(width, height);
		
		System.out.println("");
		System.out.println("Lengte: " + height + ", breedte: " + width);
		System.out.println("De oppervlakte is: " + rectangle.area());
		System.out.println("De omtrek is: " + rectangle.circum());
		System.out.println("");
	}
    */
	
}
