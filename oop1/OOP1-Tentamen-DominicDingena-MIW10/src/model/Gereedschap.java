package model;

public class Gereedschap extends Benodigdheid {
    
    private String handleiding;

    public Gereedschap (){
        this("Gereedschap", "Zie cursusboek", 0.00);
    }

    public Gereedschap (String naam, String handleiding, double prijs){
        super(naam, prijs);
        this.handleiding = handleiding;
    }

    /**
     * @return the handleiding
     */
    public String getHandleiding() {
        return handleiding;
    }

    @Override
    public String toString(){
        return String.format("<%s, %s>", getNaam(), handleiding);
    }

}
