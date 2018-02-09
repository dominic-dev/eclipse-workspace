public class Werknemer extends Persoon{

    private static int index = 0;
	private double maandsalaris;
	private final int volgnummer;
	private String naam;

    public Werknemer(double maandsalaris, String naam) {
        this(maandsalaris, index, naam);
        index++;
    }

    public Werknemer(double maandsalaris, int volgnummer, String naam) {
        super(naam);
		this.maandsalaris = maandsalaris;
		this.volgnummer = volgnummer;
		this.naam = naam;
    }

	public void setMaandsalaris(double maandsalaris) {
    	this.maandsalaris = maandsalaris;
	}

    @Override
	public double betaalUit() {
    	return maandsalaris;
	}

    @Override
    public String toString() {
        return String.format("%s volgnummer: %d maandsalaris: %.2f", super.toString(), volgnummer, maandsalaris);
    }
}
