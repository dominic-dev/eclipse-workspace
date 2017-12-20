package galgje;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUIController {
    @FXML private TextField userInput;
    @FXML private Label guessedLetters;
    @FXML private Label wordLabel;
    @FXML private ImageView gallows;
    @FXML private Button button;
    @FXML private GridPane layout;
    private Image image;
    private int wrongGuesses = 0;
    private int correctGuesses = 0;
    private Word word;

    @FXML protected void initialize(){
        //word = new Word(WordChoice.COMPUTER);
        //System.out.println(word.word);
        //System.out.println(word.placeholders());
        //updatePlaceholders();
        newRandomWord();
    }

    @FXML public void newRandomWord(){
        word = new Word();
        reset();
    }


    private void reset(){
        correctGuesses = 0;
        wrongGuesses = 0;
        updatePlaceholders();
        updateGallows();
        userInput.setText("Voer een letter in");
    }

    @FXML public void newUserChosenWord(){
        Stage stage = (Stage) layout.getScene().getWindow();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Kies een woord");
        dialog.setHeaderText("Type hier je woord:");
        Optional<String> result = dialog.showAndWait();
        word = new Word(result.get());
        reset();
    }

    @FXML public void guessLetter(){
        if (!word.hasBeenGuessed(correctGuesses) && wrongGuesses > Game.MAX_TRIES){ 
            return;
        }

        char query = userInput.getText().charAt(0);

        if(word.letterHasBeenGuessed(query)){
            userInput.setText("Deze letter is al geraden");
            return;
        }
        boolean success = word.guessLetter(query);

        if (success){
            correctGuesses++;
        }
        else{
            wrongGuesses++;
        }

        if (word.hasBeenGuessed(correctGuesses)){
            gameWin();
        }

        if (wrongGuesses == Game.MAX_TRIES){
            gameOver();
        }

        updateGuessedLetters();
        updatePlaceholders();
        updateGallows();
        resetInputField();
    }

    @FXML public void onEnter(ActionEvent ae){
        guessLetter();
    }

    private void resetInputField(){
        userInput.setText("");
    }


    private void updateGuessedLetters(){
        guessedLetters.setText(word.guessedLetters);

    }

    private void updatePlaceholders(){
        wordLabel.setText(word.placeholders());
    }

    private void updateGallows(){
        String path = String.format("%d.png", wrongGuesses + 1);
        image = new Image(path);
        gallows.setImage(image);
    }

    private void gameWin(){
        System.out.println(userInput.getParent());
        button.setText("Gewonnen!");
        button.setOnAction(null);
    }

    private void gameOver(){
        button.setText("Game over");
        button.setOnAction(null);
    }

}
