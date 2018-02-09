/*
 * This file was created to facilitate lessons at HBO-ICT@HvA.
 */
package leseenheidapp.models;

public class LesEenheid {

    protected final static double CIJFER_STANDAARD_WAARDE = -1;
    protected final static boolean GEHAALD_STANDAARD_WAARDE = false;
    protected final static double CIJFER_GEHAALD_MINIMUM = 5.5;

	private String naam;
	private int ects;
	private int studiejaar;

    public LesEenheid(String naam, int ects, int studiejaar) {
		this.naam = naam;
		this.ects = ects;
		this.studiejaar = studiejaar;
    }

	public String getNaam() {
    	return naam;
	}

	public int getEcts() {
    	return ects;
	}

	public int getStudiejaar() {
    	return studiejaar;
	}

    @Override
    public String toString() {
        return String.format("%s %d %d", naam, ects, studiejaar);
    }

}
