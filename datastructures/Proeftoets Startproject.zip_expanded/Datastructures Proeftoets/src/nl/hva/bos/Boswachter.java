package nl.hva.bos;

public class Boswachter {
  
  public Boswachter() {
    super();
  }
  
  public static void main(String[] args) {
    Boswachter boswachter = new Boswachter();
    boswachter.makeItWork();
  }

  private void makeItWork() {
    BinaireBoom b = BinaireBoom.maakBoom(new int[] {3,4,2,5,1,8,6,7});
    System.out.println("De boom is: " + b);
    System.out.println("Het totaal van de knopen is: " + b.som());
    System.out.println("Het aantal knopen is: " + b.telKnopen());
    System.out.println("\nDiepte\n");

    long start;
    long duration;
    System.out.println("Tail");
    start = System.currentTimeMillis();
    System.out.println("De diepte van 3 is: " + b.diepte2(3));
    System.out.println("De diepte van 4 is: " + b.diepte2(4));
    System.out.println("De diepte van 2 is: " + b.diepte2(2));
    System.out.println("De diepte van 5 is: " + b.diepte2(5));
    System.out.println("De diepte van 1 is: " + b.diepte2(1));
    System.out.println("De diepte van 8 is: " + b.diepte(8));
    System.out.println("De diepte van 6 is: " + b.diepte(6));
    System.out.println("De diepte van 7 is: " + b.diepte(7));
    System.out.println("De diepte van 9 is: " + b.diepte(9));
    duration = System.currentTimeMillis() - start;
    System.out.println("Benodigde tijd (ms): " + duration);



    System.out.println("\nNo tail");
    start = System.currentTimeMillis();
    System.out.println("De diepte van 3 is: " + b.diepteGeenStaart(3));
    System.out.println("De diepte van 4 is: " + b.diepteGeenStaart(4));
    System.out.println("De diepte van 2 is: " + b.diepteGeenStaart(2));
    System.out.println("De diepte van 5 is: " + b.diepteGeenStaart(5));
    System.out.println("De diepte van 1 is: " + b.diepteGeenStaart(1));
    System.out.println("De diepte van 8 is: " + b.diepteGeenStaart(8));
    System.out.println("De diepte van 6 is: " + b.diepteGeenStaart(6));
    System.out.println("De diepte van 7 is: " + b.diepteGeenStaart(7));
    System.out.println("De diepte van 9 is: " + b.diepteGeenStaart(9));
    duration = System.currentTimeMillis() - start;
    System.out.println("Benodigde tijd (ms): " + duration);
  }
  
}
