package models;

import java.util.ArrayList;
import java.util.Collections;

public class Bedrijf {

    private String naam;
    private ArrayList<Persoon> medewerkers;

    public Bedrijf(String naam) {
        this.naam = naam;
        medewerkers = new ArrayList<>();
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void printInkomsten(){
        System.out.println("Inkomsten van alle personen:");
        Collections.shuffle(medewerkers);
        medewerkers.sort(null);
        for (Persoon p : medewerkers){
            System.out.println(String.format("\t%s, inkomsten: %.2f", p, p.berekenInkomsten()));
        }
    }

    public int aantalManagers(){
        int count = 0;
        for (Persoon p : medewerkers){
            if (p instanceof Manager) count++;
        }
        return count;
    }

    public void neemInDienst(Persoon medewerker){
        medewerkers.add(medewerker);
    }

    /**
     * @return the medewerkers
     */
    public ArrayList<Persoon> getMedewerkers() {
        return medewerkers;
    }

    @Override
    public String toString(){
        String result;
        result = String.format("Bedrijf %s heeft %d medewerkers\n", naam, medewerkers.size());
        for (Persoon p : medewerkers) {
            result += String.format("\t%s\n", p);
        }
        return result;
    }

}
