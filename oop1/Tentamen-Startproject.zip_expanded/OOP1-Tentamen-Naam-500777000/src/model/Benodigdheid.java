package model;

public class Benodigdheid {
	
	public static final double BTW = 1.21;  // BTW is 21%

	private String naam;
	private double prijs;		// Prijs, exclusief BTW
	
	public Benodigdheid() {
		this("Generiek ding", 0.00);
	}
	
	public Benodigdheid(String n, double p) {
		super();
		naam = n;
		prijs = p;
	}
	
	/**
	 * Bereken de prijs inclusief BTW.
	 * @return prijs incl BTW.
	 */
	public double berekenPrijsInclBTW() {
		return BTW * prijs;
	}

	/**
	 * Bereken de prijs exclusief BTW.
	 * @return prijs excl BTW.
	 */
	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
}
