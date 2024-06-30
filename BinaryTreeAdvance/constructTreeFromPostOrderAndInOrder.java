package BinaryTreeAdvance;

import java.util.LinkedList;
import java.util.Queue;

/*Problem statement
For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements. 
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^3
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
1 2 4 5 3 6 7 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
5 6 2 3 9 10 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9  */
public class constructTreeFromPostOrderAndInOrder {
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder,int siPost, int eiPost, int siIn, int eiIn) {
    	
    	//Base case - If number of elements in the post-order is 0
    	if (siPost>eiPost)
    	{
    		return null;
    	}
    	
    	//Defining the root node for current recursion
    	int rootData=postOrder[eiPost];
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
    	
    	//Finding root data's location in Inorder (Assuming root data exists in Inorder)
    	int rootIndex=-1;
    	for (int i=siIn;i<=eiIn;i++)
    	{
    		if (rootData==inOrder[i])
    		{
                rootIndex=i;
    			break;
    		}
    	}
    	    	
    	//Defining index limits for Left Subtree Inorder
    	int siInLeft=siIn;
    	int eiInLeft=rootIndex-1;
    	
    	//Defining the index limits for Left Subtree Preorder
    	int siPostLeft=siPost;
    	int leftSubTreeLength = eiInLeft - siInLeft + 1;
    	int eiPostLeft=(siPostLeft)+(leftSubTreeLength-1);
    	
    	//Defining index limits for Right Subtree Inorder
    	int siInRight=rootIndex+1;
    	int eiInRight=eiIn;
    	
    	//Defining index limits for Right Subtree Preorder
    	int siPostRight=eiPostLeft+1;
    	int eiPostRight=eiPost-1;
    	
        BinaryTreeNode<Integer> rightChild = buildTree(postOrder, inOrder, siPostRight, eiPostRight, siInRight, eiInRight);
    	BinaryTreeNode<Integer> leftChild = buildTree(postOrder, inOrder, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
    	
    	root.left=leftChild;
    	root.right=rightChild;
    	return root;
	}

	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		//Your code goes here
			  BinaryTreeNode<Integer> root = buildTree(postOrder, inOrder, 0 ,postOrder.length-1, 0, inOrder.length-1);
    	return root;
	}
  
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        
        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);
        
        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();
            System.out.print(front.data + " ");
            
            if (front.left != null) {
                nodesToPrint.add(front.left);
            }
            if (front.right != null) {
                nodesToPrint.add(front.right);
            }
        }
    }
    public static void main(String[] args) {
        int[] postOrder1 = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder1 = {4, 2, 5, 1, 6, 3, 7};
        
        System.out.println("Example 1:");
        BinaryTreeNode<Integer> root1 = buildTree(postOrder1, inOrder1);
        printLevelWise(root1);
        
        // Example 2
        int[] postOrder2 = {5, 6, 2, 3, 9, 10};
        int[] inOrder2 = {2, 6, 3, 9, 5, 10};
        
        System.out.println("\nExample 2:");
        BinaryTreeNode<Integer> root2 = buildTree(postOrder2, inOrder2);
        printLevelWise(root2);
    }
}
