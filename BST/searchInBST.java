package BST;
/*Problem statement
Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, if node with data k is present, return false otherwise.

Note:
Assume that BST contains all unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
true
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
falseProblem statement
Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, if node with data k is present, return false otherwise.

Note:
Assume that BST contains all unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
true
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
false */
public class searchInBST {
    public static boolean a=false;

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if(root==null) {
        return false;
    }
    if(root.data==k) {
        return a=true;
    }
    if(root.data>k) {
        searchInBST(root.left,k);
    }
    else {
        searchInBST(root.right,k);
    }
    
    return a;
    
}

public static void main(String[] args) {
    // Creating a sample BST
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);
    root.left = new BinaryTreeNode<>(3);
    root.right = new BinaryTreeNode<>(10);
    root.left.left = new BinaryTreeNode<>(1);
    root.left.right = new BinaryTreeNode<>(6);
    root.right.right = new BinaryTreeNode<>(14);
    root.right.right.left = new BinaryTreeNode<>(13);

    int keyToSearch = 6;
    boolean isFound = searchInBST(root, keyToSearch);
    System.out.println("Key " + keyToSearch + " found in BST: " + isFound);

    keyToSearch = 5;
    isFound = searchInBST(root, keyToSearch);
    System.out.println("Key " + keyToSearch + " found in BST: " + isFound);
}
}
