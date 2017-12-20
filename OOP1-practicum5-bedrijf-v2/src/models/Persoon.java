package models;

public abstract class Persoon implements Comparable<Persoon>{
    private String naam;
    private int persoonNr;

    public abstract double berekenInkomsten();

    public Persoon(String naam){
        this.naam = naam;
    }

    public int compareTo(Persoon other){
        return this.naam.compareTo(other.naam);
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return the persoonNr
     */
    public int getPersoonNr() {
        return persoonNr;
    }

    /**
     * @param persoonNr the persoonNr to set
     */
    public void setPersoonNr(int persoonNr) {
        this.persoonNr = persoonNr;
    }

    @Override public String toString(){
        return naam;
    }

}
