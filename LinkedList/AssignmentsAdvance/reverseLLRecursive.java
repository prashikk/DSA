package LinkedList.AssignmentsAdvance;
/*Problem statement
Given a singly linked list of integers, reverse it using recursion and return the head to the modified list. You have to do this in O(N) time complexity where N is the size of the linked list.

 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
Sample Output 1 :
8 7 6 5 4 3 2 1
Sample Input 2 :
2
10 -1
10 20 30 40 50 -1
Sample Output 2 :
10 
50 40 30 20 10  */
public class reverseLLRecursive {
    
	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
		//Your code goes here
        	if(head==null || head.next==null) {
			return head;
		}
		LinkedListNode<Integer>small=reverseLinkedListRec(head.next);
		LinkedListNode<Integer>tail=small;
		while(tail.next!=null) {
			tail=tail.next;
		}
		tail.next=head;
		head.next=null;
		return small;
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
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 2 3 4
        
        // Reverse the linked list recursively, resulting in: 4 -> 3 -> 2 -> 1 -> null
        head = reverseLinkedListRec(head);

        System.out.print("Reversed linked list: ");
        printLinkedList(head); // Output: 4 3 2 1
    }
    
}
