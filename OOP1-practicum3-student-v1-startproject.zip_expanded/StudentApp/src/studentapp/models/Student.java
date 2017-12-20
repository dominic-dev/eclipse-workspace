package studentapp.models;

/**
 *
 * @author Dominic Dingena
 */
public class Student {
    private String voornaam;
    private String achternaam;
    private Adres adres;

    public Student(String voornaam, String achternaam, Adres adres){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
    }

    public String toString() {
        return String.format(
                    "%s. %s\n%s",
                    voornaam.charAt(0),
                    achternaam,
                    adres
               );
    }

}
