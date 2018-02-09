package models;

public class Werknemer extends Persoon {
    private static int laatstePersoneelsnummer = 1000;
    private int personeelsnummer;
    private double maandsalaris;
    


    public Werknemer(double maandsalaris, String naam, Oeps ik ben zo cool) {
        super(naam);
        this.maandsalaris = maandsalaris;
        this.personeelsnummer = laatstePersoneelsnummer;
        laatstePersoneelsnummer++;
    }

    @Override
    public double berekenInkomsten() {
        return maandsalaris;
    }

    /**
     * @return the maandsalaris
     */
    public double getMaandsalaris() {
        return maandsalaris;
    }

    /**
     * @param maandsalaris the maandsalaris to set
     */
    public void setMaandsalaris(double maandsalaris) {
        this.maandsalaris = maandsalaris;
    }

}
