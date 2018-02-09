package stap3;

public class Complexity {

	public Complexity() {
		super();
	}

	public static void main(String[] args) {
		Complexity complex = new Complexity();
		for (int n=0; n<10; n++) {
			System.out.print("n=" + n + ": ");
			int result = complex.printStars(n);
			System.out.print("Aantal sterren: " + result);
			int expected = (n*(n*n + 3*n - 4) / 6);
			System.out.print(" | Verwacht aantal sterren: " + expected);
			if (result == expected) System.out.print(" OK");
			System.out.println();
		}

		//verdubbeling();
	}

	/**
	 * Helper methode om de verdubbelingen te analyseren.
	 **/
	public static void verdubbeling(){
		Complexity complex = new Complexity();
		for (int n=1; n<100; n*=2) {
			System.out.print("n=" + n + ": ");
			int result = complex.printStars(n);
			System.out.print("Aantal sterren: " + result);
			int expected = (n*(n*n + 3*n - 4) / 6);
			System.out.print(" | Verwacht aantal sterren: " + expected);
			if (result == expected) System.out.print(" OK");
			System.out.println();
		}
	}

	private int printStars(int n) {
		int total = 0;
		for (int i=0; i<n; i++) {
			for ( int j=i+1; j<n; j++) {
				for (int k=j; k>=i; k--) {
					total++;
					System.out.print("*");
				}
			}
		}
		System.out.println();
		return total;
	}
}
