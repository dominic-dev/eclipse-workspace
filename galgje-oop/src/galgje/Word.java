/**
 * Galgje - OOP
 * @author Dominic Dingena.
 *
 */

package galgje;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONArray;

public class Word {
    public String word;
    public int length;
    public int nDistinctLetters;
    public String guessedLetters = "";

    public Word(){
        this("");
    }

    public Word(String word){
        this.word = word;
        setupWord();
    }

    private void setupWord(){
        if (word.isEmpty()){
            word = generateRandomWord();
        }
        // cache word length
        length = word.length();
        nDistinctLetters = distinctLetters();
    }


    /**
     * Return the number of distinct letters in the word.
     **/
    private int distinctLetters() {
        String nDistinctLetters = "";
        for(int i=0; i < length; i++){
        	String c = String.valueOf(this.word.charAt(i));
            if (!nDistinctLetters.contains(c)){
                nDistinctLetters += c;
            }
        }
        return nDistinctLetters.length();
	}


    /**
     * Take a char and return if the word contains it.
     **/
    public boolean guessLetter(char c) {
        String queryString = String.valueOf(c);
        if (!letterHasBeenGuessed(c)) {
            guessedLetters += queryString;
        }

        if (this.word.contains(queryString)) {
            return true;
        }
        return false;
    }

    
    /**
     * Return true if all the letters in the word have been guessed.
     **/
	public boolean hasBeenGuessed(int correctGuesses) {
        /*
        for (int i=0; i < word.length(); i++) {
            if (!guessedLetters.contains(String.valueOf(word.charAt(i)))) {
                return false;
            }
        } 
		return true;
        */
        if (nDistinctLetters == correctGuesses) {
            return true;
        }
        return false;
	}


    /**
     * Take a char and return if this letter has been guessed before.
     **/
	public boolean letterHasBeenGuessed(char c) {
        if (guessedLetters.contains(String.valueOf(c))) {
            return true;
        }
        return false;
    }


    /**
     * Ask user how they would like to choose a word.
     * @return WordChoice 
     * 
     **/
	public static WordChoice askWordChoice() {
        System.out.println("Would you like to: ");
        // Print possible choices:
        //      their ordinal +1 to compensate 0-based indexing
        //      and description
        for(WordChoice choice : WordChoice.values()) {
            System.out.printf("\t %d. %s \n", choice.ordinal() + 1, choice.getDescription());
        }

        // User input
        int wordChoiceCode = -1;
        while (wordChoiceCode == -1) {
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter a valid answer :");
            // Input must be int
            if (!input.hasNextInt()) { 
                continue;
            }
            // Input must be a valid WordChoice number
            int userInput = input.nextInt() - 1;
            if (userInput > WordChoice.values().length - 1 ||
                userInput < 0) {
                continue;
            }

            wordChoiceCode = userInput;
        }
        return WordChoice.values()[wordChoiceCode];
	}


    /**
     * Ask user for a word.
     * @return the word
     **/
	private String askUserWord() {
        System.out.println("Which word would you like to use?");
        Scanner input = new Scanner(System.in);
        String userInput = "";
        if (input.hasNext()){
            userInput = input.next();
        }
        return userInput.toLowerCase();
	}


    /**
     * Return a random word.
     * @return the word
     **/
	private String generateRandomWord() {
        // Load JSON
        try{
            String content = new Scanner(new File("src/galgje/wordList.json")).useDelimiter("\\Z").next();
            JSONArray wordList = new JSONArray(content);
            return wordList.get((int) (Math.random() * wordList.length())).toString();
        } catch(IOException e){
            e.printStackTrace();
        }
        return "";
	}


    /**
     * Print the word with placeholders for letters that have not been guessed.
     **/
    public void print() {
        System.out.println(placeholders());
    }
    

    /**
     * Return the word with placeholders for letters that have not been guessed.
     **/
    public String placeholders(){
        String result = "";
        // If there have been no correct guessed
        if (guessedLetters.length() == 0) {
            for (int i=0; i < length; i++) {
                result += "_ ";
            }
        }
        
        // If there have been correct guessed
        else{
            for (int i=0; i < length; i++) {
                String c = String.valueOf(word.charAt(i));
                if (guessedLetters.contains(c)) {
                    result += String.format("%s ", c);
                }
                else {
                    result += "_ ";
                }
            }
        }
        return result; 
    }

}
