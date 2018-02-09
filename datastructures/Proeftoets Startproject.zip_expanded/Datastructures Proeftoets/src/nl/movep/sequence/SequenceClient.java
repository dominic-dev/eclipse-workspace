package nl.movep.sequence;

public class SequenceClient {

	public static void main(String[] args) throws EmptySequenceException {
		Sequence seq1 = new Sequence();
		System.out.println("Sequence 1 is: " + seq1);
		System.out.println("Size: " + seq1.size());

		Sequence seq2 = seq1.add(1.0);
		Sequence seq3 = seq2.add(3.0);
		System.out.println("Sequence 2 is: " + seq2);
		System.out.println("Size: " + seq2.size());
		System.out.println("Sequence 3 is: " + seq3);
		System.out.println("Size: " + seq3.size());

		try {
			System.out.println("Head van sequence 3 is: " + seq3.head());
		} catch (EmptySequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("Tail van sequence 3 is: " + seq3.tail());
		} catch (EmptySequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Sequence seq4 = new Sequence(10);
		System.out.println("Sequence 4 is: " + seq4);
		System.out.println("Size: " + seq4.size());

		Sequence seq5 = Sequence.create(new double[] {});
		System.out.println("Sequence 5 is: " + seq5);
		System.out.println("Size: " + seq5.size());
	}

    public static int size(Sequence seq){
        return seq.size();
    }

}
