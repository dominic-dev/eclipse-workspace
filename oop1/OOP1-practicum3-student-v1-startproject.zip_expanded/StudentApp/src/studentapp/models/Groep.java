package studentapp.models;

/**
 *
 * @author Dominic Dingena
 */
public class Groep {
    private final int MAX_AANTAL_STUDENTEN = 30;
    private String naam;
    int aantalStudenten=0;
    Student[] studenten;

    public Groep(String naam){
        this.naam = naam;
        studenten = new Student[MAX_AANTAL_STUDENTEN];
    }

    public boolean voegStudentToe(Student student){
        if (aantalStudenten >= 30) {
            return false;
        }

        studenten[aantalStudenten] = student;
        aantalStudenten++;
        return true;
    }


    public String toString() {
        String result =String.format("Groepnaam: %s\n" +
                "Aantal studenten: %d\n",
                naam,
                aantalStudenten
                );
        for (Student student : studenten) {
            result += student
                    + "\n";
        }
        return result;
    }

}
