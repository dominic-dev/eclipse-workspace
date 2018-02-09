/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.toets;

import dit.niet.veranderen.Breuk;
import dit.niet.veranderen.Geheel;
import dit.niet.veranderen.Getal;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huub
 */
public class Stap3 {
  
  public Stap3() {
    super();
  }
  
  public static void main(String[] args) {
    Stap3 opg = new Stap3();
    opg.writeOutput(opg.leesBinaireData("getallen.dat"));
  }
  
  private List<Getal> leesBinaireData(String filenaam) {
    // Deze methode moet je afmaken voor Stap 3
	  List<Getal> getallen = new ArrayList();
	  
	  try {
		FileInputStream fis = new FileInputStream(filenaam);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		boolean eof = false;
		try {
			do { 
				Getal getal = null;
				try {
					getal = (Getal) ois.readObject();
					if ( getal instanceof Geheel ) {
						getallen.add(getal);
					}
				} catch (EOFException e) {
					eof = true;
				}
			} while  ( !eof );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		fis.close();
		ois.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
    return getallen;
  }
  
  private void writeOutput(List<Getal> getallen) {
    // Deze methode moet je afmaken voor Stap 3
	  int i = 0;
	  for ( Getal getal: getallen ) {
		  System.out.print(getal + (i++ == getallen.size()-1 ? "!" : ", "));
	  }
  }
  
}
