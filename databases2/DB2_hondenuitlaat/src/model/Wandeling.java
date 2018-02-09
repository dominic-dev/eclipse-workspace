package model;

public class Wandeling {

	private String datum;
	private int duur;
	private Medewerker medewerker;
	private Hond hond;

    public Wandeling(String datum, int duur, Medewerker medewerker, Hond hond) {
		this.datum = datum;
		this.duur = duur;
		this.medewerker = medewerker;
		this.hond = hond;
    }

	public void setDatum(String datum) {
    	this.datum = datum;
	}

	public String getDatum() {
    	return datum;
	}

	public void setDuur(int duur) {
    	this.duur = duur;
	}

	public int getDuur() {
    	return duur;
	}

	public void setMedewerker(Medewerker medewerker) {
    	this.medewerker = medewerker;
	}

	public Medewerker getMedewerker() {
    	return medewerker;
	}

	public void setHond(Hond hond) {
    	this.hond = hond;
	}

	public Hond getHond() {
    	return hond;
	}

}

