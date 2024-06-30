package LinkedList.AssignmentsAdvance;
/*Problem statement
Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.

 'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.

Example :
Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= k <= M

Time Limit:  1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 9 10 -1
4


Sample Output 1 :
4 3 2 1 8 7 6 5 10 9
Sample Input 2 :
2
1 2 3 4 5 -1
0
10 20 30 40 -1
4
Sample Output 2 :
1 2 3 4 5 
40 30 20 10  */
public class kReverse {
    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		//Your code goes here
              if(head==null)
            return head;
        if(head.next==null)
            return head;
        if(k==0)
            return head;
        LinkedListNode<Integer> h1=head,h2,t1=head;
        int count=1;
     while(count<k && t1.next!=null)
     {
         t1=t1.next;
         count++;
     }
          
            h2=t1.next;
            t1.next=null;
        

        DoubleNode ans=reversePart(h1);
        LinkedListNode<Integer> secondHead=kReverse(h2,k);
        ans.tail.next=secondHead;
        return ans.head;
	}
       private static DoubleNode reversePart(LinkedListNode<Integer> head)
    {
        if(head==null || head.next==null)
        { DoubleNode ans=new DoubleNode();
        ans.head=head;
        ans.tail=head;
        return ans;}
     
        DoubleNode ans=reversePart(head.next);
        ans.tail.next=head;
        head.next=null;
        ans.tail=ans.tail.next;
        return ans;
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
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);
        head.next.next.next.next.next = new LinkedListNode<>(6);
        head.next.next.next.next.next.next = new LinkedListNode<>(7);
        head.next.next.next.next.next.next.next = new LinkedListNode<>(8);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 2 3 4 5 6 7 8

        // Reverse every k nodes (k = 3 in this example)
        int k = 3;
        head = kReverse(head, k);

        System.out.print("Modified linked list after k-reversing with k = " + k + ": ");
        printLinkedList(head); // Output: 3 2 1 6 5 4 7 8
    }
}
