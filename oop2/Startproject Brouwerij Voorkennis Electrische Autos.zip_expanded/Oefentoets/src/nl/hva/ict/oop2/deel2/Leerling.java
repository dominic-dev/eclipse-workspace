package nl.hva.ict.oop2.deel2;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author huub
 */
public class Leerling {

    private String naam;
    private Collection<Vak> behaaldeVakken;

    public Leerling(String naam) {
        super();
        this.naam = naam;
        behaaldeVakken = new ArrayList();
    }

    public void behaal(Vak vak) {
        behaaldeVakken.add(vak);
    }

    public Collection<Vak> getBehaaldeVakken() {
        return behaaldeVakken;
    }

    @Override
    public String toString() {
        return naam;
    }
}
