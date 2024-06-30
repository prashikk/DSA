package LinkedList.AssignmentsAdvance;
/*Problem statement
Given a singly linked list of integers and position 'i', delete the node present at the 'i-th' position in the linked list recursively.

 Note :
Assume that the Indexing for the linked list always starts from 0.

No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M

Time Limit:  2 sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
Sample Input 2 :
2
30 -1
0
10 20 30 50 60 -1
4
Sample Output 2 :
10 20 30 50  */
public class deleteRecursively {
    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
    	//Your code goes here
        	 if(head==null)
	            return head;
	        if(pos==0)
	            return head.next;
	        head.next=deleteNodeRec(head.next,pos-1);
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
        // Example usage:
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 2 3 4 5
        
        // Delete node at position 2 (0-based index), resulting in: 1 -> 2 -> 4 -> 5 -> null
        int posToDelete = 2;
        head = deleteNodeRec(head, posToDelete);

        System.out.print("Linked list after deleting node at position " + posToDelete + ": ");
        printLinkedList(head); // Output: 1 2 4 5
    }
}
