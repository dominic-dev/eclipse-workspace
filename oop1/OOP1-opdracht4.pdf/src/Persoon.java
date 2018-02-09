public class Persoon {

	private String naam;

    public Persoon(String naam) {
		this.naam = naam;
    }

	public String getNaam() {
    	return naam;
	}

    /**
     * Geef het salaris per maand.
     * @return het maandsalaris
     **/
    
    public double betaalUit() {
        System.out.println("Deze methode is foutief aangeroepen.");
        return 0.0;

    }

    @Override
    public String toString() {
        return String.format("%s naam: %s", this.getClass().getSimpleName(), naam);
    }

}
