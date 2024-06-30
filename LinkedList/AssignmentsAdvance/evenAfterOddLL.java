package LinkedList.AssignmentsAdvance;
/*Problem statement
For a given singly linked list of integers, arrange the nodes such that all the even number nodes are placed after the all odd number nodes. The relative order of the odd and even terms should remain unchanged.

Note :
1. No need to print the linked list, it has already been taken care. Only return the new head to the list.
2. Don't create a new linked list.
3.  Just change the data, instead rearrange the provided list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 4 5 2 -1
Sample Output 1 :
1 5 4 2 
Sample Input 2 :
2
1 11 3 6 8 0 9 -1
10 20 30 40 -1
Sample Output 2 :
1 11 3 9 6 8 0
10 20 30 40 */
public class evenAfterOddLL {
    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {

        if(head==null){
            return head;
        }
		//Your code goes here
           LinkedListNode<Integer> eh=null,et=null,oh=null,ot=null;
        while(head!=null){
            if(head.data%2==0){
                if(eh==null && et==null)
                {
                    eh=head;
                    et=head;

                }
                else{
                    et.next=head;
                    et=head;

                }
                head=head.next;
            }
            else{
                if(oh==null && ot==null)
                {
                    oh=head;
                    ot=head;
                }
                else{
                    ot.next=head;
                    ot=head;
                }
                head=head.next;
            }
        }
        if(oh!=null){
            ot.next=eh;
        }
        else{
            return eh;
        }
        if(eh!=null){
            et.next=null;
        }
        return oh;
    
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
        // Creating a linked list: 1 -> 4 -> 3 -> 2 -> 5 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(4);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(2);
        head.next.next.next.next = new LinkedListNode<>(5);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 1 4 3 2 5

        // Rearrange the linked list so that all odd numbers appear before even numbers
        head = evenAfterOdd(head);

        System.out.print("Rearranged linked list: ");
        printLinkedList(head); // Output: 1 3 5 4 2
    }
}
