
public class Manager extends Werknemer{
    public double bonus;

    public Manager(double maandsalaris, int volgnummer, String naam) {
        super(maandsalaris, volgnummer, naam);
    }

    public void kenBonusToe(double bonus){
        this.bonus += bonus;
    }

    @Override
    public double betaalUit(){
        double result = super.betaalUit() + bonus;
        bonus = 0;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s bonus: %.2f", super.toString(), bonus);
    }

}
