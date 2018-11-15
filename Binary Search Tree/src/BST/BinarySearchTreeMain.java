package BST;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
	BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
	bst1.insert(-5);
	bst1.insert(-6);
	bst1.insert(-7);
	bst1.inOrderTraversal();
	System.out.println();

	BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
	bst2.insert(-5);
	bst2.insert(-7);
	bst2.insert(-6);
	bst2.inOrderTraversal();
	System.out.println();


	Integer[] a = {1,5,2,7,4};
	BinarySearchTree<Integer> bst3 = new BinarySearchTree<Integer>();
	for (Integer n : a) {
	    bst3.insert(n);
	}
	bst3.inOrderTraversal();
	System.out.println();
    }
}