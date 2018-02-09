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
public class BetrokkenPartij {
  
  String naam;
  Contract contract;
  
  public BetrokkenPartij() {
    super();
  }
  
  public BetrokkenPartij(String naam, Contract contract) {
    super();
    this.naam = naam;
    this.contract = contract;
  }
  
  public boolean isBetrouwbaar() {
    if (this.contract != null && this.contract.getRisico() >= 7){
        return false;
    }
    return true;
  }
  
  public String getNaam() {
    return naam;
  }
  
  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder();
    buf.append("Partij: ")
            .append(naam)
            .append(", contract = ")
            .append(contract.getType())
            .append(" is ")
            .append(isBetrouwbaar() ? "WEL" : "NIET")
            .append(" betrouwbaar.");
    return buf.toString();
  }
  
  public Contract getContract() {
    return contract;
  }

}
