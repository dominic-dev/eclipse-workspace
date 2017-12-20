import models.Bedrijf;
import models.Manager;
import models.Vrijwilliger;
import models.Werknemer;
import models.Zzper;

import javadb.DB;

public class Main {
    final static int aantalWerknemers = (int) (Math.random() * 10 + 1); 
    final static int aantalVrijwilligers = (int) (Math.random() * 10 + 1);
    final static int aantalZzpers = (int) (Math.random() * 10 + 1);

    public static void main(String[] args) {
        printBedrijf();

        connectToDatabase();

        run();

        DB.closeConnection();
        System.out.println("Connection closed");
    }

    private static void run() {
        // TODO Auto-generated method stub

    }

    private static void connectToDatabase() {
        try {
            DB.openConnection();
            System.out.println("Connection open");
        } catch (Exception e) {
            System.out.println("\nEr is iets fout gegaan\n");
            e.printStackTrace();
        }
    }

    public static void printBedrijf(){
        Bedrijf bedrijf = new Bedrijf("Koekwous");
        for (int i = 0; i < aantalWerknemers; i++) {
            Werknemer w = new Werknemer((double) Math.random() * 1000, "Werknemer" + i);
            bedrijf.neemInDienst(w);
        }
        for (int i = 0; i < aantalVrijwilligers; i++) {
            Vrijwilliger v = new Vrijwilliger("Vrijillger" + i);
            bedrijf.neemInDienst(v);
        }
        for (int i = 0; i < aantalZzpers; i++) {
            Zzper z = new Zzper((double) Math.random() * 100, "Zzper" + i);
            z.huurIn((int) (Math.random() * 50));
            bedrijf.neemInDienst(z);
        }

        Manager m = new Manager(5000.0, "Koekert");
        m.kenBonusToe(1000000.0);
        bedrijf.neemInDienst(m);


        System.out.println(bedrijf);
        System.out.println();
        bedrijf.printInkomsten();
        System.out.println();
        System.out.println("Aantal managers: " + bedrijf.aantalManagers());

        
    }

}
