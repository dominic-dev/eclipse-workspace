package oop2.toets;

public class Stap4 {

    public static void main(String[] args) {
    int aantal = countOccurenceOf("MIW",
    "voorMIW3maalMIWgeschrevenMIW");
    System.out.println("Ik heb 10 punten gehaald voor stap 4: "+
    (aantal==3) );
    }

    public static int countOccurenceOf(String target, String source){
        int index = source.indexOf(target);
        if (index == -1) return 0;
        return 1 + countOccurenceOf(target, source.substring(++index));
    }

 
}
