package BinaryTree.Assignments;
/*Problem statement
For a given Binary Tree of type integer and a number X, find whether a node exists in the tree with data X or not.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5

Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec.
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
7
Sample Output 1:
true
Explanation For Output 1:
Clearly, we can see that 7 is present in the tree. So, the output will be true.
Sample Input 2:
2 3 4 -1 -1 -1 -1
10
Sample Output 2:
false */
public class isNodePresent {
    public static boolean a=false;

	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
		if(root==null) {
			return false;
		}
		if(root.data==x) {
			return a=true;
		}
		isNodePresent(root.left,x);
		isNodePresent(root.right,x);
		return a;
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

        // Checking if node with value 5 is present in the tree
        int x = 5;
        boolean isPresent = isNodePresent(root, x);
        System.out.println("Is node " + x + " present in the tree? " + isPresent);

        // Checking if node with value 8 is present in the tree
        x = 8;
        isPresent = isNodePresent(root, x);
        System.out.println("Is node " + x + " present in the tree? " + isPresent);
    }
    
}
