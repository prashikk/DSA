package BSTAdvance;
import java.util.*;
/*Problem statement
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).

Note:
1. Assume BST contains all unique elements.
2. In a pair, print the smaller element first.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 1:
2 10
5 7 */
public class pairSumInABST {
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		// Write your code here
		   if (root==null)
            return;
        else
        {
            ArrayList<Integer> arr = convertToArray(root);
        	Collections.sort(arr);
            //for (int i=0;i<arr.size();i++)
            //{
            //    System.out.print (arr.get(i)+" ");
            //}
            //System.out.println();
        	printPairSum(arr,s);
        }
	}
		    
    private static ArrayList<Integer> convertToArray(BinaryTreeNode<Integer> root)
    {
        if (root==null)
        {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            return arr;
        }
        
        
        ArrayList<Integer> currArr = new ArrayList<Integer>();
        ArrayList<Integer> leftArr = convertToArray(root.left);
        if (!leftArr.isEmpty())
        {
            currArr.addAll(leftArr);
        }
        
        currArr.add(root.data);
        
        ArrayList<Integer> rightArr = convertToArray(root.right);
        if (!rightArr.isEmpty())
        {
            currArr.addAll(rightArr);
        }
        return currArr;
    }
    
    private static void printPairSum(ArrayList<Integer> arr, int s)
    {
        int i=0,j=arr.size()-1;
        while(i<j)
        {
            int val1=arr.get(i);
            int val2=arr.get(j);
            if (val1+val2>s)
            {
                j=j-1;
            }
            else if(val1+val2<s)
            {
                i=i+1;
            }
            else
            {
                System.out.println(val1+" "+val2);
                i=i+1;
                j=j-1;
            }
                
        }
	}
    public static void main(String[] args) {
        // Constructing the Binary Search Tree (BST)
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        // Calling the printNodesSumToS method
        int S = 12;
        System.out.println("Pairs of nodes that sum to " + S + ":");
        pairSumInABST.printNodesSumToS(root, S);
    }

}
