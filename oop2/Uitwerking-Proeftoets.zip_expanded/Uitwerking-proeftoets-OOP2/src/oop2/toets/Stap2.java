/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.toets;

import dit.niet.veranderen.Breuk;
import dit.niet.veranderen.Geheel;
import dit.niet.veranderen.RekenfoutException;

/**
 *
 * @author huub
 */
public class Stap2 {
  
  public Stap2() {
    super();
  }
  
  public static void main(String[] args) {
    Stap2 opg = new Stap2();
    opg.opgave();
  }
  
  private void opgave() {
    Breuk b = new Breuk(3,5);
    Geheel g = new Geheel(3);
    try {
      g.vermenigvuldig(b);
    } catch (RekenfoutException rfex) {
      System.out.println("Er is een fout opgetreden.");
      System.out.println("Fout: " + rfex.getMessage());
    }
  }
}
