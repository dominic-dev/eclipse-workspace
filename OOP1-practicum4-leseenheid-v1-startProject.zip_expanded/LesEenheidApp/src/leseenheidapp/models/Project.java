/*
 * This file was created to facilitate lessons at HBO-ICT@HvA.
 */
package leseenheidapp.models;

public class Project extends LesEenheid implements LesEenheidInterface{
    private double productCijfer;
    private double procesCijfer;
    private double methodenEnTechniekenCijfer;

    public Project(double productCijfer, double procesCijfer, double methodenEnTechniekenCijfer, String naam, int ects, int studiejaar){
        super(naam, ects, studiejaar);
        this.productCijfer = productCijfer;
        this.procesCijfer = procesCijfer;
        this.methodenEnTechniekenCijfer = methodenEnTechniekenCijfer;
    }

    public Project(String naam, int ects, int studiejaar){
        super(naam, ects, studiejaar);
        this.productCijfer = CIJFER_STANDAARD_WAARDE;
        this.procesCijfer = CIJFER_STANDAARD_WAARDE;
        this.methodenEnTechniekenCijfer = CIJFER_STANDAARD_WAARDE;
    }

    
    public void setMethodenentechniekencijfer(double methodenEnTechniekenCijfer){
        this.methodenEnTechniekenCijfer = methodenEnTechniekenCijfer;
    }
    
    public void setProcescijfer(double procesCijfer){
        this.procesCijfer = procesCijfer;
    }
    
    public void setProductcijfer(double productCijfer){
        this.productCijfer = productCijfer;
    }

    public boolean isAfgerond(){
        if(procesCijfer >= 5.5 && productCijfer >= 5.5 && methodenEnTechniekenCijfer >= 5.5){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("product: %.2f %.2f %.2f, %s", productCijfer, procesCijfer, methodenEnTechniekenCijfer, super.toString());
    }
}
