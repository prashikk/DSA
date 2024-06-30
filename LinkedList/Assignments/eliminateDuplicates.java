package LinkedList.Assignments;
/*Problem statement
You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Sample Input 1 :
1
1 2 3 3 3 3 4 4 4 5 5 7 -1
Sample Output 1 :
1 2 3 4 5 7 
Sample Input 2 :
2
10 20 30 40 50 -1
10 10 10 10 -1
Sample Output 2 :
10 20 30 40 50
10 */
public class eliminateDuplicates {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		//Your code goes here
			if(head==null) {
			return head;
		}
		LinkedListNode<Integer> t1= head;
		LinkedListNode<Integer> t2=head.next;
		LinkedListNode<Integer> finalresult =head;
	
		
		
		
		while(t2!=null) {
			if(t1.data.equals(t2.data)) {
				
				t2=t2.next;
				
			}
			else {
				t1.next=t2;
				t1=t2;
			}
			
		}
		t1.next=null;
		return finalresult;
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
        head.next = new LinkedListNode<>(1);
        head.next.next = new LinkedListNode<>(2);
        head.next.next.next = new LinkedListNode<>(3);
        head.next.next.next.next = new LinkedListNode<>(3);

        System.out.print("Original linked list with duplicates: ");
        printLinkedList(head); // Output: 1 1 2 3 3
        
        // Remove duplicates, resulting in: 1 -> 2 -> 3 -> null
        head = removeDuplicates(head);

        System.out.print("Linked list after removing duplicates: ");
        printLinkedList(head); // Output: 1 2 3
    }
}
