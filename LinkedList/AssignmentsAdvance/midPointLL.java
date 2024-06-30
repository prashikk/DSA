package LinkedList.AssignmentsAdvance;
/*Problem statement
For a given singly linked list of integers, find and return the node present at the middle of the list.

Note :
If the length of the singly linked list is even, then return the first middle node.

Example: Consider, 10 -> 20 -> 30 -> 40 is the given list, then the nodes present at the middle with respective data values are, 20 and 30. We return the first node with data 20.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5 
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
3
Sample Input 2 :
2 
-1
1 2 3 4 -1
Sample Output 2 :
2 */
public class midPointLL {
     
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
        //Your code goes here
        if(head==null){
            return head;
        }
        LinkedListNode<Integer>fast=head;
		LinkedListNode<Integer>slow=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		
		return slow;
		
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
        
        // Finding midpoint of the linked list, expecting node with data 3 (1-based)
        LinkedListNode<Integer> midNode = midPoint(head);
        System.out.println("Midpoint of the linked list: " + midNode.data); // Output: 3
    }

}
