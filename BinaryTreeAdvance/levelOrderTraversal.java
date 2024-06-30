package BinaryTreeAdvance;

import java.util.LinkedList;
import java.util.Queue;

/*Problem statement
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.

Example:
alt txt

For the above-depicted tree, when printed in a level order fashion, the output would look like:

10
20 30 
40 50 60
Where each new line denotes the level in the tree.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
Sample Output 1:
10 
20 30 
40 50 60 
Sample Input 2:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
8 
3 10 
1 6 14 
4 7 13  */
public class levelOrderTraversal {
    private static final levelOrderTraversal Solution = null;
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
	    if (root==null)
            return;
        
        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
        nodesToPrint.add(root);
        nodesToPrint.add(null);
        while(!nodesToPrint.isEmpty())
        {
            BinaryTreeNode<Integer> front=nodesToPrint.poll();
            if (front==null)
            {
                if (nodesToPrint.isEmpty())
                    break;
                else
                {
                    System.out.println();
                	nodesToPrint.add(null);
                }
                
            }
            else
            {
                System.out.print(front.data+" ");
                if (front.left!=null)
                    nodesToPrint.add(front.left);
                if (front.right!=null)
                    nodesToPrint.add(front.right);
            }
        }
	}
    public static void main(String[] args) {
        // Creating a sample binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        // Calling the function to print level wise
        Solution.printLevelWise(root);
    }
}
