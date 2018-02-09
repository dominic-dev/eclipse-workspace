package stars;

public class Stars {

	public Stars() {
	}

    public static void main(String[] args) {
        Stars stars = new Stars();

        System.out.println("Actual\t| Expected | Match");
        System.out.println("------------------");
        for(int i=1; i<100; i++){
            int count = stars.stars(i);
            int expected = (int) ((5.0/2) * (i-1) * i);
            System.out.print(count + "\t| " + expected + "\t | ");
            if(count == expected){
                System.out.print("  X");
            }
            System.out.print("\n");
        }
    }
    
    private int stars(int n){
        int counter =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                for(int k=0; k<5; k++)
                //System.out.print("*");
                counter++;
            }
        }
        return counter;
    }

}
