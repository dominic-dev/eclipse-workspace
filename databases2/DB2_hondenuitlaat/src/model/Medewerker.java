package model;

public class Medewerker {

	private String code;
	private String naam;

    public Medewerker(String code, String naam) {
		this.code = code;
		this.naam = naam;
    }

	public void setCode(String code) {
    	this.code = code;
	}

	public String getCode() {
    	return code;
	}

	public void setNaam(String naam) {
    	this.naam = naam;
	}

	public String getNaam() {
    	return naam;
	}

}
