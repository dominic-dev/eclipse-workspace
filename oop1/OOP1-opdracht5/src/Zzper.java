
public class Zzper extends Persoon implements Oproepbaar{
    private double uurtarief;
    private int urenGewerkt;

    public Zzper(double uurtarief, String naam){
        super(naam);
        this.uurtarief = uurtarief;
    }

    public void voegWerkurenToe(int uren){
        huurIn(uren);
    }
    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    public double berekenInkomsten(){
        return uurtarief * urenGewerkt;
    }
    @Override
	public double betaalUit() {
        double result = berekenInkomsten();
        urenGewerkt = 0;
        return result;
	}

    @Override
    public String toString() {
        return String.format("%s uurtarief: %.2f", super.toString(), uurtarief);
    }

}
