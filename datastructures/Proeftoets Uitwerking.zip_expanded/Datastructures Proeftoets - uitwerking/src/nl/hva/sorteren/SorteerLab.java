package nl.hva.sorteren;

public class SorteerLab {
  
  public SorteerLab() {
    super();
  }

  public static void main(String[] args) {
    SorteerLab lab = new SorteerLab();
    lab.onderzoek();
  }

  private void onderzoek() {
    int[] rij1 = RijenFabriek.randomRij(40);
    SorteerMachine machine = new SorteerMachine();
    machine.setOrigineel(rij1);
    RijenFabriek.printRij(machine.getOrigineel());
    System.out.println();
    
    int count1 = machine.sorteer1();
    System.out.println("Aantal swaps voor methode 1: " + count1);
    RijenFabriek.printRij(machine.getGesorteerd());
    System.out.println();
    
    int count2 = machine.sorteer2();
    System.out.println("Aantal swaps voor methode 2: " + count2);
    RijenFabriek.printRij(machine.getGesorteerd());
  }
}
