package nl.movep.sequence;

public class SequenceClient {

  public static void main(String[] args) {
    Sequence seq1 = new Sequence();
    System.out.println("Sequence 1 is: " + seq1);
    
    Sequence seq2 = seq1.add(1.0);
    Sequence seq3 = seq2.add(3.0);
    System.out.println("Sequence 2 is: " + seq2);
    System.out.println("Sequence 3 is: " + seq3);
    
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
    
    Sequence seq5 = Sequence.create(new double[] {});
    System.out.println("Sequence 5 is: " + seq5);
  }
  
//  public int size(Sequence seq) {
//	  int length = 0;
//	  if ( seq.isEmpty() ) {
//		  length = 0;
//	  } else {
//		  try {
//			length = 1 + size(seq.tail());
//		} catch (EmptySequenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	  }
//	  return length;
//  }

  public int size(Sequence seq) throws EmptySequenceException {
	  return seq.size();
  }
  
}
