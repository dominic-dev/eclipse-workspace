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
public class Contract {
  
  private String type;
  private int risico;
  
  public Contract(String type, int risico) {
    super();
    this.type = type;
    this.risico = risico;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getRisico() {
    return risico;
  }

  public void setRisico(int risico) {
    this.risico = risico;
  }
  
  public String toString() {
    return "[" + type +"," + risico + "]";
  }
}
