package BinaryTree.Assignments;

public class sumOfNodes {
    public static int getSum(BinaryTreeNode<Integer> root) {
		//Your code goes here.
		if(root==null) {
			return 0;
		}
		
		int smalloutput=getSum(root.left);
		int smalloutput1=getSum(root.right);
		return root.data+smalloutput+smalloutput1;
	}
    public static void main(String[] args) {
        // Creating a simple binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        // Calculating and printing the sum of all nodes
        int sum = getSum(root);
        System.out.println("Sum of all nodes: " + sum);
    }
}
