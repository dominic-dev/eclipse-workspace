package practicum6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public final static int START = 0;
    public final static int END = 10;
    public final static int SIZE = 3;
    public static RandomSet randomSet = new RandomSet(START, END, SIZE);
    public static ArrayList<Integer> correctGuesses = new ArrayList<>();


	public static void main(String[] args) {
        int attempts = 0;
        while (correctGuesses.size() != SIZE){
            attempts++;
            guess();
            System.out.printf("Nog %d getallen te gaan!\n", SIZE-correctGuesses.size());
        }
        System.out.printf("U heeft %d pogingen nodig gehad.\n", attempts);

	}

    public static void guess(){
        int[] tries = new int[SIZE];
        System.out.println("Geef drie getallen gescheiden door een spatie");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        System.out.println(userInput);
        tries = Arrays.stream(userInput.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("U heeft de volgende getallen goed geraden: ");
        for (int t : tries){
            if (randomSet.contains(t)){
                if (!correctGuesses.contains(t)){
                    correctGuesses.add(t);
                }
                System.out.print(t + " ");
            }
        }
        System.out.print("\n");

    }

}
