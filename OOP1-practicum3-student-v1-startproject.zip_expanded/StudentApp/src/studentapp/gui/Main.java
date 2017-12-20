/*
 * This file was created to facilitate lessons at HBO-ICT@HvA.
 */
package studentapp.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import studentapp.models.Adres;
import studentapp.models.Groep;
import studentapp.models.Student;

/**
 *
 * @author Dennis Breuker <d.m.breuker@hva.nl>
 */
public class Main extends Application {
    
    GridPane root;
    Pane adresScherm, studentScherm, groepScherm;
    TextField tfStraat, tfHuisNr, tfPlaats;
    TextField tfVoornaam, tfAchternaam;
    TextField tfNaam;
    Label lblAdresOutput, lblStudentOutput, lblGroepOutput;
    Groep groep = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        adresScherm = maakAdresScherm();
        studentScherm = maakStudentScherm();
        groepScherm = maakGroepScherm();

        root = new GridPane();
        root.setHgap(15);
        root.setVgap(15);
        
        int rij = 0; 
        root.add(new Text("  "), 0, rij);
        root.add(new Text("  "), 3, rij++);
        root.add(adresScherm, 1, rij);
        root.add(groepScherm, 2, rij++, 1, 2);
        root.add(studentScherm, 1, rij);

        Scene scene = new Scene(root, 900, 800);
        
        primaryStage.setTitle("OOP1 practicumopdracht 3 - Student");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Maakt een deelscherm om de class Adres te kunnen testen.
     * 
     * @return Het adres-scherm.
     */
    private Pane maakAdresScherm() {
        GridPane scherm;
        
        Label lblStraat = new Label("Straat");
        tfStraat = new TextField();
        tfStraat.setMinWidth(230);

        Label lblHuisNr = new Label("Huisnummer");
        lblHuisNr.setMinWidth(Control.USE_PREF_SIZE);
        tfHuisNr = new TextField();
        
        Label lblPlaats = new Label("Plaats");
        tfPlaats = new TextField();
        
        lblAdresOutput = new Label();
        lblAdresOutput.setStyle("-fx-background-color: lightblue");
        lblAdresOutput.setMaxWidth(Double.MAX_VALUE);
        
        Button btnMaak = new Button("Maak Adres");
        btnMaak.setMinWidth(Control.USE_PREF_SIZE);
        btnMaak.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                maakAdres();
            }
        });

        scherm = new GridPane();
        scherm.setPadding(new Insets(5,5,5,5));
        scherm.setHgap(5);
        scherm.setVgap(5);
        
        int rij = 0;
        scherm.add(new Text(""), 0, rij++);
        scherm.addRow(rij++, lblStraat, tfStraat);
        scherm.addRow(rij++, lblHuisNr, tfHuisNr);
        scherm.addRow(rij++, lblPlaats, tfPlaats);
        scherm.add(new Text(""), 0, rij++);
        scherm.add(btnMaak, 1, rij++);
        scherm.add(new Text(""), 0, rij++);
        scherm.add(lblAdresOutput, 0, rij++, 2, 1);
        
        scherm.setStyle("-fx-border-color: darkblue");

        return scherm;
    }
    
    /**
     * Maakt een deelscherm om de class Student te kunnen testen.
     * 
     * @return Het student-scherm.
     */
    private Pane maakStudentScherm() {
        GridPane scherm;
        
        Label lblVoornaam = new Label("Voornaam");
        tfVoornaam = new TextField();
        tfVoornaam.setMinWidth(230);

        Label lblAchternaam = new Label("Achternaam");
        lblAchternaam.setMinWidth(Control.USE_PREF_SIZE);
        tfAchternaam = new TextField();
        
        lblStudentOutput = new Label();
        lblStudentOutput.setStyle("-fx-background-color: lightblue");
        lblStudentOutput.setMaxWidth(Double.MAX_VALUE);
        lblStudentOutput.setMinWidth(Control.USE_COMPUTED_SIZE);
        
        Button btnMaak = new Button("Maak Student");
        btnMaak.setMinWidth(Control.USE_PREF_SIZE);
        btnMaak.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                maakStudent();
            }
        });

        scherm = new GridPane();
        scherm.setPadding(new Insets(5,5,5,5));
        scherm.setHgap(5);
        scherm.setVgap(5);
        
        int rij = 0;
        scherm.add(new Text(""), 0, rij++);
        scherm.addRow(rij++, lblVoornaam, tfVoornaam);
        scherm.addRow(rij++, lblAchternaam, tfAchternaam);
        scherm.add(new Text(""), 0, rij++);
        scherm.add(btnMaak, 1, rij++);
        scherm.add(new Text(""), 0, rij++);
        scherm.add(lblStudentOutput, 0, rij++, 2, 1);

        scherm.setStyle("-fx-border-color: darkblue");

        return scherm;
    }
    
    /**
     * Maakt een deelscherm om de class Groep te kunnen testen.
     * 
     * @return Het groep-scherm.
     */
    private Pane maakGroepScherm() {
        GridPane scherm;
        
        Label lblNaam = new Label("Naam");
        tfNaam = new TextField();

        lblGroepOutput = new Label();
        lblGroepOutput.setMaxWidth(Double.MAX_VALUE);
        ScrollPane output = new ScrollPane();
        output.setPrefWidth(lblGroepOutput.getMaxWidth());
        output.setFitToWidth(true);
        output.setStyle("-fx-base: lightblue");
        output.setContent(lblGroepOutput);
        
        Button btnMaak = new Button("Maak Groep");
        btnMaak.setMinWidth(Control.USE_PREF_SIZE);
        btnMaak.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                groep = maakGroep();
            }
        });

        Button btnVoegToe = new Button("Voeg student toe");
        btnVoegToe.setMinWidth(Control.USE_PREF_SIZE);
        btnVoegToe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                voegStudentToe();
            }
        });

        scherm = new GridPane();
        scherm.setPadding(new Insets(5,5,5,5));
        scherm.setHgap(5);
        scherm.setVgap(5);
    
        int rij = 0;
        scherm.add(new Text(""), 0, rij++);
        scherm.addRow(rij++, lblNaam, tfNaam);
        scherm.add(new Text(""), 0, rij++);
        scherm.add(btnMaak, 1, rij++);
        scherm.add(btnVoegToe, 1, rij++);
        scherm.add(new Text(""), 0, rij++);
        scherm.add(output, 0, rij++, 2, 1);
        
        scherm.setMinWidth(520);

        scherm.setStyle("-fx-border-color: darkblue");
        
        return scherm;
    }
    
    /**
     * Test of een string null of leeg is
     * 
     * @param str De te testen string
     * @return true als de string null of leeg is, anders false
     */
    private static boolean nullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    /**
     * Maakt een adres-object, aan de hand van de ingevulde velden
     * op het adres-scherm.
     * 
     * @return Het adres-object. Null als de velden niet allemaal zijn ingevuld.
     */
    private Adres maakAdres() {
        String straat = tfStraat.getText();
        String huisNrStr = tfHuisNr.getText();
        String plaats = tfPlaats.getText();
        if (nullOrEmpty(straat) || nullOrEmpty(huisNrStr) 
                || nullOrEmpty(plaats)) {
            lblAdresOutput.setTextFill(Color.RED);
            lblAdresOutput.setText("Alle velden moeten worden ingevuld");
            return null;
        } else {
            int huisNr = Integer.valueOf(huisNrStr);
            // TODO 1a-Adres: verander de regel hieronder zodat een Adres object
            // met de naam adres wordt gemaakt, waarbij in de constructor
            // gebruik gemaakt wordt van de waarden van straat, huisNr en plaats.
            Adres adres = new Adres(straat, huisNr, plaats);
            lblAdresOutput.setTextFill(Color.BLACK);
            lblAdresOutput.setText(adres.toString());
            return adres;
        }
    }

    /**
     * Maakt een student-object, aan de hand van de ingevulde velden
     * op het student-scherm en adres-scherm.
     * 
     * @return Het student-object. Null als de velden niet allemaal zijn ingevuld.
     */
    public Student maakStudent() {
        Adres adres = maakAdres();
        if (adres == null) {
            return null;
        }
        String voornaam = tfVoornaam.getText();
        String achternaam = tfAchternaam.getText();
        if (nullOrEmpty(voornaam) || nullOrEmpty(achternaam)) {
            lblStudentOutput.setTextFill(Color.RED);
            lblStudentOutput.setText("Alle velden moeten worden ingevuld");
            return null;
        } else {
            // TODO 1b-Student: verander de regel hieronder zodat een Student object
            // met de naam student wordt gemaakt, waarbij in de constructor
            // gebruik gemaakt wordt van de waarden van voornaam, achternaam, en adres.
            Student student = new Student(voornaam, achternaam, adres);
            lblStudentOutput.setTextFill(Color.BLACK);
            lblStudentOutput.setText(student.toString());
            return student;
        }
    }

    /**
     * Maakt een groep-object, aan de hand van de ingevulde velden
     * op het groep-scherm.
     * 
     * @return Het groep-object. Null als de velden niet allemaal zijn ingevuld.
     */
    public Groep maakGroep() {
        String naam = tfNaam.getText();
        if (nullOrEmpty(naam)) {
            lblGroepOutput.setTextFill(Color.RED);
            lblGroepOutput.setText("Alle velden moeten worden ingevuld");
            return null;
        } else {
            // TODO 1c-Groep: verander de regel hieronder zodat een Groep object
            // met de naam groep wordt gemaakt, waarbij in de constructor
            // gebruik gemaakt wordt van de waarde van naam.
            Groep groep = new Groep(naam);
            lblGroepOutput.setTextFill(Color.BLACK);
            lblGroepOutput.setText(groep.toString());
            return groep;
        }
    }

    /**
     * Voegt een student toe aan een groep, als de groep bestaat en als de
     * student gemaakt kan worden. Als de groep niet bestaat wordt
     * een foutmelding adgedrukt.
     */
    public void voegStudentToe() {
        if (groep == null) {
            lblGroepOutput.setTextFill(Color.RED);
            lblGroepOutput.setText("Er moet eerst een groep worden aangemaakt!");
            return;
        }
        Student student = maakStudent();
        if (student == null) {
            return;
        }
        String volMelding = "\nHelaas, deze groep zit vol";
        // TODO 1c-Groep: Vewijder commentaar nadat de methode voegStudentToe() 
        // gemaakt is in de class Groep
        boolean gelukt = groep.voegStudentToe(student);
        lblGroepOutput.setTextFill(Color.BLACK);
        lblGroepOutput.setText(groep.toString() + (gelukt ? "" : volMelding));
    }
}
