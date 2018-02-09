package nl.hva.ict.oop2.deel2;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author huub
 */
public class School {

    private Collection<Leerling> leerlingen;
    private Collection<Vak> curriculum;

    public School() {
        super();
        leerlingen = new ArrayList();
        curriculum = new ArrayList();
    }

    public void startSchooljaar() {
        Leerling adri = new Leerling("Adri Aardnoot");
        Leerling bertus = new Leerling("Bertus Braaf");
        Leerling charlotte = new Leerling("Charlotte Chocola");

        Vak lezen = new Vak("Begrijpend lezen voor dyslectici");
        Vak rekenen1 = new Vak("Inleiding rekenkunde");
        Vak rekenen2 = new Vak("Voortgezette rekenkunde");

        rekenen1.stelVerplicht(lezen);
        rekenen2.stelVerplicht(lezen);
        rekenen2.stelVerplicht(rekenen1);

        adri.behaal(lezen);
        adri.behaal(rekenen1);

        bertus.behaal(lezen);

        try {
            rekenen2.inschrijven(adri);
        } catch (OnvoldoendeVoorkennisExceptie e) {
            System.out.println(e.getMessage());
        }
        try {
            rekenen2.inschrijven(bertus);
        } catch (OnvoldoendeVoorkennisExceptie e) {
            System.out.println(e.getMessage());
        }
        try {
            rekenen1.inschrijven(charlotte);
        } catch (OnvoldoendeVoorkennisExceptie e) {
            System.out.println(e.getMessage());
        }
        try {
            lezen.inschrijven(charlotte);
        } catch (OnvoldoendeVoorkennisExceptie e) {
            System.out.println(e.getMessage());
        }
    }

    private void schrijfIn(Leerling leerling) {
        leerlingen.add(leerling);
    }

    private void geefOnderwijs(Vak vak) {
        curriculum.add(vak);
    }

}
