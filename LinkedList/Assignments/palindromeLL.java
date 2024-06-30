package LinkedList.Assignments;
/*Problem statement
You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.

Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the the given list is not a palindrome, hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome , hence the output is 'true'. */
public class palindromeLL {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
		//Your code goes here
		if(head==null){
			return true;
		}
        if(head.next==null){
            return true;
        }
	
	    LinkedListNode<Integer> temp=head,mid,h2;
        mid=midPoint(temp);
        h2=mid.next ;
        mid.next=null;
        h2=reverseIt(h2);
        boolean flag=false;
        while(temp!=null && h2!=null)
        {   flag=false;
         if(temp.data.equals(h2.data))
              flag=true;
             temp=temp.next;
             h2=h2.next;

        }
        return flag;
    }
    

    private static LinkedListNode<Integer> reverseIt(LinkedListNode<Integer> head)
    {   if(head==null || head.next==null)
        return head;
     LinkedListNode<Integer> tail=head.next;
     LinkedListNode<Integer> ans=reverseIt(head.next);
     tail.next=head;
     head.next=null;
     return ans;


    }

    private static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // Example usage:
        // Creating a palindrome linked list: 1 -> 2 -> 3 -> 2 -> 1 -> null
        LinkedListNode<Integer> head1 = new LinkedListNode<>(1);
        head1.next = new LinkedListNode<>(2);
        head1.next.next = new LinkedListNode<>(3);
        head1.next.next.next = new LinkedListNode<>(2);
        head1.next.next.next.next = new LinkedListNode<>(1);

        System.out.print("Linked list 1: ");
        printLinkedList(head1); // Output: 1 2 3 2 1
        System.out.println("Is palindrome: " + isPalindrome(head1)); // Output: true

        // Creating a non-palindrome linked list: 1 -> 2 -> 3 -> 4 -> null
        LinkedListNode<Integer> head2 = new LinkedListNode<>(1);
        head2.next = new LinkedListNode<>(2);
        head2.next.next = new LinkedListNode<>(3);
        head2.next.next.next = new LinkedListNode<>(4);

        System.out.print("Linked list 2: ");
        printLinkedList(head2); // Output: 1 2 3 4
        System.out.println("Is palindrome: " + isPalindrome(head2)); // Output: false
    }

    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
