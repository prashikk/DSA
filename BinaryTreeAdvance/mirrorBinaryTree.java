package BinaryTreeAdvance;
/*Problem statement
For a given Binary Tree of type integer, update it with its corresponding mirror image.

Example:
Alt text

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1 
3 2 
7 6 5 4
Sample Input 2:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 2:
5 
6 10 
3 2 
9 */
public class mirrorBinaryTree {
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
		if(root==null) {
			return;
		}
		BinaryTreeNode<Integer> temp=root.left;
		root.left=root.right;
		root.right=temp;
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
	}
    public static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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

        // Performing pre-order traversal of the original tree
        System.out.print("Original tree (pre-order): ");
        preOrder(root);
        System.out.println();

        // Creating a mirror image of the binary tree
        mirrorBinaryTree(root);

        // Performing pre-order traversal of the mirrored tree
        System.out.print("Mirror tree (pre-order): ");
        preOrder(root);
        System.out.println();
    }
}
