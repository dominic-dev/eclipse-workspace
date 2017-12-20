/**
 * Galgje - OOP
 * @author Dominic Dingena
 **/

package galgje;
import java.util.Scanner;

public class Game {
    public static final int MAX_TRIES = 10;
    private Word word;
    public int correctGuesses = 0;
    public int wrongGuesses = 0;

    public Game(){
        word = new Word(Word.askWordChoice());
    }


    /**
     * The game loop.
     **/
    public void loop(){
        while(!word.hasBeenGuessed(correctGuesses)){
            Console.clear();

            // No attempts remaining
            if (!hasAttemptsLeft()) {
                Console.clear();
                System.out.println("Game over");
                return;
            }

            System.out.print("\n");
            word.print();
            System.out.print("\n");

            // Print guessed letters
            System.out.println("Guessed letters: " + word.guessedLetters);

            // Print strikes
            System.out.print("Strikes: ");
            for (int i=0; i<wrongGuesses; i++) {
                System.out.print("|");
            }
            System.out.print("\n\n");

            // Ask input
            System.out.print("Which letter would you like to guess?: ");
            Scanner input = new Scanner(System.in);
            char userInputChar = input.next().charAt(0);

            // Letter has been guessed before
            if (word.letterHasBeenGuessed(userInputChar)) {
                System.out.println("You already guessed this letter");
            }
            // Letter has not been guessed before
            else {
                // Check answer
                boolean success = word.guessLetter(userInputChar);
                if (success) {
                    System.out.println("Nice!");
                    correctGuesses++;
                } else{
                    System.out.println("Too bad!");
                    wrongGuesses++;
                }
            }

            // Enter to continue
            Console.promptEnterKey();
        }
            // Complete
            Console.clear();
            System.out.println("Nice! You guessed it. The word was " + word.word);
    }


    /**
     * Return true if there are attempts remaining
     **/
    private boolean hasAttemptsLeft(){
        if (wrongGuesses >= MAX_TRIES) {
            return false;
        }
        return true;
    }

}
