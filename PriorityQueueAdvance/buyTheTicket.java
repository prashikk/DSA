package PriorityQueueAdvance;
import java.util.*;
/*Problem statement
You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority.

A queue is maintained for buying the tickets and every person is attached with a priority (an integer, 1 being the lowest priority).

The tickets are sold in the following manner -

1. The first person (pi) in the queue requests for the ticket.
2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
3. Otherwise, give him the ticket (and don't make him stand in queue again).
Giving a ticket to a person takes exactly 1 second and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.

Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). Find and return the time it will take until you get the ticket.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 sec
Sample Input 1 :
3
3 9 4
2
Sample Output 1 :
2
Sample Output 1 Explanation :
Person with priority 3 comes out. But there is a person with higher priority than him. So he goes and then stands in the queue at the end. Queue's status :  {9, 4, 3}. Time : 0 secs.
Next, the person with priority 9 comes out. And there is no person with higher priority than him. So he'll get the ticket. Queue's status :  {4, 3}. Time : 1 secs.
Next, the person with priority 4 comes out (which is you). And there is no person with higher priority than you. So you'll get the ticket. Time : 2 secs.
Sample Input 2 :
5
2 3 2 2 4
3
Sample Output 2 :
4 */
public class buyTheTicket {
    public static int buyTicket(int input[], int k) {
	 Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<input.length;i++){
            queue.add(i);
            pq.add(input[i]);
        }
        int time=0;
        while (!queue.isEmpty()){
            if (input[queue.peek()] < pq.peek())
            {
                queue.add(queue.poll());
            }
            else
            {
                int idx = queue.poll();
                pq.remove();
                time++;
                if (idx == k)
                {
                    break;
                }
            }
        }
        return time;
	}
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {3, 9, 4};
        int k1 = 2;
        int result1 = buyTicket(arr1, k1);
        System.out.println("Time to get ticket in arr1: " + result1); // Expected output: 2
        
        int[] arr2 = {2, 3, 2, 2, 4};
        int k2 = 3;
        int result2 = buyTicket(arr2, k2);
        System.out.println("Time to get ticket in arr2: " + result2); // Expected output: 4
    }
}
