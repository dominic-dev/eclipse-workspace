package stap2;

public class Main {

	public Main() {
		super();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.test();
	}
	
	private void test() {
		Verzameling<Integer> v = new Verzameling<>();
		
		if (v.bevat(3)) {
			System.out.println("Test 1 mislukt...");
		} else {
			System.out.println("Test 1 geslaagd!");
		}
		
		v.voegToe(3);
		if (v.bevat(3)) {
			System.out.println("Test 2 geslaagd!");
		} else {
			System.out.println("Test 2 mislukt...");
		}
		
		v.verwijder(3);
		if (v.bevat(3)) {
			System.out.println("Test 1 mislukt...");
		} else {
			System.out.println("Test 1 geslaagd!");
		}

        v.voegToe(2);
        Verzameling<Integer> v2 = new Verzameling<>();
        v2.voegToe(3);
        v2.voegToe(5);
        v2.voegToe(8);

        Verzameling<Integer> v3 = v.vereniging(v2);

        System.out.println("Verzamling 1: " + v);
        System.out.println("Verzamling 2: " + v2);
        System.out.println("Verzamling 1 verenigd met verzameling 2: " + v3);
	}
	
}
