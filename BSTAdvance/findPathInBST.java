package BSTAdvance;
import java.util.*;
/*Problem statement
Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.

Note: Assume that BST contains all unique elements.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2


Sample Output 1:
2 5 8 */
public class findPathInBST {
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		  if (root==null)
            return null;
        
        ArrayList<Integer> output;
        if (root.data==data)
        {
            output= new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        
        if (data<root.data)
        {
            output = getPath(root.left,data);
            if (output != null)
            {
                output.add(root.data);
            }
            return output;
        }
        
        if (data>root.data)
        {
            output = getPath(root.right,data);
            if (output != null)
            {
                output.add(root.data);
            }
            return output;
        }
        return null;
	}


    public static void main(String[] args) {
        // Sample Binary Search Tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(6);
        root.left.left.left = new BinaryTreeNode<>(1);
        root.right.left = new BinaryTreeNode<>(9);
        root.right.right = new BinaryTreeNode<>(12);

        int dataToFind = 2;
        ArrayList<Integer> path = getPath(root, dataToFind);

        // Printing the path
        if (path != null) {
            System.out.print("Path to node with data " + dataToFind + ": ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Node with data " + dataToFind + " not found in the tree.");
        }
    }
}
