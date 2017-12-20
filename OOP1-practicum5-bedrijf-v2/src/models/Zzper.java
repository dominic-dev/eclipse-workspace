package models;

public class Zzper extends Oproepkracht {
    private double uurtarief;
    
    /**
     * @param uurtarief
     */
    public Zzper(double uurtarief, String naam) {
        super(naam);
        this.uurtarief = uurtarief;
    }

    @Override
    public double berekenInkomsten() {
        return uurtarief * getUrenGewerkt();
    }
}
