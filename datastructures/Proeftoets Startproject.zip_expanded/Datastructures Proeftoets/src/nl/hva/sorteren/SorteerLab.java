package nl.hva.sorteren;

public class SorteerLab {
    // Finals
    private final int[] GROOTTES = new int[]{20, 40, 80};
    private final int AANTAL_RIJEN = 5;

    private int[][][] rijen = new int[GROOTTES.length][AANTAL_RIJEN][];
    // Swap counts
    private int[][] countsSorteer1 = new int[GROOTTES.length][AANTAL_RIJEN];
    private int[][] countsSorteer2 = new int[GROOTTES.length][AANTAL_RIJEN];
  
  public SorteerLab() {
    super();
  }

  public static void main(String[] args) {
    SorteerLab lab = new SorteerLab();
    lab.startSorteren();
    lab.berekenGemiddelden();
  }

  private void startSorteren(){
    SorteerMachine machine = new SorteerMachine();
      // For each row size
      for(int i=0; i<GROOTTES.length; i++){
        // For each n in AANTAL_RIJEN
        for(int j=0; j<AANTAL_RIJEN; j++){
            // Generate row
            rijen[i][j] = RijenFabriek.randomRij(GROOTTES[i]);
            // Sorteer 1
            machine.setOrigineel(rijen[i][j]);
            countsSorteer1[i][j] = machine.sorteer1();
            // Sorteer 2
            machine.setOrigineel(rijen[i][j]);
            countsSorteer2[i][j] = machine.sorteer2();
        }
      }
  }

  private void berekenGemiddelden(){
      System.out.println("\t\t| Sorteer 1 | Sorteer 2");
      System.out.println("------------------------------------------");
      // For each row size
      for(int i=0; i<GROOTTES.length; i++){
          int sorteer1Totaal = 0;
          int sorteer2Totaal = 0;
        // For each n in AANTAL_RIJEN
        for(int j=0; j<AANTAL_RIJEN; j++){
            sorteer1Totaal += countsSorteer1[i][j];
            sorteer2Totaal += countsSorteer2[i][j];
        }
          int sorteer1Average = sorteer1Totaal / AANTAL_RIJEN ;
          int sorteer2Average = sorteer2Totaal / AANTAL_RIJEN ;
          System.out.print(GROOTTES[i] + " elementen:\t| ");
          System.out.print(sorteer1Average + "\t    | " + sorteer2Average + "\n");
      }
  }

}
