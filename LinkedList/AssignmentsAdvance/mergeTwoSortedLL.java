package LinkedList.AssignmentsAdvance;
/*Problem statement
You have been given two sorted(in ascending order) singly linked lists of integers.

Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.

Note :
Try solving this in O(1) auxiliary space.

No need to print the list, it has already been taken care.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t = 10^2
0 <= N <= 10 ^ 4
0 <= M <= 10 ^ 4
Where N and M denote the sizes of the singly linked lists. 

Time Limit: 1sec
Sample Input 1 :
1
2 5 8 12 -1
3 6 9 -1
Sample Output 1 :
2 3 5 6 8 9 12 
Sample Input 2 :
2
2 5 8 12 -1
3 6 9 -1
10 40 60 60 80 -1
10 20 30 40 50 60 90 100 -1
Sample Output 2 :
2 3 5 6 8 9 12 
10 10 20 30 40 40 50 60 60 60 80 90 100 */
public class mergeTwoSortedLL {
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here
        if(head1==null) {
			return head2;
		}
		if(head2==null) {
			return head1;
		}
		LinkedListNode<Integer>t1=head1;
		LinkedListNode<Integer>t2=head2;
		LinkedListNode<Integer> head=null,tail=null;
		
		if(t1.data<=t2.data) {
			head=t1;
			tail=t2;
			t1=t1.next;
		}
		else {
			head=t2;
			tail=t2;
			t2=t2.next;
		}
		
		while(t1!=null && t2!=null) {
			if(t1.data<=t2.data) {
				tail.next=t1;
				tail=t1;
				t1=t1.next;
			}
			else {
				tail.next=t2;
				tail=t2;
				t2=t2.next;
			}
		}
		 if(t1!= null){
		        tail.next= t1;
		      }else{
		        tail.next=t2;
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
        // Example usage:
        // Creating two sorted linked lists: 1 -> 3 -> 5 -> null and 2 -> 4 -> 6 -> null
        LinkedListNode<Integer> head1 = new LinkedListNode<>(1);
        head1.next = new LinkedListNode<>(3);
        head1.next.next = new LinkedListNode<>(5);

        LinkedListNode<Integer> head2 = new LinkedListNode<>(2);
        head2.next = new LinkedListNode<>(4);
        head2.next.next = new LinkedListNode<>(6);

        System.out.print("First sorted linked list: ");
        printLinkedList(head1); // Output: 1 3 5

        System.out.print("Second sorted linked list: ");
        printLinkedList(head2); // Output: 2 4 6

        // Merge the two sorted lists
        LinkedListNode<Integer> mergedHead = mergeTwoSortedLinkedLists(head1, head2);

        System.out.print("Merged sorted linked list: ");
        printLinkedList(mergedHead); // Output: 1 2 3 4 5 6
    }
}
