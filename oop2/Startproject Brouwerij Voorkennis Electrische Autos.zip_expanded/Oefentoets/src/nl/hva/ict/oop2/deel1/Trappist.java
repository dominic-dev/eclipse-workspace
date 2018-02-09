package nl.hva.ict.oop2.deel1;

public class Trappist extends Biertype {
    private String naam;
    int aantalWeken = 0;;

    /**
     * @param naam de naam
     */
    public Trappist(String naam) {
        this.naam = naam;
    }

    @Override
    void rijp() {
        aantalWeken++;
        System.out.println(String.format("Trappist %s rijpt nu %d weken", naam, aantalWeken));
    }

    @Override
    public String toString(){
        return naam;
    }

}
