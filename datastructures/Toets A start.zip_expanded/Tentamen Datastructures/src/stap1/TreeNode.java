package stap1;

/**
 * Generic Binary Search Tree node. 
 **/

public class TreeNode<T extends Comparable<T>> {

	private T value;
	private TreeNode<T> left;
	private TreeNode<T> right;

	public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public TreeNode(T value) {
		this(value, null, null);
	}

	/**
	 * @return the value
	 **/
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set.
	 **/
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * @return the left node
	 **/
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left the value to set.
	 **/
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right node
	 **/
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 * @param right the value to set.
	 **/
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
}
