package LinkedList.Assignments;
/*Problem statement
Given the head of a singly linked list of integers, find and return its length.


Example:
Sample Linked List

The length of the list is 4. Hence we return 4.

Note:
Exercise caution when dealing with edge cases, such as when the head is NULL. Failing to handle these edge cases appropriately may result in a runtime error in your code.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 4 5 2 6 1 9 -1


Sample Output 1 :
7


Explanation of sample input 1 :
The number of nodes in the given linked list is 7.
Hence we return 7.


Sample Input 2 :
10 76 39 -3 2 9 -23 9 -1

Sample Output 2 :
8


Expected Time Complexity:
Try to do this in O(n).


 Constraints :
0 <= N <= 10^5
Time Limit: 1 sec */
public class countNodeOfLinkedList {
    public static int length(LinkedListNode<Integer> head){
		//Your code goes here
		int count=0;
		LinkedListNode<Integer> temp= head;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
	
		return count;
	}
    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);

        // Calculate the length of the linked list
        int length = length(head);
        System.out.println("Length of the linked list: " + length); // Output: 4
    }
}
