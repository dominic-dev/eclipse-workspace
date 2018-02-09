import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public Main(){
        //LogManager.getLogManager().reset();
        
        //oefening1();
        //oefening2();
        //oefening3();
        //oefening4();
        oefening5();
    }

	public static void main(String[] args) {
        Main main = new Main();
	}
    
    /**
     * Oefening 12.5
     **/
    public void oefening5(){
        try {
            Triangle triangle1 = new Triangle(2, 2, 2);
            LOGGER.log(Level.INFO, "Ok.");
        } catch(Exception e){
            e.printStackTrace();
        }

        try {
            LOGGER.log(Level.INFO, "Ok.");
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    

    /**
     * Oefening 12.4
     **/
    public void oefening4(){
        System.out.println("Enter a number");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        getLoan(i);
    }

    public boolean getLoan(int i) throws IllegalArgumentException{
        if(i <= 0){
            throw new IllegalArgumentException();
        }
        return true;
    }

    /**
     * Oefening 12.3
     **/
    public void oefening3(){
        int size = 100;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = randomInt(0, 10);
        }

        System.out.println("Which index would you like to view?");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        try {
            int value = array[answer];
            System.out.println("Value: " + value);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Out of Bounds.");
        }
    }

    /**
     * Oefening 12.2
     **/
    public void oefening2(){
        boolean correct = false;
        while(!correct){
            try {
                askForSum();
                correct = true;
                System.out.println("Correct!");
            } catch(InputMismatchException e){
                System.out.println("Try again.");
            }
        }
    
    }
    /**
     * askForSum
     **/
    public void askForSum() throws InputMismatchException{
        int number1 = randomInt(0, 10);
        int number2 = randomInt(0, 10);
        String message = "What is the sum of %d and %d?";
        System.out.println(String.format(message, number1, number2));
        int expected = number1 + number2;
        LOGGER.log(Level.INFO, String.format("expected: %d", expected));

        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        if (answer != expected){
            throw new InputMismatchException();
        }
    }

    /**
     * Return a random integer between min and max
     * @param min : the minimum
     * @param max : the maximum
     * @return the random integer
     **/
    public int randomInt(int min, int max){
        int range = max - min;
        return (int) (Math.random() * range + (+ 1));
    }

    /**
     * Oefening 12.1
     **/
    public void oefening1(){
        Calculator calc = new Calculator();

        try {
            int number1 = askForNumber();
            int number2 = askForNumber();
            System.out.println("Product:");
            System.out.println(calc.product(number1, number2));
        } catch(NumberFormatException e){
            System.out.println("Wrong input");
        }
    }

    /**
     * Ask the user for a number.
     **/
    public static int askForNumber() throws NumberFormatException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        String answer = input.nextLine();
        
        String pattern = "^\\d*$";
        if(!answer.matches(pattern)){
            throw new NumberFormatException("Wrong input");
        }
        return Integer.valueOf(answer);
    }


}
