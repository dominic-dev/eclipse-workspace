package stap2;

public class StringSplitter {
	
	public static String first(String s) {
		int mid = s.length() / 2;
		return s.substring(0, mid);
	}
	
	public static String last(String s) {
		int mid = s.length() / 2;
		return s.substring(mid);
	}

}
