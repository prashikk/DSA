package BinaryTree.Assignments;
/*Problem statement
For a given a Binary Tree of integers, replace each of its data with the depth of the tree.

Root is at depth 0, hence the root data is updated with 0. Replicate the same further going down the in the depth of the given tree.

The modified tree will be printed in the in-order fashion.

Example:
Alt text

The above tree after updating will look like this:
Alt text

Output: 2 1 2 0 2 1 2 (printed in the in-order fashion)
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1sec
 Sample Input 1:
2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1 
Sample Output 1:
2 1 2 0 2 1 2 
 Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
2 1 2 0 2 1 2  */
public class replaceNodeWithDepth {
    public static void replace(BinaryTreeNode<Integer>root,int depth) {
		if(root==null) {
			return;
		}
		root.data=depth;
		replace(root.left,depth+1);
		replace(root.right,depth+1);
	}

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
		replace(root,0);
	}
    public static void preOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
			if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
	
	//	System.out.println();
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
  
  
          // Converting the binary tree to a depth tree
          changeToDepthTree(root);
  
          // Performing pre-order traversal of the depth tree
          System.out.print("Depth tree (pre-order): ");
          preOrder(root);
          System.out.println();
    }
}
