package model;

public class Hond {

    private String hondnaam;
    private String ras;
    private Klant klant;
    private String chipNr; 

    public Hond(String chipNr, String hondnaam, String ras, Klant klant) {
        this.chipNr = chipNr;
        this.hondnaam = hondnaam;
        this.ras = ras;
        this.klant = klant;
    }

    public void setHondnaam(String hondnaam) {
        this.hondnaam = hondnaam;
    }

    public String getHondnaam() {
        return hondnaam;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    /**
     * @return the klant
     */
    public Klant getKlant() {
        return klant;
    }

    /**
     * @param klant the klant to set
     */
    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    /**
     * @return the chipNr
     */
    public String getChipNr() {
        return chipNr;
    }

    /**
     * @param chipNr the chipNr to set
     */
    public void setChipNr(String chipNr) {
        this.chipNr = chipNr;
    }

    public String getRas() {
        return ras;
    }


    @Override
    public String toString(){
        return hondnaam;
    }
}
