package nl.hva.ict.oop2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import nl.hva.ict.oop2.deel1.Trappist;
import nl.hva.ict.oop2.deel2.School;
import nl.hva.ict.oop2.deel3.LaadSessieKWH;

/**
 *
 * @author breud
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testDeel1();
        //testDeel2();
        testDeel3();
    }
    
    /**
     * Deze methode test deel 1 (Brouwerij)
     */
    private static void testDeel1() {
        Trappist trappist = new Trappist("Westmalle");
        trappist.gist(5);
    }
    
    /**
     * Deze methode test deel 2 (Voorkennis)
     */
    private static void testDeel2() {
        School hva = new School();
        hva.startSchooljaar();
    }
    
    /**
     * Deze methode test deel 3 ()
     */
    private static void testDeel3() {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Voer een bestandsnaam in of typ quit: ");
            String answer = input.next();
            if(answer.equals("quit")) return;
            readFile(answer);
        }
    }

    public static void printWorkingDir(){
      System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
    }

    public static void readFile(String filename){
        try {
            FileInputStream fis = new FileInputStream("Oefentoets/" + filename);
            ObjectInputStream dis = new ObjectInputStream(fis);
            boolean eof = false;

            while(!eof){
                try {
                    LaadSessieKWH l = (LaadSessieKWH) dis.readObject();
                    System.out.println(l);
                    
                } catch(EOFException e){
                    eof = true;
				} catch (ClassNotFoundException e) {
                    System.out.println("Wrong format!");
                    return;
				}
			 }
            dis.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
