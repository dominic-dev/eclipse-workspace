public class Merry {

	public String voornaam;
	public String achternaam;
	public String tussenvoegsel;

    public Merry(String voornaam, String achternaam, String tussenvoegsel) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.tussenvoegsel = tussenvoegsel;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

	public void setAchternaam(String achternaam) {
    	this.achternaam = achternaam;
	}

	public String getAchternaam() {
    	return achternaam;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
    	this.tussenvoegsel = tussenvoegsel;
	}

	public String getTussenvoegsel() {
    	return tussenvoegsel;
	}

}
