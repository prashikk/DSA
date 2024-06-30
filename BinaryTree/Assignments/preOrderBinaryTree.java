package BinaryTree.Assignments;
/*Problem statement
You are given a ‘Binary Tree’.



Return the preorder traversal of the Binary Tree.



Example:
Input: Consider the following Binary Tree:
Example

Output: 
Following is the preorder traversal of the given Binary Tree: [1, 2, 5, 3, 6, 4]


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
1 2 3 5 4 6 7 -1 -1 -1 -1 -1 -1 -1 -1


 Sample Output 1:
1 2 5 4 3 6 7


Explanation of Sample Input 1:
The Binary Tree given in the input is as follows:
Sample1

Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1


 Sample Output 2:
5 6 2 3 9 10


Explanation of Sample Input 2:
The Binary Tree given in the input is as follows:
Sample2

Expected Time Complexity:
Try to do this in O(n).


Constraints:
1 <= n <= 100000
where 'n' is the number of nodes in the binary tree.

Time Limit: 1 sec */
public class preOrderBinaryTree {
    
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
          // Creating a simple binary tree
          BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
          root.left = new BinaryTreeNode<>(2);
          root.right = new BinaryTreeNode<>(3);
          root.left.left = new BinaryTreeNode<>(4);
          root.left.right = new BinaryTreeNode<>(5);
          root.right.left = new BinaryTreeNode<>(6);
          root.right.right = new BinaryTreeNode<>(7);
  
          // Performing pre-order traversal
          System.out.print("Pre-order traversal: ");
          preOrder(root);
  
    }
}
