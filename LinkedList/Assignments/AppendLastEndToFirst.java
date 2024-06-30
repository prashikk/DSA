package LinkedList.Assignments;
/*Problem statement
You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.

Hint:
Identify how many pointers you require and try traversing them to right places and connect nodes accordingly also don't forget to disconnect what's required else it could create cycles.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
0 <= N < M
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Sample Input 1 :
2
1 2 3 4 5 -1
3
10 20 30 40 50 60 -1
5
Sample Output 1 :
3 4 5 1 2
20 30 40 50 60 10
Sample Input 2 :
1
10 6 77 90 61 67 100 -1
4
Sample Output 2 :
90 61 67 100 10 6 77 
 Explanation to Sample Input 2 :
We have been required to move the last 4 nodes to the front of the list. Here, "90->61->67->100" is the list which represents the last 4 nodes. When we move this list to the front then the remaining part of the initial list which is, "10->6->77" is attached after 100. Hence, the new list formed with an updated head pointing to 90. */
public class AppendLastEndToFirst {
    
	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		//Your code goes here
		if(n==0){
			return head;
		}
		if(head==null){
			return head;
		}
	
        	LinkedListNode<Integer> temp=head;
			int count=0;
			while(temp!=null){
				temp=temp.next;
				count++;
			}
			int newcount=count-n;
			count=0;
			
			//before elements
			LinkedListNode<Integer> temp1=head;
			while(count<newcount-1) {
				temp1=temp1.next;
				count++;
				
			}
			LinkedListNode<Integer> temp2=temp1.next;
			LinkedListNode<Integer> temp3=temp1.next;
			while(temp2.next!=null) {
				temp2=temp2.next;
			}
			temp2.next=head;
			temp1.next=null;
			
			return temp3;
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
        head.next.next.next.next = new LinkedListNode<>(5);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 2 3 4 5
        
        // Append the last 2 nodes to the beginning, resulting in: 4 -> 5 -> 1 -> 2 -> 3 -> null
        head = appendLastNToFirst(head, 2);

        System.out.print("Linked list after appending last 2 nodes to first: ");
        printLinkedList(head); // Output: 4 5 1 2 3
    }
}
