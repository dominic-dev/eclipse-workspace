package main;

public class Paar<U, V> {

    private U eerste;
    private V tweede;

    public Paar(U eerste, V tweede){
        this.eerste = eerste;
        this.tweede = tweede;
    }

    public boolean gelijkeLengte(){
        return eerste.toString().length() == tweede.toString().length();
    }



}
