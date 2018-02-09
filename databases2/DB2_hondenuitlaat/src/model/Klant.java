package model;

public class Klant {

    private int klantNr;
    private String voorletters;
    private String voorvoegsel;
    private String achternaam;
    private int telefoon;

    public Klant(String voorletters, String achternaam, int telefoon) {
        this(voorletters, "", achternaam, telefoon);
    }

    public Klant(String voorletters, String voorvoegsel, String achternaam, int telefoon) {
        this.voorletters = voorletters;
        this.voorvoegsel = voorvoegsel;
        this.achternaam = achternaam;
        this.telefoon = telefoon;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    /**
     * @return the klantNr
     */
    public int getKlantNr() {
        return klantNr;
    }

    /**
     * @param klantNr the klantNr to set
     */
    public void setKlantNr(int klantNr) {
        this.klantNr = klantNr;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorvoegsel(String voorvoegsel) {
        this.voorvoegsel = voorvoegsel;
    }

    public String getVoorvoegsel() {
        return voorvoegsel;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setTelefoon(int telefoon) {
        this.telefoon = telefoon;
    }

    public int getTelefoon() {
        return telefoon;
    }

    @Override public String toString(){
        voorvoegsel = voorvoegsel == null ? "" : " " + voorvoegsel;
        return String.format("%s%s %s", voorletters, voorvoegsel, achternaam);
    }

}
