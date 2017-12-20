package models;

public class Manager extends Werknemer{
    private double bonus;

    public Manager(double maandsalaris, String naam) {
        super(maandsalaris, naam);
    }

    @Override
    public double berekenInkomsten() {
        return getMaandsalaris()+ bonus;
    }

    /**
     * @return the bonus
     */
    public void kenBonusToe(double bonus) {
        this.bonus = bonus;
    }

}
