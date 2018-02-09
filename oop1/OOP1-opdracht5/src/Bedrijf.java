import java.util.ArrayList;
import java.util.Arrays;

public class Bedrijf {

    private String naam;
    private ArrayList<Persoon> werknemers = new ArrayList<>();

    public Bedrijf(String naam) {
        this.naam = naam;
    }

    public void betaalSalarissen(){
        for (Persoon p : werknemers){
            String persoonToString = p.toString();
            double salaris = p.betaalUit();
            System.out.printf("Salaris uitbetaald voor: %s EUR %.2f\n", persoonToString, salaris);
        }
    }

    public void neemInDienst(Persoon persoon){
        werknemers.add(persoon);
    }

    public int aantalManagers(){
        int count = 0;
        for (Persoon p : werknemers){
            if (p instanceof Manager){
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString(){
        String result = String.format("Bedrijf %s\n", naam);
        for (Persoon w : werknemers) {
            result += String.format("%s\n", w);
        }
        return result;
    }

}
