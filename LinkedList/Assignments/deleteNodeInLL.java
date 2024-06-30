package LinkedList.Assignments;
/*Problem statement
You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'POS'.

Note :
Assume that the Indexing for the linked list always starts from 0.

If the position is greater than or equal to the length of the linked list, you should return the same linked list without any change.
Illustration :
The following images depict how the deletion has been performed.
Image-I :

Alt txt

Image-II :

Alt txt

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
Explanation of Sample Output 1 :
The data in the node with index 3 is 2 which has been removed.
Sample Input 2 :
3 4 5 2 6 1 9 -1
0
Sample Output 2 :
4 5 2 6 1 9
Constraints :
0 <= N <= 10^5
POS >= 0

Time Limit: 1sec
Expected Complexity :
Time Complexity  : O(N)
Space Complexity  : O(1) */
public class deleteNodeInLL {
    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
		// Write your code here.
	 if(head==null )
            return head;
        if(pos==0)
            return head.next;
        int count=0;
        LinkedListNode<Integer> temp=head;
        while(temp!=null && count<pos-1)
        {
            temp=temp.next;
            count++;
        }
        if(temp==null)
            return head;
        if(temp.next!=null)
            temp.next=temp.next.next;
         
        
        return head;
    }
    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 2 3 4
        
        // Deleting node at position 1 (0-indexed), resulting in: 1 -> 3 -> 4 -> null
        head = deleteNode(head, 1);

        System.out.print("Linked list after deletion: ");
        printLinkedList(head); // Output: 1 3 4
    }
}
