package LinkedList.AssignmentsAdvance;
/*Problem statement
You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list. Indexing starts from 1.

To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

Note :
No need to print the list, it has already been taken care. Only return the new head to the list. You can return null in case where all nodes will be deleted.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= P <= 10^5
Where P is the size of the singly linked list.
0 <= M <= 10^5
0 <= N <= 10^5 

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2 :
1 2 6 7
Explanation of Sample Input 2 :
For the first query, we delete one node after every zero elements hence removing all the items of the list. Therefore, nothing got printed.

For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 -> 2 -> 6 -> 7. */
public class deleteEveryNNode {
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		//Your code goes here
               if(head==null)
            return head;
        if(M==0)
            return null;
        if(N==0)
            return head;
        LinkedListNode<Integer> curr=head,t;
        int count;
        while(curr!=null)
        {
        for(count=1;count<M && curr!=null;count++)
        {
            curr=curr.next;
        }
        if(curr==null)
            return head;
        t=curr.next;
        for(count=1;count<=N && t!=null;count++)
        {
            t=t.next;
        }
        curr.next=t;
        curr=t;}
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
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);
        head.next.next.next.next.next = new LinkedListNode<>(6);
        head.next.next.next.next.next.next = new LinkedListNode<>(7);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 2 3 4 5 6 7

        // Skip M nodes and delete N nodes
        int M = 2;
        int N = 3;
        head = skipMdeleteN(head, M, N);

        System.out.print("Modified linked list: ");
        printLinkedList(head); // Output: 1 2 6 7
    }
}
