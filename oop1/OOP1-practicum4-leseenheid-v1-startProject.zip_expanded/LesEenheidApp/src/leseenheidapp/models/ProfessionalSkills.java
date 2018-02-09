/*
 * This file was created to facilitate lessons at HBO-ICT@HvA.
 */
package leseenheidapp.models;

public class ProfessionalSkills extends LesEenheid implements LesEenheidInterface{
    private boolean gehaald;

    public ProfessionalSkills(boolean gehaald, String naam, int ects, int studiejaar){
        super(naam, ects, studiejaar);
        this.gehaald = gehaald;
    }

    public ProfessionalSkills(String naam, int ects, int studiejaar){
        super(naam, ects, studiejaar);
        this.gehaald = GEHAALD_STANDAARD_WAARDE;
    }

    public void setGehaald(boolean gehaald) {
        this.gehaald = gehaald;
    }

    public boolean isAfgerond(){
        return gehaald;
    }

    @Override
    public String toString() {
        return String.format("%s, Gehaald: %b", super.toString(), gehaald);
    }
}
