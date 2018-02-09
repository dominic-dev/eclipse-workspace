package nl.hva.ict.oop2.deel2;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author huub
 */
public class Vak {

    private String naam;
    private Collection<Vak> verplichteVakken;
    private Collection<Leerling> deelnemers;

    public Vak(String naam) {
        super();
        this.naam = naam;
        this.verplichteVakken = new ArrayList();
        this.deelnemers = new ArrayList();
    }

    public void inschrijven(Leerling leerling) throws OnvoldoendeVoorkennisExceptie {
        if (leerling.getBehaaldeVakken().containsAll(verplichteVakken)) {
            deelnemers.add(leerling);
            System.out.println("Leerling " + leerling + " ingeschreven voor " + this);
        } else {
            throw new OnvoldoendeVoorkennisExceptie("Leerling " + leerling + " voldoet niet aan de eisen voor vak " + this);
        }
    }

    public void stelVerplicht(Vak vak) {
        verplichteVakken.add(vak);
    }

    @Override
    public String toString() {
        return naam;
    }

}
