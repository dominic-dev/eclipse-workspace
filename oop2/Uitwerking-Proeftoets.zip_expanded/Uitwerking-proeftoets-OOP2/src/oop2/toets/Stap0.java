/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2.toets;

import dit.niet.veranderen.Breuk;

/**
 *
 * @author huub
 */
public class Stap0 {

  public Stap0() {
    super();
  }

  public static void main(String[] args) {
    Stap0 opg = new Stap0();
    opg.opgave();
  }

  private void opgave() {
    System.out.println("Dit is de OOP2 toets van Huub - 007");

    // Voorbeeld van het gebruik van de klasse Breuk
    Breuk b1 = new Breuk(1, 3); // b1 = 1/3
    Breuk b2 = new Breuk(3, 5); // b2 = 3/5
    System.out.println("b1: " + b1.toString());
    System.out.println("b2: " + b2.toString());
    try {
      b1.telop(b2);               // b1 = b1 + b2 = 14/15
    } catch (Exception ex) {
      System.out.println("Er is een fout opgetreden.");
    }
    System.out.println("b1: " + b1.toString());
  }

}
