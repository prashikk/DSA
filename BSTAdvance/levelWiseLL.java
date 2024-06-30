package BSTAdvance;
import java.util.*;
/*Problem statement
Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
5 
6 10 
2 3 
9 */

class LinkedListNode<T> 
	 { 
	 		T data; 
	 		LinkedListNode<T> next;
	 		public LinkedListNode(T data) 	
	 		{
	  		this.data = data; 
	  	} 
	   }


public class levelWiseLL {
    private static ArrayList<LinkedListNode<Integer>> arr = new ArrayList<LinkedListNode<Integer>>();

	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		// Write your code here
		     if (root==null)
            return null;
        
        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
        nodesToPrint.add(root);
        nodesToPrint.add(null);
        LinkedListNode<Integer> head = null,tail=null;
        //arr.add(head);
        while(!nodesToPrint.isEmpty())
        {
            BinaryTreeNode<Integer> front=nodesToPrint.poll();
            if (front==null)
            {
                if (nodesToPrint.isEmpty())
                    break;
                else
                {
                    //System.out.println();
                	nodesToPrint.add(null);
                    tail.next=null;
                    tail=tail.next;
                    head=null;
                    
                }
                
            }
            else
            {
                if (head==null)
                {
                    head = new LinkedListNode<Integer>(front.data);
                    tail=head;
                    arr.add(head);
                }
                else
                {
                    tail.next=new LinkedListNode<Integer>(front.data);
                    tail=tail.next;
                }
                //System.out.print(front.data+" ");
                if (front.left!=null)
                    nodesToPrint.add(front.left);
                if (front.right!=null)
                    nodesToPrint.add(front.right);
            }
        }
        return arr;
	}

    public static void main(String[] args) {
        // Constructing the binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(9);

        // Calling the method to get level-wise linked lists
        ArrayList<LinkedListNode<Integer>> result = levelWiseLL.constructLinkedListForEachLevel(root);

        // Printing the result
        System.out.println("Level-wise linked lists:");
        for (LinkedListNode<Integer> head : result) {
            LinkedListNode<Integer> current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
