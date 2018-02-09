package nl.hva.sorteren;

import java.util.Random;

public class RijenFabriek {
  
  // ArrayFabriek is een utility cass die alleen static methods bevat.
  // Er worden nooit instanties van gemaakt dus er is geen public constructor.
  private RijenFabriek() {
    super();
  }
  
  public static int[] randomRij(int size) {
    int[] rij = new int[size];
    Random random = new Random();
    for (int i=0; i<size; i++) {
      rij[i] = random.nextInt(10000);
    }
    return rij;
  }
  
  public static int[] stijgendeRij(int size) {
    int rij[] = new int[size];
    for (int i=0; i<size; i++) {
      rij[i] = i;
    }
    return rij;
  }

  public static int[] dalendeRij(int size) {
    int rij[] = new int[size];
    for (int i=0; i<size; i++) {
      rij[i] = size+1-i;
    }
    return rij;
  }

  public static int[] constanteRij(int size) {
    int rij[] = new int[size];
    for (int i=0; i<size; i++) {
      rij[i] = 1;
    }
    return rij;
  }
  
  public static void printRij(int[] rij) {
    for ( int i=0; i<rij.length; i++ ) {
      System.out.print(rij[i] + (i<rij.length-1 ? ", " : ""));
    }
    System.out.println();
  }

}
