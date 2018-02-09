package stap1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
	
	public Main() {
		super();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
	
	private void run() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (int i=0; i<20; i++) {
			values.add(i);
		}
		Collections.shuffle(values);
		BinaryTree<Integer> tree = new BinaryTree<Integer>(values);
		tree.printTree();
		
		Iterator<Integer> iter = tree.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next() + ", ");
		}
	}
}
