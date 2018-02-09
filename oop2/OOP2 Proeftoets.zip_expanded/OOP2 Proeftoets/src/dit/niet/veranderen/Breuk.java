/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit.niet.veranderen;

/**
 *
 * @author huub
 */
public class Breuk extends Getal {
  
  private int teller;
  private int noemer;
  
  public Breuk(int t, int n) {
    super();
    teller = t;
    noemer = n;
    vereenvoudig();
  }
  
  @Override
  public void telop(Getal g) throws RekenfoutException {
    if ( g instanceof Breuk ) {
      Breuk b = (Breuk)g;
      teller = (teller*b.noemer + b.teller*noemer);
      noemer = noemer*b.noemer;
      //vereenvoudig();
    } else {
      throw new RekenfoutException("Poging een geheel getal op te tellen bij een breuk");
    }
  }

  @Override
  public void vermenigvuldig(Getal g) throws RekenfoutException {
    if ( g instanceof Breuk ) {
      Breuk b = (Breuk)g;
      teller *= b.teller;
      noemer *= b.noemer;
      vereenvoudig();
    } else {
      throw new RekenfoutException("Poging een geheel getal te vermenigvuldigen met een breuk");
    }
  }
  
  @Override
  public boolean equals(Object obj) {
    boolean r = false;
    if ( obj instanceof Breuk ) {
      Breuk b = (Breuk)obj;
      r =  (teller == b.teller && noemer == b.noemer);
    }
    return r;
  }
  
  private int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }

  private void vereenvoudig() {
    int d = gcd(teller, noemer);
    teller /= d;
    noemer /= d;
  }
  
  public String toString() {
    return ( teller + "/" + noemer );
  }
}
