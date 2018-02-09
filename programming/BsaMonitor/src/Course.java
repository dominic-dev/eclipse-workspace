import java.util.InputMismatchException;
import java.util.Scanner;

public class Course {
    public String name;
    public int credits;
    public double score;
    
    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
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