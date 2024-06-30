package LinkedList.AssignmentsAdvance;
/*Problem statement
You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions and return the new head to the list.

Note :
1. Remember, You need to swap the nodes, not only the data.
2. Indexing starts from 0.
3. No need to print the list, it has already been taken care.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M
0 <= j < M

Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 4
Sample Output 1 :
3 4 5 6 2 1 9 
 Sample Input 2 :
2
10 20 30 40 -1
1 2
70 80 90 25 65 85 90 -1
0 6
 Sample Output 2 :
10 30 20 40 
90 80 90 25 65 85 70  */

public class SwapTwoNodeOfLL {
    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		//Your code goes here
         LinkedListNode<Integer> temp=head,prev=null,c1=null,c2=null,p1=null,p2=null;
        int pos=0;
        while(temp!=null)
        {
            if(pos==i)
            {
                p1=prev;
                c1=temp;
            }
else if(pos==j)
{
    p2=prev;
    c2=temp;
}
            prev=temp;
            temp=temp.next;
            pos++;
        }
        if(p1!=null)
        {
            p1.next=c2;
        }
        else{
            head=c2;
        }
        if(p2!=null){
            p2.next=c1;
        }
        else{
            head=c1;
        }
        LinkedListNode<Integer> temp1=c2.next;
        c2.next=c1.next;
        c1.next=temp1;
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
        // Creating a linked list: 3 -> 4 -> 5 -> 2 -> 6 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(3);
        head.next = new LinkedListNode<>(4);
        head.next.next = new LinkedListNode<>(5);
        head.next.next.next = new LinkedListNode<>(2);
        head.next.next.next.next = new LinkedListNode<>(6);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 3 4 5 2 6

        // Swapping nodes at positions 1 and 3 (0-based indexing)
        int i = 1;
        int j = 3;
        head = swapNodes(head, i, j);

        System.out.print("Modified linked list after swapping nodes at positions " + i + " and " + j + ": ");
        printLinkedList(head); // Output: 3 2 5 4 6
    }
}
