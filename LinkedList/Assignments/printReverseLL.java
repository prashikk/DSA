package LinkedList.Assignments;
/*Problem statement
You have been given a singly linked list of integers. Write a function to print the list in a reverse order.

To explain it further, you need to start printing the data from the tail and move towards the head of the list, printing the head data at the end.

Note :
You can’t change any of the pointers in the linked list, just print the linked list in the reverse order.
Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^3


Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
5 4 3 2 1
Sample Input 2 :
2
1 2 3 -1
10 20 30 40 50 -1
Sample Output 2 :
3 2 1
50 40 30 20 10 */
public class printReverseLL {
    public static void printReverse(LinkedListNode<Integer> root) {
		//Your code goes here
		if(root==null) {
			return;
		}
		printReverse(root.next);
		System.out.print(root.data+" ");
	}
    public static void main(String[] args) {
        // Example usage:
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 2 3 4
        
        System.out.print("Reversed linked list: ");
        printReverse(head); // Output: 4 3 2 1
    }

    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
