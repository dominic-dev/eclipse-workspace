/**
 * @author Dominic Dingena
 **/

package model;

public class Hout extends Benodigdheid {

	private String soort;
	private double lengte;
	private double breedte;
	private double dikte;
	private int aantal;
    private final int NIET_GEVONDEN = -1;

    public Hout(String soort, double lengte, double breedte, double dikte, int aantal, String naam, double prijs) {
        super(naam, prijs);
		this.soort = soort;
		this.lengte = lengte;
		this.breedte = breedte;
		this.dikte = dikte;
		this.aantal = aantal;
    }

    /**
     * @return De partijprijs incl btw
     **/
    @Override
    public double berekenPrijsInclBTW(){
        return berekenPrijsExBTW() * BTW;
    }

    /**
     * @return De partijprijs ex btw
     **/
    @Override
    public double berekenPrijsExBTW(){
        double totaalKubiekeMeter = aantal * lengte * breedte * dikte;
        return totaalKubiekeMeter * getPrijs();
    }

    @Override
    public String toString(){
        return String.format("%s\n%d planken %s van %.2fx%.2fx%.2f", super.toString(), aantal, soort, lengte, breedte, dikte);
    }

    /**
     * @param vakDiepten de beschikbare vakken
     * @return De index van het best passende vak.
     **/
    public int zoekPassendeOpslag(double[] vakDiepten){
        int result = NIET_GEVONDEN;

        for (int i=0; i<vakDiepten.length; i++){
            // Hij moet wel passen
            if (lengte >= vakDiepten[i]){
                continue;
            }
            // Eerste kandidaat
            if(result == NIET_GEVONDEN){
                result = i;
                continue;
            }   
            // Volgende kandidaten
            if (vakDiepten[i] < vakDiepten[result]){
                result = i;
            }
        }
        return result;
    }

    /**
     * Getters en setters
     **/
	public void setSoort(String soort) {
    	this.soort = soort;
	}

	public String getSoort() {
    	return soort;
	}

	public void setLengte(double lengte) {
    	this.lengte = lengte;
	}

	public double getLengte() {
    	return lengte;
	}

	public void setBreedte(double breedte) {
    	this.breedte = breedte;
	}

	public double getBreedte() {
    	return breedte;
	}

	public void setDikte(double dikte) {
    	this.dikte = dikte;
	}

	public double getDikte() {
    	return dikte;
	}

	public void setAantal(int aantal) {
    	this.aantal = aantal;
	}

	public int getAantal() {
    	return aantal;
	}


}
