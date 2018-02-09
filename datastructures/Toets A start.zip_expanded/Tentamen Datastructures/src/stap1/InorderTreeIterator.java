package stap1;

/**
 * In order tree Iterator for TreeNode<T>
 * 
 * @author dominic & MiW
 **/

import java.util.ArrayList;
import java.util.Iterator;

public class InorderTreeIterator<T extends Comparable<T>> implements Iterator<T> {
	private ArrayList<T> contents;
	private int pointer = 0;

	public InorderTreeIterator(TreeNode<T> node) {
		super();
		contents = new ArrayList<>();
		fill(node);
	}

	/**
	 * Fill the array list recursively. In order.
	 * @param currentNode the currentNode
	 **/
	private void fill(TreeNode<T> currentNode){
		if(currentNode.getLeft() != null) fill(currentNode.getLeft());
		contents.add(currentNode.getValue());
		if(currentNode.getRight() != null) fill(currentNode.getRight());
	}

	@Override
	public boolean hasNext() {
		return pointer <= contents.size() - 1;
	}

	@Override
	public T next() {
		return contents.get(pointer++);
	}
}
