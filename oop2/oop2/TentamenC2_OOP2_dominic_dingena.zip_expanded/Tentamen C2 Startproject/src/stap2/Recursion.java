package stap2;

public class Recursion {

	public Recursion() {
		super();
	}

	public static void main(String[] args) {
		Recursion rec = new Recursion();
		rec.recursionTest();
	}

	private void recursionTest() {
		String s = "abcde";
		System.out.println("s is: " + s);
		System.out.println("Invert(s) is: " + invert(s));

		System.out.println(s + " is " + (isPalinDroom(s) ? "wel een" : "geen") + " palindroom");

		s = "meetsysteem";
		System.out.println(s + " is " + (isPalinDroom(s) ? "wel een" : "geen") + " palindroom");
	}

	/**
	 * Keer een String om.
	 * @param s de om te keren String.
	 * @return de omgekeerde String.
	 **/
	protected String invert(String s) {
		// Base case: keer restant om.
		if(s.length() <= 2){
			return StringSplitter.last(s) + StringSplitter.first(s);
		}
		// Recursieve deel: draai de laatste twee letters om  en voeg
		// hieraan toe het resultaat van de functie op de overgebleven letters.
		String substring = s.substring(s.length() - 1, s.length());
		return StringSplitter.last(substring) 
				+ StringSplitter.first(substring) 
				+ invert(s.substring(0, s.length() -1));
	}

	/**
	 * Return true als de gegeven String een palindroom is.
	 * @return true als, en alleen als de gegeven String een palindroom is.
	 **/
	protected boolean isPalinDroom(String s) {
		// Als de inverse gelijk is aan zichzelf is het een palindroom.
		return s.equals(invert(s));
	}

}
