/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author huub
 */
public class Rechtspersoon extends BetrokkenPartij {
  
  int kvkNummer;
  
  public Rechtspersoon(int kvk, String naam, Contract contract) {
    super(naam, contract);
    this.kvkNummer = kvk;
  }
  
  public int getKvkNummer() {
    return kvkNummer;
  }

  public void setKvkNummer(int kvkNummer) {
    this.kvkNummer = kvkNummer;
  }  
}
