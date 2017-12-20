/*
 * This file was created to facilitate lessons at HBO-ICT@HvA.
 */
package leseenheidapp.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import leseenheidapp.models.LesEenheid;
import leseenheidapp.models.ProfessionalSkills;
import leseenheidapp.models.Project;
import leseenheidapp.models.Vak;

/**
 *
 * @author Dennis Breuker (d.m.breuker@hva.nl)
 */
public class Main extends Application {
   
    private static final String FOUT_ALLE_VELDEN_MOETEN_WORDEN_ONGEVULD 
            = "Alle velden moeten worden ingevuld";
    private static final int INDEX_VAK = 0;
    private static final int INDEX_PROF_SKILLS = 1;
    private static final int INDEX_PROJECT = 2;
    
    Pane lesEenheidScherm, vakScherm, profSkillsScherm, projectScherm;
    Pane buttonScherm;
    TabPane tabPane;
    TextField tfNaam, tfEcts, tfStudiejaar;
    TextField tfCijfer;
    CheckBox cbGehaald;
    TextField tfProductCijfer, tfProcesCijfer, tfMethodenEnTechniekenCijfer;
    Label lblLesEenheidOutput;
    Label lblOutput;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        lesEenheidScherm = maakLesEenheidScherm();
        vakScherm = maakVakScherm();
        profSkillsScherm = maakProfSkillsScherm();
        projectScherm = maakProjectScherm();
        buttonScherm = maakButtonScherm();

        tabPane = new TabPane();

        Tab tabVak = maakTab("Vak", vakScherm);
        Tab tabProfSkills = maakTab("ProfSkills", profSkillsScherm);
        Tab tabProject = maakTab("Project", projectScherm);

        tabPane.getTabs().addAll(tabVak, tabProfSkills, tabProject);

        VBox root = new VBox();
        root.getChildren().addAll(lesEenheidScherm, tabPane, buttonScherm);

        Scene scene = new Scene(root, 402, 410);
        
        primaryStage.setTitle("OOP1 practicumopdracht 4 - LesEenheid");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Maakt een deelscherm om de class LesEenheid te kunnen testen.
     * 
     * @return Het adres-scherm.
     */
    private Pane maakLesEenheidScherm() {
        GridPane scherm;
        
        Label lblNaam = new Label("Naam");
        tfNaam = new TextField();
        tfNaam.setMinWidth(325);

        Label lblEcts = new Label("Ects");
        lblEcts.setMinWidth(Control.USE_PREF_SIZE);
        tfEcts = new TextField();
        
        Label lblStudiejaar = new Label("Studiejaar");
        tfStudiejaar = new TextField();
        
        lblLesEenheidOutput = new Label();
        lblLesEenheidOutput.setStyle("-fx-background-color: lightblue");
        lblLesEenheidOutput.setMaxWidth(Double.MAX_VALUE);
        
        Button btnMaak = new Button("Maak LesEenheid");
        btnMaak.setMinWidth(Control.USE_PREF_SIZE);
        btnMaak.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                maakLesEenheid();
            }
        });


        scherm = new GridPane();
        scherm.setPadding(new Insets(5,5,5,5));
        scherm.setHgap(5);
        scherm.setVgap(5);
        
        int rij = 0;
        scherm.add(new Text(""), 0, rij++);
        scherm.addRow(rij++, lblNaam, tfNaam);
        scherm.addRow(rij++, lblEcts, tfEcts);
        scherm.addRow(rij++, lblStudiejaar, tfStudiejaar);
        scherm.add(new Text(""), 0, rij++);
        scherm.add(btnMaak, 0, rij++, 2, 1);
        scherm.add(lblLesEenheidOutput, 0, rij++, 2, 1);
        
        return scherm;
    }
    
    /**
     * Maakt een deelscherm om eigenschappen van de class Vak te kunnen invoeren.
     * 
     * @return Het vak-scherm.
     */
    private Pane maakVakScherm() {
        GridPane scherm;
        
        Label lblCijfer = new Label("Cijfer");
        tfCijfer = new TextField();
        tfCijfer.setMinWidth(355);

        scherm = new GridPane();
        scherm.setPadding(new Insets(5,5,5,5));
        scherm.setHgap(5);
        scherm.setVgap(5);
        
        int rij = 0;
        scherm.add(new Text(""), 0, rij++);
        scherm.add(lblCijfer, 0, rij);
        scherm.add(tfCijfer, 1, rij++, 2, 1);

        return scherm;
    }
    
    /**
     * Maakt een deelscherm om eigenschappen van de class ProfessionalSkills 
     * te kunnen invoeren.
     * 
     * @return Het ProfSkills-scherm.
     */
    private Pane maakProfSkillsScherm() {
        cbGehaald = new CheckBox("Gehaald");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5,5,5,5));
        vBox.getChildren().addAll(new Text(""), cbGehaald);
        return vBox;
    }
    
    /**
     * Maakt een deelscherm om eigenschappen van de class Project te kunnen 
     * invoeren.
     * 
     * @return Het Project-scherm.
     */
    private Pane maakProjectScherm() {
        GridPane scherm;
        
        Label lblProductCijfer = new Label("Cijfer voor product");
        tfProductCijfer = new TextField();

        Label lblProcesCijfer = new Label("Cijfer voor proces");
        tfProcesCijfer = new TextField();
        
        Label lblMethodenEnTechniekenCijfer 
                = new Label("Cijfer voor methoden en technieken");
        tfMethodenEnTechniekenCijfer = new TextField();

        scherm = new GridPane();
        scherm.setPadding(new Insets(5,5,5,5));
        scherm.setHgap(5);
        scherm.setVgap(5);
        
        int rij = 0;
        scherm.add(new Text(""), 0, rij++);
        scherm.addRow(rij++, lblProductCijfer, tfProductCijfer);
        scherm.addRow(rij++, lblProcesCijfer, tfProcesCijfer);
        scherm.addRow(rij++, lblMethodenEnTechniekenCijfer
                , tfMethodenEnTechniekenCijfer);

        return scherm;
    }
    
    /**
     * Maakt een deelscherm om de classes Vak, ProfessionalSkill en Project
     * te kunnen testen.
     * 
     * @return Het button-scherm.
     */
    private Pane maakButtonScherm() {
        GridPane scherm;
        
        Button btnMaak = new Button("Maak");
        btnMaak.setMinWidth(Control.USE_PREF_SIZE);
        btnMaak.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (tabPane.getSelectionModel().getSelectedIndex()) {
                    case 0:
                        maakVak();
                        break;
                    case 1:
                        maakProfSkills();
                        break;
                    case 2:
                        maakProject();
                        break;
                }
            }
        });

        Button btnCheck = new Button("Check");
        btnCheck.setMinWidth(Control.USE_PREF_SIZE);
        btnCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (tabPane.getSelectionModel().getSelectedIndex()) {
                    case INDEX_VAK:
                        Vak vak = maakVak();
                        if (vak != null) {
                            // TODO B: uncomment de volgende regel
                            voegCheckToe(vak.isAfgerond());
                        }
                        break;
                    case INDEX_PROF_SKILLS:
                        ProfessionalSkills profSkills = maakProfSkills();
                        if (profSkills != null) {
                            // TODO B: uncomment de volgende regel
                            voegCheckToe(profSkills.isAfgerond());
                        }
                        break;
                    case INDEX_PROJECT:
                        Project project = maakProject();
                        if (project != null) {
                            // TODO B: uncomment de volgende regel
                            voegCheckToe(project.isAfgerond());
                        }
                        break;
                }
            }
        });

        lblOutput = new Label();
        lblOutput.setStyle("-fx-background-color: lightblue");
        lblOutput.setMaxWidth(Double.MAX_VALUE);
        lblOutput.setMinWidth(392);

        scherm = new GridPane();
        scherm.setPadding(new Insets(5,5,5,5));
        scherm.setHgap(5);
        scherm.setVgap(5);
        
        int rij = 0;
        scherm.add(btnMaak, 0, rij);
        scherm.add(btnCheck, 1, rij++);
        scherm.add(lblOutput, 0, rij++, 2, 1);

        return scherm;
    }
    
    /**
     * Maakt een tab object. Als deze tab wordt geselecteerd dan wordt
     * het veld lblOutput leeg gemaakt.
     * 
     * @param titel Titel van de tab.
     * @param scherm Content van de tab.
     * @return 
     */
    private Tab maakTab(String titel, Pane scherm) {
        Tab tab = new Tab();
        tab.setClosable(false);
        tab.setText(titel);
        tab.setContent(scherm);
        tab.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (tab.isSelected()) {
                    lblOutput.setText("");
                }
            }
        });
        return tab;
    }
    
    /**
     * Voegt tekst toe een lblOutput om aan te geven of het afgerond is of niet.
     * 
     * @param afgerond True als het afgerond is, anders false.
     */
    private void voegCheckToe(boolean afgerond) {
        lblOutput.setText(lblOutput.getText()
                .concat(" is " + (afgerond ? "" : "NIET ") + "AFGEROND."));
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
     * Maakt een LesEenheid-object, aan de hand van de ingevulde velden
     * op het LesEenheid-scherm.
     * 
     * @return Het LesEenheid-object.
     * Null als de velden niet allemaal zijn ingevuld.
     */
    private LesEenheid maakLesEenheid() {
        String naam = tfNaam.getText();
        String ectsStr = tfEcts.getText();
        String studiejaarStr = tfStudiejaar.getText();
        if (nullOrEmpty(naam) || nullOrEmpty(ectsStr) 
                || nullOrEmpty(studiejaarStr)) {
            lblLesEenheidOutput.setTextFill(Color.RED);
            lblLesEenheidOutput.setText(FOUT_ALLE_VELDEN_MOETEN_WORDEN_ONGEVULD);
            return null;
        } else {
            int ects = Integer.valueOf(ectsStr);
            int studiejaar = Integer.valueOf(studiejaarStr);
            // TODO A-LesEenheid: verander de regel hieronder zodat een 
            // LesEenheid object wordt gemaakt met de juiste attributen.
            LesEenheid lesEenheid = new LesEenheid(naam, ects, studiejaar);
            lblLesEenheidOutput.setTextFill(Color.BLACK);
            lblLesEenheidOutput.setText(lesEenheid.toString());
            return lesEenheid;
        }
    }

    /**
     * Maakt een vak-object, aan de hand van de ingevulde velden
     * op het LesEenheid-scherm en vak-scherm.
     * 
     * @return Het vak-object. Null als de velden niet allemaal zijn ingevuld.
     */
    public Vak maakVak() {
        // als er te weinig info in LesEenheid staat dan houdt het op
        if (maakLesEenheid() == null) {
            return null;
        }
        String cijferStr = tfCijfer.getText();
        // TODO B: zet het hele if-statement tussen commentaar
        if (nullOrEmpty(cijferStr)) {
            lblOutput.setTextFill(Color.RED);
            lblOutput.setText(FOUT_ALLE_VELDEN_MOETEN_WORDEN_ONGEVULD);
            return null;
        }
        String naam = tfNaam.getText();
        String ectsStr = tfEcts.getText();
        String studiejaarStr = tfStudiejaar.getText();
        int ects = Integer.valueOf(ectsStr);
        int studiejaar = Integer.valueOf(studiejaarStr);
        Vak vak;
        // TODO B: uncomment de code van de if en de else, en zorg dat de 
        // juiste constructor wordt aangeroepen
        if (nullOrEmpty(cijferStr)) {
            vak = new Vak(naam, ects, studiejaar);
        } else {
            double cijfer = Double.valueOf(cijferStr);
            // TODO A-Vak: verander de volgende regel zodat de juiste constructor 
            // wordt aangeroepen
            vak = new Vak(cijfer, naam, ects, studiejaar);
        }
        lblOutput.setTextFill(Color.BLACK);
        lblOutput.setText(vak.toString());
        return vak;
    }

    /**
     * Maakt een ProfSkills-object, aan de hand van de ingevulde velden
     * op het LesEenheid-scherm en ProfSkills-scherm.
     * 
     * @return Het ProfSkills-object.
     * Null als de velden niet allemaal zijn ingevuld.
     */
    public ProfessionalSkills maakProfSkills() {
        // als er te weinig info in LesEenheid staat dan houdt het op
        if (maakLesEenheid() == null) {
            return null;
        }
        String naam = tfNaam.getText();
        String ectsStr = tfEcts.getText();
        String studiejaarStr = tfStudiejaar.getText();
        int ects = Integer.valueOf(ectsStr);
        int studiejaar = Integer.valueOf(studiejaarStr);
        boolean gehaald = cbGehaald.isSelected();
        // TODO A-ProfSkills: verander de volgende regel zodat de juiste constructor 
        // wordt aangeroepen
        ProfessionalSkills profSkills = new ProfessionalSkills(gehaald, naam, ects, studiejaar);
        lblOutput.setTextFill(Color.BLACK);
        lblOutput.setText(profSkills.toString());
        return profSkills;
    }

    /**
     * Maakt een Project-object, aan de hand van de ingevulde velden
     * op het LesEenheid-scherm en Project-scherm.
     * 
     * @return Het Project-object.
     * Null als de velden niet allemaal zijn ingevuld.
     */
    public Project maakProject() {
        // als er te weinig info in LesEenheid staat dan houdt het op
        if (maakLesEenheid() == null) {
            return null;
        }
        String productCijferStr = tfProductCijfer.getText();
        String procesCijferStr = tfProcesCijfer.getText();
        String methodenEnTechniekenCijferStr 
                = tfMethodenEnTechniekenCijfer.getText();
        // TODO B: zet het hele if-statement tussen commentaar
        if (nullOrEmpty(productCijferStr) 
                || nullOrEmpty(procesCijferStr)
                || nullOrEmpty(methodenEnTechniekenCijferStr)) {
            lblOutput.setTextFill(Color.RED);
            lblOutput.setText(FOUT_ALLE_VELDEN_MOETEN_WORDEN_ONGEVULD);
            return null;
        }
        String naam = tfNaam.getText();
        String ectsStr = tfEcts.getText();
        String studiejaarStr = tfStudiejaar.getText();
        int ects = Integer.valueOf(ectsStr);
        int studiejaar = Integer.valueOf(studiejaarStr);
        Project project;
        // TODO B: uncomment de code van de if en de else, en zorg dat de 
        // juiste constructor wordt aangeroepen
        if (nullOrEmpty(productCijferStr) 
                || nullOrEmpty(procesCijferStr)
                || nullOrEmpty(methodenEnTechniekenCijferStr)) {
            project = new Project(naam, ects, studiejaar);
        } else {
            double productCijfer = Double.valueOf(productCijferStr);
            double procesCijfer = Double.valueOf(procesCijferStr);
            double methodenEnTechniekenCijfer 
                    = Double.valueOf(methodenEnTechniekenCijferStr);
            // TODO A-Project: verander de volgende regel zodat de juiste constructor 
            // wordt aangeroepen
            project = new Project(productCijfer, procesCijfer, methodenEnTechniekenCijfer, naam, ects, studiejaar);
        }
        lblOutput.setTextFill(Color.BLACK);
        lblOutput.setText(project.toString());
        return project;
    }
}
