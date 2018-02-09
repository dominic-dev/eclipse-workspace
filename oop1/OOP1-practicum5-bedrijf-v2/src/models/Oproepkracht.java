package models;

public abstract class Oproepkracht extends Persoon {
    private int urenGewerkt;

    public Oproepkracht(String naam) {
        super(naam);
    }

    /**
     * @return the urenGewerkt
     */
    public int getUrenGewerkt() {
        return urenGewerkt;
    }

    public void huurIn(int uren){
        urenGewerkt += uren;
    }

}
