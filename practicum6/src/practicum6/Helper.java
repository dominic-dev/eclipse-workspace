package practicum6;

public class Helper {
    public static boolean arrayHasInt(int[] arr, int number){
        for (int n : arr){
            if (n == number) return true;
        }
        return false;
    }
}
