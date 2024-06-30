package BinaryTreeAdvance;
/*Problem statement
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.

The root will remain the same. So you just need to insert nodes in the given Binary Tree.

Example:
alt txt

After making the changes to the above-depicted tree, the updated tree will look like this.
alt txt

You can see that every node in the input tree has been duplicated and inserted to the left of itself.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
Sample Output 1:
10 
10 30 
20 30 60 
20 50 60 
40 50 
40 
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 2:
8 
8 10 
5 10 
5 6 
2 6 7 
2 7 */
public class createAndInsertDuplicateNode {
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		//Your code goes here
	
	   if (root==null)
            return;

        BinaryTreeNode<Integer> duplicateNode = new BinaryTreeNode<Integer>(root.data);
        //duplicateNode.data=root.data;
        BinaryTreeNode<Integer> temp=root.left;
        root.left=duplicateNode;
        duplicateNode.left=temp;
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
        
		
	}
    public static void printInOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
    public static void main(String[] args) {
        // Example 1
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(1);
        root1.left = new BinaryTreeNode<>(2);
        root1.right = new BinaryTreeNode<>(3);
        root1.left.left = new BinaryTreeNode<>(4);
        root1.left.right = new BinaryTreeNode<>(5);

        System.out.println("Before inserting duplicate nodes:");
        printInOrder(root1);
        System.out.println("\nAfter inserting duplicate nodes:");
        insertDuplicateNode(root1);
        printInOrder(root1);

        // Example 2
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(5);
        root2.left = new BinaryTreeNode<>(3);
        root2.right = new BinaryTreeNode<>(6);
        root2.left.left = new BinaryTreeNode<>(2);
        root2.left.right = new BinaryTreeNode<>(4);
        root2.right.right = new BinaryTreeNode<>(7);

        System.out.println("\n\nBefore inserting duplicate nodes:");
        printInOrder(root2);
        System.out.println("\nAfter inserting duplicate nodes:");
        insertDuplicateNode(root2);
        printInOrder(root2);
    }

}
