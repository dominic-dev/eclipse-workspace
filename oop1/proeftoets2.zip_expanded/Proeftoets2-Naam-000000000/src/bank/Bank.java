    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;
import java.util.List;

import models.BetrokkenPartij;
import models.Contract;
import models.NatuurlijkPersoon;
import models.Rechtspersoon;

/**
 *
 * @author huub
 */
public class Bank {

  List<BetrokkenPartij> betrokkenPartijen = new ArrayList<BetrokkenPartij>();
  BetrokkenPartij[] partijenArray;

  public Bank() {
    super();
  }

  public static void main(String[] args) {
    System.out.println("Dit is de toets van Naam 500712345.");
    System.out.println();
    Bank leenmanZusjes = new Bank();
    leenmanZusjes.run();
  }

  private void run() {
    maakTestData();
    testStap1();
    testStap2();
    testStap3();
    testStap4();
  }

  private void maakTestData() {
    Contract contract1 = new Contract("Credit default swap", 10);
    Contract contract2 = new Contract("Spaarrekening", 7);
    Contract contract3 = new Contract("Beleggingsadvies", 2);
    
    BetrokkenPartij ministerie = new BetrokkenPartij("Ministerie van vrijetijdsbesteding", contract1);
    BetrokkenPartij ambassade = new BetrokkenPartij("Ambassade van Verweggistan", contract2);
    BetrokkenPartij belasting = new BetrokkenPartij("Belastingdienst", contract3);

    betrokkenPartijen.add(ministerie);
    betrokkenPartijen.add(ambassade);
    betrokkenPartijen.add(belasting);
    
    Contract annieContract1 = new Contract("Arbeidsovereenkomst", 2);
    Contract annieContract2 = new Contract("Salarisrekening", 3);

    NatuurlijkPersoon annie1 = new NatuurlijkPersoon(1234, 8, "Annie Apenstaart", annieContract1);
    NatuurlijkPersoon annie2 = new NatuurlijkPersoon(1234, 8, "Annie Apenstaart", annieContract2);
    NatuurlijkPersoon bertus1 = new NatuurlijkPersoon(3456, 5, "Bertus Braaf", new Contract("Hypotheek", 4));
    NatuurlijkPersoon bertus2 = new NatuurlijkPersoon(3456, 5, "Bertus Braff", new Contract("Spaarrekening", 3));
    NatuurlijkPersoon charlotte = new NatuurlijkPersoon(4432, 4, "Charlotte Chocola", new Contract("Spaarrekening", 3));
    NatuurlijkPersoon dirk1 = new NatuurlijkPersoon((5321), 7, "Dirk Draaikont", new Contract("Levering paperclips", 8));
    NatuurlijkPersoon dirk2 = new NatuurlijkPersoon((5321), 7, "Dirk Draaikont", new Contract("Levering potloden", 6));

    betrokkenPartijen.add(annie1);
    betrokkenPartijen.add(annie2);
    betrokkenPartijen.add(bertus1);
    betrokkenPartijen.add(bertus2);
    betrokkenPartijen.add(charlotte);
    betrokkenPartijen.add(dirk1);
    betrokkenPartijen.add(dirk2);

    Rechtspersoon fabriek = new Rechtspersoon(51234, "Limonadefabriek", new Contract("Levering prik", 9));
    Rechtspersoon winkel = new Rechtspersoon(56421, "Kledingwinkel", new Contract("Bedrijfskrediet", 8));
    Rechtspersoon club = new Rechtspersoon(72438, "Biljarterclub", new Contract(("Spaarrekening"), 4));

    betrokkenPartijen.add(fabriek);
    betrokkenPartijen.add(winkel);
    betrokkenPartijen.add(club);
    
    partijenArray = betrokkenPartijen.toArray(new BetrokkenPartij[5]);
  }

  private void testStap1() {
    // Tests voor stap 1
    for (BetrokkenPartij partij : betrokkenPartijen) {
      if (!(partij instanceof NatuurlijkPersoon) && !(partij instanceof Rechtspersoon)) {
        System.out.println(partij.getNaam() + " is " + (partij.isBetrouwbaar() ? "WEL" : "NIET") + " betrouwbaar");
      }
    }
    System.out.println();
  }

  private void testStap2() {
    // Tests voor stap 2
    for (BetrokkenPartij partij : betrokkenPartijen) {
      if (partij instanceof NatuurlijkPersoon) {
        System.out.println((NatuurlijkPersoon) partij);
      }
    }
    System.out.println();
  }

  private void testStap3() {
    // Tests voor stap 3
    for (BetrokkenPartij partij : betrokkenPartijen) {
      if (partij instanceof Rechtspersoon) {
        System.out.println((Rechtspersoon) partij);
      }
    }
  }
  
  private void testStap4() {
      // Tests voor stap 4
      ArrayList<NatuurlijkPersoon> natuurlijkPersonen = new ArrayList<>();
      for (BetrokkenPartij p : betrokkenPartijen){
          if (p instanceof NatuurlijkPersoon){
              natuurlijkPersonen.add((NatuurlijkPersoon) p);
          }
      }

      for (NatuurlijkPersoon p1 : natuurlijkPersonen){
          for (NatuurlijkPersoon p2 : natuurlijkPersonen){
              String gelijk = p1.equals(p2) ? "WEL" : "NIET";
              System.out.printf("%s is %s gelijk aan %s\n", natuurlijkPersonen.get(i).getNaam(),
                      gelijk, natuurlijkPersonen.get(j).getNaam());
              
          }
      }
  }

}
