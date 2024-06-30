package Queue.Assignments;

import java.util.LinkedList;
import java.util.Queue;

public class reverseTheFirstKElementsInTheQueue {
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		//Your code goes here
		  if (input.size()>k)
        {
            k=k%input.size();
        }
        if (k==0 || k==1)
        {
            return input;
        }
        
        reverseQueue(input,k);
        
        for (int i=0;i<input.size()-k;i++)
        {
            input.add(input.remove());
        }
        
        return input;
	}
	   public static void reverseQueue(Queue<Integer> input, int k) 
    {
		//Your code goes here
        if (input.size()==0 || input.size()==1 || k==0)
        {
            return;
        }
        
        int temp=input.remove();
        reverseQueue(input,k-1);
        input.add(temp);
	}

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 5; // Number of elements to reverse

        // Adding predefined values to the queue
        for (int value : values) {
            queue.add(value);
        }

        System.out.println("Original queue: " + queue);

        Queue<Integer> reversedQueue = reverseKElements(queue, k);

        System.out.println("Queue after reversing first " + k + " elements: " + reversedQueue);
    }
}
