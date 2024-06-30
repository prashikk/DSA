package LinkedList.Assignments;
/*Problem statement
For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.

 Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
i  >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
2
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0
9 8 4 0 7 8 -1
3
Sample Output 2 :
3
0 */
public class printithNode {
    public static void printIthNode(LinkedListNode<Integer> head, int i){
		//Your code goes here
			LinkedListNode<Integer> temp= head;
		int count =0;
		while(temp!=null) {
			if(count==i) {
				System.out.print(temp.data+" ");
			}
			temp=temp.next;
			count++;
		}
	}
    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        printIthNode(head, 2);
    }
}
