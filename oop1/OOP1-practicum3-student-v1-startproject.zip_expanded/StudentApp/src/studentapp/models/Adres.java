package studentapp.models;

/**
 *
 * @author Dominic Dingena
 */
public class Adres {
    private String straat;
    private int huisNr;
    private String plaats;

    public Adres(String straat, int huisNr, String plaats){
        this.straat = straat;
        this.huisNr = huisNr; 
        this.plaats = plaats;
    }

    public String toString() {
        return String.format("%s %d, %s", straat, huisNr, plaats);
        //return "%s %d, %s".format(straat, huisNr, plaats)
    }
    
}
