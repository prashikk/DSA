package BSTAdvance;
/*Problem statement
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.

Note :
The binary tree will be consisting of only unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ Data of a node ≤ 10^6
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1


Sample Output 1:
2 */
public class largestBST {


    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		// Write your code here
		 if (root==null)
            return 0;
        
        if (isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
            return findHeight(root);
        else
        {
        	return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
        }
            
	}
	   private static int findHeight(BinaryTreeNode<Integer> root)
    {
        if (root==null)
            return 0;
        
        if (root.left==null && root.right==null)
            return 1;
        
        return Math.max(findHeight(root.left),findHeight(root.right))+1;
    }
    
    private static boolean isBST(BinaryTreeNode<Integer> root, int min, int max)
    {
        if(root == null)
			return true;
		
        if(root.data < min || root.data > max)
			return false;
		else
			return isBST(root.left,min,root.data -1) && isBST(root.right,root.data +1,max);
    }
    public static void main(String[] args) {
        // Creating the binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(50);
        root.left = new BinaryTreeNode<>(30);
        root.right = new BinaryTreeNode<>(60);
        root.left.left = new BinaryTreeNode<>(5);
        root.left.right = new BinaryTreeNode<>(20);
        root.right.left = new BinaryTreeNode<>(45);
        root.right.right = new BinaryTreeNode<>(70);
        root.right.right.left = new BinaryTreeNode<>(65);
        root.right.right.right = new BinaryTreeNode<>(80);

        // Calling the largestBSTSubtree method
        int largestSize = largestBSTSubtree(root);

        // Printing the result
        System.out.println("Size of the largest BST subtree: " + largestSize);
    }
}
