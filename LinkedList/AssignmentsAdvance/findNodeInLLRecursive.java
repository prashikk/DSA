package LinkedList.AssignmentsAdvance;
/*Problem statement
Given a singly linked list of integers and an integer n, find and return the index for the first occurrence of 'n' in the linked list. -1 otherwise.

Follow a recursive approach to solve this.

Note :
Assume that the Indexing for the linked list always starts from 0.
Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit:  1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
100
Sample Output 1 :
-1
Sample Input 2 :
2
10 20010 30 400 600 -1
20010
100 200 300 400 9000 -34 -1
-34
Sample Output 2 :
1
5 */
public class findNodeInLLRecursive {
    
	public static int findNodeRec(LinkedListNode<Integer> head, int n) {
    	//Your code goes here
        LinkedListNode<Integer>temp=head;
		int count=0;
		while(temp!=null) {
			if(temp.data.equals(n)) {
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
        // Example usage:
        // Creating a linked list: 1 -> 3 -> 5 -> 7 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(3);
        head.next.next = new LinkedListNode<>(5);
        head.next.next.next = new LinkedListNode<>(7);

        System.out.print("Linked list: ");
        printLinkedList(head); // Output: 1 3 5 7

        // Finding index of node with value 5 using recursive method
        int index = findNodeRec(head, 5);
        if (index != -1) {
            System.out.println("Index of node with value 5: " + index); // Output: 2
        } else {
            System.out.println("Node with value 5 not found.");
        }
    }
}
