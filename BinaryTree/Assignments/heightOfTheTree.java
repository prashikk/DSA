package BinaryTree.Assignments;
/*Problem statement
For a given Binary Tree of integers, find and return the height of the tree. Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.

Example:
ALTIMAGE

Height of the given tree is 3. 
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 -1 -1 -1 -1 -1
Sample Output 1:
3
Sample Input 2:
3 -1 -1
Sample Output 2:
1 */
public class heightOfTheTree {
    public static int height(BinaryTreeNode<Integer> root) {
		//Your code goes here
			if(root==null) {
			return 0;
		}
		
		int so=height(root.left);
		int so1=height(root.right);
		if(so>so1) {
			return so+1;
		}
		else {
			return so1+1;
		}
		
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
        root.right.left.left = new BinaryTreeNode<>(8);

        // Calculating and printing the height of the binary tree
        int treeHeight = height(root);
        System.out.println("Height of the binary tree: " + treeHeight);
    }
}
