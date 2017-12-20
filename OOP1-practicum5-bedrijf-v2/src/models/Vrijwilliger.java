package models;

public class Vrijwilliger extends Oproepkracht {    

    public Vrijwilliger(String naam) {
        super(naam);
    }

    @Override
    public double berekenInkomsten() {
        return 0;
    }
}
