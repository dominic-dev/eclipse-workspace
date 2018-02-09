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
  }
  
}
