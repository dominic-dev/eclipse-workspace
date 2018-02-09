abstract public class Persoon implements Comparable<Persoon>{

	private String naam;

    public Persoon(String naam) {
        this.naam = naam == null ? "" : naam;
    }

	public String getNaam() {
    	return naam;
	}

    /**
     * Geef het salaris per maand.
     * @return het maandsalaris
     **/
    abstract public double betaalUit();

    /**
     * Geef de inkomsten per maand
     **/
    abstract public double berekenInkomsten();

    /**
     * Vergelijk personen op naam
     **/
    public int compareTo(Persoon ander){
        return this.naam.compareTo(ander.naam);
    }

    @Override
    public String toString() {
        return String.format("%s naam: %s", this.getClass().getSimpleName(), naam);
    }
}
