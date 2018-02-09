package nl.hva.ict.oop2.deel1;

public abstract class Biertype implements Brouwduur {
    protected int rijpduur = 0;

    abstract void rijp();

    public void gist(int aantalWeken){
        for(int i=0; i<aantalWeken; i++) rijp();
    }
    

}
