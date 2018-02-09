/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit.niet.veranderen;

import java.io.Serializable;

/**
 *
 * @author huub
 */
public abstract class Getal implements Serializable {
  
  public abstract void telop(Getal g) throws RekenfoutException;
  public abstract void vermenigvuldig(Getal g) throws RekenfoutException;  
}
