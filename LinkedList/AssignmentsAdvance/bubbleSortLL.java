package LinkedList.AssignmentsAdvance;
/*Problem statement
Given a singly linked list of integers, sort it using 'Bubble Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10^3
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Input 2 :
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90  */
public class bubbleSortLL {
    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		//Your code goes here
		    if(head==null || head.next==null)
        return head;
        
        for(int i=0;i<lengthLL(head)-1;i++){
            LinkedListNode<Integer> prev = null;
            LinkedListNode<Integer> curr = head;
            LinkedListNode<Integer> next = curr.next;

            while(curr.next != null){
                if(curr.data > curr.next.data){
                    if(prev == null){
                        curr.next = next.next;
                        next.next = curr;
                        prev = next;
                        head = prev;
                    }else{
                        next = curr.next;
                        curr.next = next.next;
                        prev.next = next;
                        next.next = curr;
                        prev = next;
                    }
                }else{
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
	}
	 private static int lengthLL(LinkedListNode<Integer> head){
        int count = 1;
        while(head.next != null){
            head = head.next;
            count++;
        }
        return count;
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
        // Creating a linked list: 5 -> 1 -> 4 -> 2 -> 3 -> null
        LinkedListNode<Integer> head = new LinkedListNode<>(5);
        head.next = new LinkedListNode<>(1);
        head.next.next = new LinkedListNode<>(4);
        head.next.next.next = new LinkedListNode<>(2);
        head.next.next.next.next = new LinkedListNode<>(3);

        System.out.print("Original linked list: ");
        printLinkedList(head); // Output: 5 1 4 2 3

        // Sorting the linked list using bubble sort
        head = bubbleSort(head);

        System.out.print("Sorted linked list: ");
        printLinkedList(head); // Output: 1 2 3 4 5
    }
}
