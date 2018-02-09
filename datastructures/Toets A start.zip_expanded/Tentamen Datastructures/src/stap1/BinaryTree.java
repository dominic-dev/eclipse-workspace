package stap1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Generic Binary Search Tree
 **/

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {

	TreeNode<T> root;

	public BinaryTree() {
		super();
		root = null;
	}

	public BinaryTree(ArrayList<T> values) {
		super();
		for (T val: values) {
			insert(val);
		}
	}

	/**
	 * Add a value to the tree.
	 * @param value the value to add.
	 **/
	public void insert(T value) {
		if ( root == null ) {
			root = new TreeNode<T>(value);
		} else {
			TreeNode<T> node = root;
			TreeNode<T> parent = null;
			while ( node != null && node.getValue().compareTo(value) != 0 ) {
				parent = node;
				node = (value.compareTo(node.getValue()) < 0 ? node.getLeft() : node.getRight());
			}
			if ( parent != null && value.compareTo(parent.getValue()) < 0 ) {
				parent.setLeft(new TreeNode<T>(value));
			} else if ( parent != null && value.compareTo(parent.getValue()) > 0 ) {
				parent.setRight(new TreeNode<T>(value));
			}
		}
	}

	/**
	 * Print the tree recursively to std out.
	 * @param node the current node.
	 * @param indent the current indentation level.
	 **/
	private void printTree(TreeNode<T> node, int indent) {
		if ( node != null ) {
			printTree(node.getLeft(), indent+1);
			for (int i=0; i<indent; i++) {
				System.out.print("\t");
			}
			System.out.println(node.getValue());
			printTree(node.getRight(), indent+1);
		} else {
			for (int i=0; i<indent; i++) {
				System.out.print("\t");
			}
			System.out.println("*");
		}
	}

	/**
	 * Print the tree recursively starting at root.
	 **/
	public void printTree() {
		printTree(root, 0);
	}

	@Override
	public Iterator<T> iterator() {
		return new InorderTreeIterator<T>(root);
	}
}
