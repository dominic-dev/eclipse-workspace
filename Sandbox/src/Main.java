import java.lang.NullPointerException;

public class Main {

	public static void main(String[] args) {
		String xx = null;
		String yy = "yy";
		
		boolean result;
		result = yy.equals(xx);
		System.out.println(result);
		
		try{
		  result = xx.equals(yy);
		 } catch (NullPointerException e){
		  result = (xx == yy);
		 }
		 System.out.println(result);

	}

}
