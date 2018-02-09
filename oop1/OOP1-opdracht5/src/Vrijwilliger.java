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
        return berekenInkomsten();
	}

    public double berekenInkomsten(){
        return 0.0;
    }

    

}
