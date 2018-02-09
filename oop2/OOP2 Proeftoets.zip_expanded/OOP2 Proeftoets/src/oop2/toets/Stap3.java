/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.toets;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import dit.niet.veranderen.Geheel;
import dit.niet.veranderen.Getal;

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
      List<Getal> result = new ArrayList<>();
    try {
        FileInputStream fis = new FileInputStream(filenaam);
        ObjectInputStream dis = new ObjectInputStream(fis);
        boolean eof = false;

        while(!eof){
            try {
                Getal g = (Getal) dis.readObject();
                if(g instanceof Geheel){
                    result.add(g);
                }
            } catch(EOFException e){
                eof = true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
         }
        dis.close();
        fis.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return result;
  }
  
  private void writeOutput(List<Getal> getallen) {
      int i = 0;
      System.out.print(getallen.get(i));
      for (i=1; i < getallen.size(); i++) {
        System.out.print(", " + getallen.get(i));
      }
  }
  
}
