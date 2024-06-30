package LinkedList.AssignmentsAdvance;
/*Problem statement
 Given a singly linked list of integers, sort it using 'Merge Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Input 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90  */
public class mergeSort {
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		//Your code goes here
                if(head==null)
            return head;
        if(head.next==null)
            return head;
        LinkedListNode<Integer> midNode=findmid(head);
        LinkedListNode<Integer> h2=midNode.next;
        midNode.next=null;
        LinkedListNode<Integer> part1=mergeSort(head);
        LinkedListNode<Integer> part2=mergeSort(h2);
        LinkedListNode<Integer> mergedList=mergeTwoList(part1,part2);
        return mergedList;
	}
      private static LinkedListNode<Integer> findmid(LinkedListNode<Integer> head) 
    {
        if(head==null)
            return head;
        LinkedListNode<Integer> slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
       public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        LinkedListNode<Integer> t1=head1,t2=head2,tail=null,head=null;
        if(t1.data<=t2.data)
        {
            head=t1;
            tail=t1;
            t1=t1.next;
        }
        else
        {
            head=t2;
            tail=t2;
            t2=t2.next;
        }
        while(t1!=null &&t2!=null)
        {
            if(t1.data<=t2.data)
            {
                tail.next=t1;
                tail=t1;
                t1=t1.next;
            }
            else
            {
                tail.next=t2;
                tail=tail.next;
                t2=t2.next;
            }
        }
        if(t1==null)
            tail.next=t2;
        if(t2==null)
            tail.next=t1;
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
        // Creating a linked list: 3 -> 1 -> 7 -> 5 -> 2 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(3);
        head.next = new LinkedListNode<>(1);
        head.next.next = new LinkedListNode<>(7);
        head.next.next.next = new LinkedListNode<>(5);
        head.next.next.next.next = new LinkedListNode<>(2);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 3 1 7 5 2

        // Sort the linked list using merge sort
        head = mergeSort(head);

        System.out.print("Sorted linked list: ");
        printLinkedList(head); // Output: 1 2 3 5 7
    }
}
