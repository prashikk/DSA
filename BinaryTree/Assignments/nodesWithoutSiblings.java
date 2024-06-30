package BinaryTree.Assignments;
/*Problem statement
For a given Binary Tree of type integer, print all the nodes without any siblings.

Example Input :
1 4 5 6 -1 -1 7 20 30 80 90 -1 -1 -1 -1 -1 -1 -1 -1
Explanation:
The input tree when represented in a two-dimensional plane, it would look like this:     
alt txt

In respect to the root, node data in the left subtree that satisfy the condition of not having a sibling would be 6, taken in a top-down sequence. Similarly, for the right subtree, 7 is the node data without any sibling.

Since we print the siblings in the left-subtree first and then the siblings from the right subtree, taken in a top-down fashion, we print 6 7.
Example Output:
6 7  
Detailed explanation ( Input/output format, Notes, Images )
 Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 second
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
9     */
public class nodesWithoutSiblings {
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		//Your code goes here
		    if (root==null)
        {
            return; 
        }
        
        if (root.left==null && root.right==null)
        {
            return;
        }
        
        if (root.left==null)
        {
            System.out.print(root.right.data+" ");
            printNodesWithoutSibling(root.right);
        }
        else if (root.right==null)
        {
            System.out.print(root.left.data+" ");
            printNodesWithoutSibling(root.left);
            
        }
        else
        {
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
        }
	
	}
    public static void main(String[] args) {
        // Creating a simple binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.right = new BinaryTreeNode<>(4);
        root.right.left = new BinaryTreeNode<>(5);
        root.right.left.left = new BinaryTreeNode<>(6);

        // Printing nodes without a sibling
        System.out.print("Nodes without sibling: ");
        printNodesWithoutSibling(root);
        System.out.println();
    }
}
