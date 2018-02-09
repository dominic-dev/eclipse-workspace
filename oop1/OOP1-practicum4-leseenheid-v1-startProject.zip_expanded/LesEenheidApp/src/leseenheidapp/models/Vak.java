/*
 * This file was created to facilitate lessons at HBO-ICT@HvA.
 */
package leseenheidapp.models;

public class Vak extends LesEenheid implements LesEenheidInterface{

	private double cijfer;

    public Vak(double cijfer, String naam, int ects, int studiejaar) {
        super(naam, ects, studiejaar);
		this.cijfer = cijfer;
    }

    public Vak(String naam, int ects, int studiejaar) {
        super(naam, ects, studiejaar);
    }

	public void setCijfer(double cijfer) {
    	this.cijfer = cijfer;
	}

    public boolean isAfgerond(){
        if (this.cijfer >= 5.5){
            return true;
        }
        return false;
    }

    

    @Override
    public String toString() {
        return String.format("%s, cijfer: %.2f", super.toString(), cijfer);
    }
    
}
