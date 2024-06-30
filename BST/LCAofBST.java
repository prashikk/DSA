package BST;
/*Problem statement
Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.

LCA
LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 
Example:
In this example, the green coloured node is the LCA to A and B.
Alt Text

Note:
It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X has a direct connection from Y, then Y is the lowest common ancestor.
Example:
Alt Text

Note:

1. If out of 2 nodes only one node is present, return that node. 
2. If both are not present, return -1.
3. all the node data will be unique.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1 */
public class LCAofBST {
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if(root==null) {
        return -1;
    }
    if(root.data>a && root.data>b) {
        return getLCA(root.left,a,b);
    }
    if(root.data<a && root.data<b) {
        return getLCA(root.right,a,b);
    }
    return root.data;
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

    // Nodes for which LCA is to be found
    int node1 = 2;
    int node2 = 6;

    // Finding LCA of node1 and node2
    int lca = getLCA(root, node1, node2);
    System.out.println("Lowest Common Ancestor of " + node1 + " and " + node2 + " is: " + lca); // Output: 4
}
}
