package BinaryTreeAdvance;
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
public class constructTreeFromPreOrderAndInOrder {
    public static BinaryTreeNode<Integer> buildTree(int[] preorder, int[] inorder,int siPre, int eiPre, int siIn, int eiIn)
    {
        //Base case - If number of elements in the pre-order is 0
    	if (siPre>eiPre)
    	{
    		return null;
    	}
    	
    	//Defining the root node for current recursion
    	int rootData=preorder[siPre];
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
    	
    	//Finding root data's location in Inorder (Assuming root data exists in Inorder)
    	int rootIndexInorder=-1;
    	for (int i=siIn;i<=eiIn;i++)
    	{
    		if (rootData==inorder[i])
    		{
    			rootIndexInorder=i;
    			break;
    		}
    	}
    	    	
    	//Defining index limits for Left Subtree Inorder
    	int siInLeft=siIn;
    	int eiInLeft=rootIndexInorder-1;
    	
    	//Defining the index limits for Left Subtree Preorder
    	int siPreLeft=siPre+1;
    	int leftSubTreeLength = eiInLeft - siInLeft + 1;
    	int eiPreLeft=(siPreLeft)+(leftSubTreeLength-1);
    	
    	//Defining index limits for Right Subtree Inorder
    	int siInRight=rootIndexInorder+1;
    	int eiInRight=eiIn;
    	
    	//Defining index limits for Right Subtree Preorder
    	int siPreRight=eiPreLeft+1;
    	int eiPreRight=eiPre;
    	
    	BinaryTreeNode<Integer> leftChild = buildTree(preorder, inorder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
    	BinaryTreeNode<Integer> rightChild = buildTree(preorder, inorder, siPreRight, eiPreRight, siInRight, eiInRight);
    	root.left=leftChild;
    	root.right=rightChild;
    	return root;
    }

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
		BinaryTreeNode<Integer> root = buildTree(preOrder, inOrder, 0 ,preOrder.length-1, 0, inOrder.length-1);
    	return root;
		
	}
    public static void inorderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        // Example: Given preorder and inorder traversal sequences
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};

        // Build the binary tree from the given traversal sequences
        BinaryTreeNode<Integer> root = buildTree(preorder, inorder);

        // Print inorder traversal of the constructed binary tree to verify
        System.out.print("Inorder traversal of the constructed tree: ");
        inorderTraversal(root);
        System.out.println();
    }
}
