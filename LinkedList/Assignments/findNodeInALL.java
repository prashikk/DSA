package LinkedList.Assignments;
/*Problem statement
You have been given a singly linked list of integers. Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.

Note :
Assume that the Indexing for the singly linked list always starts from 0.
Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= T <= 10^2
0 <= M <= 10^5

Where 'M' is the size of the singly linked list.

Time Limit: 1 sec
Sample Input 1 :
2
3 4 5 2 6 1 9 -1
5
10 20 30 40 50 60 70 -1
6
Sample Output 1 :
2
-1
 Explanation for Sample Output 1:
In test case 1, 'N' = 5 appears at position 2 (0-based indexing) in the given linked list.

In test case 2, we can see that 'N' = 6 is not present in the given linked list.
Sample Input 2 :
2
1 -1
2
3 4 5 2 6 1 9 -1
6
Sample Output 2 :
-1
4
 Explanation for Sample Output 2:
In test case 1, we can see that 'N' = 2 is not present in the given linked list.

In test case 2, 'N' = 6 appears at position 4 (0-based indexing) in the given linked list. */
public class findNodeInALL {
    public static int findNode(LinkedListNode<Integer> head, int n) {
		// Write your code here.
		LinkedListNode<Integer> temp=head;
		int count=0;
		while(temp!=null) {
			if(temp.data==n) {
				return count;
			}
			count++;
			temp=temp.next;
		}
		return -1;
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
        
        // Find the position of node with value 3, expected position: 2 (0-indexed)
        int position = findNode(head, 3);
        
        if (position != -1) {
            System.out.println("Node with value 3 found at position: " + position);
        } else {
            System.out.println("Node with value 3 not found in the linked list.");
        }
    }
}
