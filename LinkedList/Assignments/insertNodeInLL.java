package LinkedList.Assignments;
/*Problem statement
You have been given a singly linked list of integers, an integer value called 'data' and a position with the name 'pos.'

 Write a function to add a node to the list with the 'data' at the specified position, 'pos.'

Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the position is greater than the length of the singly linked list, you should return the same linked list without any change.
 Illustration :
The following images depict how the insertion has been taken place.
Image-I :

Alt txt

Image-II :

Alt txt

Image-III :

Alt txt

Image-IV :

Alt txt

Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
pos >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 100
Sample Output 1 :
3 4 5 100 2 6 1 9
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0 20
10 98 7 66 8 -1
5 99
Sample Output 2 :
20 3 4 5 2 6 1 9
10 98 7 66 8 99 */
public class insertNodeInLL {
    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data){
		//Your code goes here
		LinkedListNode<Integer>temp = head;
		LinkedListNode<Integer> d = new LinkedListNode<Integer>(data);
		int count=0;
		if(pos==0) {
			d.next=head;
			head=d;
		}
		else {
		while(count<pos-1 && temp!=null) {
			count++;
			temp=temp.next;
		}
		if(temp!=null) {

			d.next=temp.next;
			temp.next=d;
			
		}
		}
		
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

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 2 3
        
        // Inserting 4 at position 1 (0-indexed), resulting in: 1 -> 4 -> 2 -> 3 -> null
        head = insert(head, 1, 4);

        System.out.print("Linked list after insertion: ");
        printLinkedList(head); // Output: 1 4 2 3

    }
}
