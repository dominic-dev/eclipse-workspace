
public class Zzper extends Persoon{
    private double uurtarief;
    private int urenGewerkt;

    public Zzper(double uurtarief, String naam){
        super(naam);
        this.uurtarief = uurtarief;
    }

    public void voegWerkurenToe(int uren) {
        urenGewerkt += uren;
        
    }
    @Override
	public double betaalUit() {
        double result = uurtarief * urenGewerkt;
        urenGewerkt = 0;
        return result;
	}

    @Override
    public String toString() {
        return String.format("%s uurtarief: %.2f", super.toString(), uurtarief);
    }

}
