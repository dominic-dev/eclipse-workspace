import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) {
        //System.out.println("Faculty");
        //System.out.println(faculty(3));
        //printIntegersDown(10);
        //printIntegersUp(10);
        //int[] arr = {1, 2, 3};
        //int result = cumulativeSum(arr);
        //int result = cumSumEff(arr, 0, 0);
        //System.out.println(result);
        //printIntegersFlex(0, 10, 2);
        //printIntegersFlex(10, 0, -3);
        //fibonacci(2, 1, 50);
        //System.out.println(multiply(3, 5));
        //System.out.println(power(2, 2));
        //System.out.println(power(2, 3));
        //System.out.println(power(2, 4));
        //System.out.println(power(2, 5));
        //System.out.println(division(10, 5));
        //System.out.println(division(9, 3));
        //System.out.println(division(10, 2));
        //System.out.println(division(8, 3));
        //System.out.println(divisionFloat(8, 3, 3));
        //System.out.println(divisionFloat(9, 3, 1));
        System.out.println(reverseWords("Hallo Recursie Whoop Goede Morgen"));
    }

    public static int faculty(int n){
        LOGGER.log(Level.INFO, String.valueOf(n));
        if(n == 1){
            return 1;
        }
        return n * faculty(n - 1);
    }

    public static int cumulativeSum(int[] array){
        return cumulativeSum(array, 0);
    }

    public static int cumulativeSum(int[] array, int n){
        if (n == array.length - 1){
            return array[n];
        }
        return array[n] + cumulativeSum(array, n+1);
    }

    public static void printIntegers(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printIntegers(n-1);
    }


    public static void printIntegersUp(int max){
        printIntegersUp(0, max);
    }

    public static void printIntegersUp(int n, int max){
        System.out.println(n);
        if(n < max){
            printIntegersUp(n+1, max);
        }
    }

    public static void printIntegersFlex(int start, int end, int increment){
        if((increment > 0 && start > end) 
                || increment < 0 && start < end){
            return;
        }
        if((end - start > 0 && increment < 1) 
                || (end - start < 0 && increment > -1) 
                || increment == 0){
            throw new IllegalArgumentException();
        }
        System.out.println(start);
        printIntegersFlex(start + increment, end, increment);
    }

    public static void fibonacci(int max){
        fibonacci(1, 1, max);
    }

    public static void fibonacci(int n1, int n2, int max){
        if(n1 <= max){
            System.out.println(n1);
            fibonacci(n2, n1+n2, max);
        }
    }

    public static boolean groupSum(int index, int[] array, int target){
        target -= array[index];
        if(index == array.length - 1){
            return target == 0;
        }
        return groupSum(++index, array, target);
    }

    public boolean splitOdd10(int[] nums) {
        return false;
    }

    public static int multiply(int a, int b){
        if (b == 1) return a;
        return a + multiply(a, --b);
    }

    public static int power(int i, int pow){
        if(pow == 1) return i;
        return multiply(i, power(i, --pow));
    }

    public static int division(int a, int b){
        return division(a, b, 1);
    }

    public static int division(int a, int b, int n){
        if(a < 0) return n-2;
        else if(a == 0) return n-1;
        return division(a-b, b, ++n);
    }

    public static String reverseWords(String before){
        return reverseWords(before, "");
    }

    public static String reverseWords(String before, String after){
        int lastSpace = before.lastIndexOf(" ");
        if(lastSpace == -1) return after + before;
        after += before.substring(lastSpace + 1, before.length()) + " ";
        return reverseWords(before.substring(0, lastSpace), after);
    }

}
