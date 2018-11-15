/* Binary Search Tree (BST) ADT 
 * Reference:  https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
 */
package BST;

import java.util.*;

// we will suppress InsertNode warnings from lint because DataType is resolved at runtime
@SuppressWarnings("unchecked") 
public class BinarySearchTree<DataType extends Comparable<DataType>> {
    private class Node<DataType> {
	private DataType data;
	private Node<DataType> left, right;

	public Node(DataType data, Node<DataType> l, Node<DataType> r) {
	    left = l; 
	    right = r;
	    this.data = data;
	}

	public Node(DataType data) {
	    this(data, null, null);
	}
    } //end of Node

    private Node<DataType> root;
    private Comparator<DataType> comparator;
    
    public BinarySearchTree() {
	root = null;
	comparator = null;
    }

    public BinarySearchTree(Comparator<DataType> comp) {
	root = null;
	comparator = comp;
    }

    private int compare(DataType x, DataType y) {
	if (comparator == null) { 
	    return x.compareTo(y);
	} else {
	    return comparator.compare(x,y);
	}
    }

    public void insert(DataType data) {
	root = insert(root, data);
    }
    private Node<DataType> insert(Node<DataType> p, DataType toInsert) {
	if (p == null) {
	    return new Node<DataType>(toInsert);
	}
	if (compare(toInsert, p.data) == 0) {
	    return p;
	}
	if (compare(toInsert, p.data) < 0) {
	    p.left = insert(p.left, toInsert);
	}
	else {
	    p.right = insert(p.right, toInsert);
	}
	return p;
    }

    public void inOrderTraversal() {
	inOrderHelper(root);
    }
    private void inOrderHelper(Node r) {
	if (r != null) {
	    inOrderHelper(r.left);
	    System.out.print(r.data+" ");
	    inOrderHelper(r.right);
	}
    }
    
    //count the number of leaves in this BST
    public int countLeaves() {
    	return numberOfLeaves;
    }
    
    private int countLeavesPub() {
    	int leaves = 0;
    	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    	
    }
    
}


