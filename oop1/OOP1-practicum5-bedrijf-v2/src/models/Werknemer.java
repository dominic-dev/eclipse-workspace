package models;

public class Werknemer extends Persoon {
    private static int laatstePersoneelsnummer = 1000;
    private int personeelsnummer;
    private double maandsalaris;
    

    public Werknemer(String naam) {
        super(naam);
        this.maandsalaris = 0;
        this.personeelsnummer = laatstePersoneelsnummer;
        laatstePersoneelsnummer++;
    }

    public Werknemer(double maandsalaris, String naam) {
        this(naam);
        this.maandsalaris = maandsalaris;
    }

    public Werknemer(int personeelsnummer, double maandsalaris,  String naam) {
        this(maandsalaris, naam);
        this.personeelsnummer = personeelsnummer;
    }

    double maandsalaris, int personeelsnummer



    public Werknemer() {
        this(naam, 0);
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
