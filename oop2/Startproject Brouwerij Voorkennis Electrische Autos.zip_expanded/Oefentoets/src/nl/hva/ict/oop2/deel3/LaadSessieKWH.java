/*
 * Dit bestand is gemaakt ten behoeve van lessen op de HvA.
 */
package nl.hva.ict.oop2.deel3;

/**
 *
 * @author breud
 */
import java.io.Serializable;

public class LaadSessieKWH implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private double lengthChargeSession;
    private double amountOfKWH;
    private int dayOfMonth;
    private int month;
    private int year;

    public LaadSessieKWH(long id, double lengthChargeSession, double amountOfKWH, int dayOfMonth, int month, int year) {
        this.id = id;
        this.lengthChargeSession = lengthChargeSession;
        this.amountOfKWH = amountOfKWH;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLengthChargeSession() {
        return lengthChargeSession;
    }

    public void setLengthChargeSession(double lengthChargeSession) {
        this.lengthChargeSession = lengthChargeSession;
    }

    public double getAmountOfKWH() {
        return amountOfKWH;
    }

    public void setAmountOfKWH(double amountOfKWH) {
        this.amountOfKWH = amountOfKWH;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "LaadSessieKWH{" + "id=" + id + ", lengthChargeSession=" + lengthChargeSession + ", amountOfKWH=" + amountOfKWH + ", dayOfMonth=" + dayOfMonth + ", month=" + month + ", year=" + year + '}';
    }

}
