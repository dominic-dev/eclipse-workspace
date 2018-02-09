package bsa;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Course {
    private String name;
    private int credits;
    private double score;
    
    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public int getCredits() {
        return credits;
    }
    
    public double askScore() {
        Scanner input = new Scanner(System.in);
        double score = 0.0;
        while (score == 0.0) {
            try {
                score = input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Geef een geldige invoer.");
                input = new Scanner(System.in);
            }
        }
        return score;
    }
    
    public boolean isPassed() {
        if (this.score >= 5.5) {
            return true;
        }
        return false;
    }
    

}
