
public class Main {

    final static int aantalWerknemers = (int) (Math.random() * 10 + 1); 
    final static int aantalVrijwilligers = (int) (Math.random() * 10 + 1);
    final static int aantalZzpers = (int) (Math.random() * 10 + 1);

	public static void main(String[] args) {
        Bedrijf bedrijf1 = new Bedrijf("Koekwous");
        for (int i = 0; i < aantalWerknemers; i++) {
            Werknemer w = new Werknemer((double) Math.random() * 1000, "Werknemer" + i);
            bedrijf1.neemInDienst(w);
        }
        for (int i = 0; i < aantalVrijwilligers; i++) {
            Vrijwilliger v = new Vrijwilliger("Vrijillger" + i);
            bedrijf1.neemInDienst(v);
        }
        for (int i = 0; i < aantalZzpers; i++) {
            Zzper z = new Zzper((double) Math.random() * 100, "Zzper" + i);
            z.voegWerkurenToe((int) (Math.random() * 50));
            bedrijf1.neemInDienst(z);
        }

        Manager m = new Manager(5000.0, 1, "Koekert");
        m.kenBonusToe(1000000.0);
        bedrijf1.neemInDienst(m);

        System.out.println(bedrijf1);

        bedrijf1.betaalSalarissen();

        System.out.println(bedrijf1.aantalManagers());
	}

}
