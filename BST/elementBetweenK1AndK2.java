package BST;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/*Problem statement
Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).

Print the elements in increasing order.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output 1:
6 7 8 10 */
public class elementBetweenK1AndK2 {
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        List<Integer> result = new ArrayList<Integer>();
        inOrderTraversal(root, k1, k2, result);
        
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    private static void inOrderTraversal(BinaryTreeNode<Integer> root, int k1, int k2, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        // Traverse left subtree if root's data is greater than k1
        if (root.data > k1) {
            inOrderTraversal(root.left, k1, k2, result);
        }
        
        // Add root's data to result if it lies in the range [k1, k2]
        if (root.data >= k1 && root.data <= k2) {
            result.add(root.data);
        }
        
        // Traverse right subtree if root's data is less than k2
        if (root.data < k2) {
            inOrderTraversal(root.right, k1, k2, result);
        }
    }
    
    public static void main(String[] args) {
        // Sample input: Constructing the Binary Search Tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(6);
        root.left.right.right = new BinaryTreeNode<>(7);

        int k1 = 6, k2 = 10;
        elementsInRangeK1K2(root, k1, k2); // Output: 6 7 8 10
    }
}
