import java.util.Scanner;

public class Launcher {
    public static Scanner input = new Scanner(System.in);
    public static int nAutos;

    public static String[] kentekens;
    public static int[] parkeerduur;
    public static double[] kosten;

	public static void main(String[] args) {
        System.out.println("Dit programma is gemaakt door Dominic Dingena MIW 10");
        System.out.println("Student nr ?");

        System.out.print("Hoeveel auto's hebben geparkeerd? ");
        nAutos = input.nextInt();
        kentekens = new String[nAutos];
        parkeerduur = new int[nAutos];
        kosten = new double[nAutos];

        // Vraag de gevens voor elke auto
        for(int i=0; i < nAutos; i++){
            vraagAuto(i);
        }

        // Print het overzicht
        System.out.println("\nParkeeroverzicht");
        System.out.printf("%-15s %4s %4s", "kenteken", "uren", "bedrag\n");

        double totaalKosten = 0.0;
        for(int i=0; i < nAutos; i++){
            System.out.printf("%-15s %4d %4.2f\n", kentekens[i], parkeerduur[i], kosten[i]);
            totaalKosten += kosten[i];
        }
        System.out.printf("\nTotaal van alle parkeergelden: %.2f euro\n", totaalKosten);
	}

    /**
     * Neem de index van de auto, vraag om kenteken en parkeerduur.
     * Sla dit op in aangemaakte arrays.
     **/
    
	private static void vraagAuto(int index) {
        System.out.printf("\nAuto %d: \n", index+1);
        System.out.print("\tKenteken: ");
        kentekens[index] = input.next();

        System.out.print("\tGeparkeerde uren (max. 24): ");
        int duur = input.nextInt();
        while (duur > 24){
            System.out.println("\tDe parkeerduur kan max. 24 uur zijn");
            System.out.print("\tGeparkeerde uren (max. 24): ");
            duur = input.nextInt();
        }
        parkeerduur[index] = duur;
        kosten[index] = berekenParkeergeld(duur);
	}

    /**
     * Neem de parkeerdeer, geef de kosten.
     * @param parkeerduur De parkeerdur
     * @return de kosten
     **/
    
    public static double berekenParkeergeld(int parkeerduur){
        double kosten = 0.0;
        if (parkeerduur > 3){
            kosten += 3 * 3.75;
            kosten += (parkeerduur - 3) * 2.75;
        }
        else{
            kosten = parkeerduur * 3.75;
        }
        if (kosten > 25) kosten = 25;
        return kosten;
    }
	
}
