package BinaryTreeAdvance;
/*Problem statement
For a given Binary of type integer, find and return the ‘Diameter’.

Diameter of a Tree
The diameter of a tree can be defined as the maximum distance between two leaf nodes.
Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.
Example:
alt txt

The maximum distance can be seen between the leaf nodes 8 and 9. 
The distance is 9 as there are a total of nine nodes along the longest path from 8 to 9(inclusive of both). Hence the diameter according to the definition will be 9.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 8 -1 -1 9 -1 -1 -1 -1 -1 -1 
Sample Output 1:
9
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
5 */
public class diameterOfBinaryTree {
    public static int findHeight(BinaryTreeNode<Integer> root)
    {
        if (root==null)
        {
            return 0;
        }
        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);
        
        if(leftHeight>rightHeight)
        {
            return leftHeight+1;
        }
        else
        {
            return rightHeight+1;
        }
    }

	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
		 if (root==null)
        {
            return 0;
        }
        return findHeight(root.left)+findHeight(root.right)+1;
	}
    public static void main(String[] args) {
        // Creating a binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);
        root.left.left.left = new BinaryTreeNode<>(8);
        root.left.left.right = new BinaryTreeNode<>(9);

        // Finding the diameter of the binary tree
        int diameter = diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);
    }
}
