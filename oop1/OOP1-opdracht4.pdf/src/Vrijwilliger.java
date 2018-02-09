public class Vrijwilliger extends Persoon {

	private String naam;

    public Vrijwilliger(String naam) {
        super(naam);
    }

	public String getNaam() {
    	return naam;
	}

    @Override
	public double betaalUit() {
    	return 0.0;
	}

}
