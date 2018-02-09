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
public class Geheel extends Getal {
  
  private int waarde;
  
  public Geheel(int n) {
    super();
    waarde = n;
  }

  @Override
  public void telop(Getal g) throws RekenfoutException {
    if ( g instanceof Geheel ) {
      waarde += ((Geheel)g).waarde;
    } else {
      throw new RekenfoutException("Poging een breuk op te tellen bij een geheel getal");
    }
  }

  @Override
  public void vermenigvuldig(Getal g) throws RekenfoutException {
    if ( g instanceof Geheel ) {
      waarde *= ((Geheel)g).waarde;
    } else {
      throw new RekenfoutException("Poging een breuk te vermenigvuldigen met een geheel getal");
    }
  }
  
  @Override
  public boolean equals(Object obj) {
    boolean r = false;
    if ( obj instanceof Geheel ) {
      Geheel g = (Geheel)obj;
      r = (waarde == g.waarde);
    }
    return r;
  }
  
  @Override
  public String toString() {
    return "" + waarde;
  }
}
