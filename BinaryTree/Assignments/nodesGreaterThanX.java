package BinaryTree.Assignments;
/*Problem statement
For a given a binary tree of integers and an integer X, find and return the total number of nodes of the given binary tree which are having data greater than X.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 4 2 3 -1 -1 -1
2
Sample Output 1:
2
Explanation for Sample Input 1:
Out of the four nodes of the given binary tree, [3, 4] are the node data that are greater than X = 2.
Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
5
Sample Output 2:
3 */
public class nodesGreaterThanX {
    public static int count=0;

	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here
		if(root==null) {
			return-1;
		}
		
		if(root.data>x) {
			count++;
		}
		countNodesGreaterThanX(root.left,x);
		countNodesGreaterThanX(root.right,x);
		return count;
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
 
         // Counting nodes greater than a given value x
         int x = 4;
         int count = countNodesGreaterThanX(root, x);
         System.out.println("Number of nodes greater than " + x + ": " + count);
    }
}
