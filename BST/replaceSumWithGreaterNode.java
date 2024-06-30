package BST;
/*Problem statement
Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. You need to include the current node's data also.

That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.

Note: You don't need to return or print, just change the data of each node.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18 
36 10 
38 31 
25  */
public class replaceSumWithGreaterNode {
    public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum)
    {
        //Base Case
        if(root == null)
			return sum;
        
		//Recursive Case
		sum = replaceWithLargerNodesSum(root.right,sum);
		sum += root.data;
		root.data = sum;
		return replaceWithLargerNodesSum(root.left,sum);
    }
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
        replaceWithLargerNodesSum(root,0);
	}

    public static void main(String[] args) {
        // Sample Binary Search Tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(6);
        root.left.left = new BinaryTreeNode<>(1);
        root.left.right = new BinaryTreeNode<>(3);
        root.right.left = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(7);

        // Replace nodes with the sum of all greater nodes
        replaceWithLargerNodesSum(root);

        // Printing the modified BST
        System.out.println("BST after replacing nodes with larger nodes sum:");
        printInOrder(root); // Output: 21 20 18 15 11 7
    }

    public static void printInOrder(BinaryTreeNode<Integer> root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }
}
