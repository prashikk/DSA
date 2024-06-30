package PriorityQueueAdvance;
import java.util.*;
/*Problem statement
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k smallest numbers from given array. You need to save them in an array and return it.

Time complexity should be O(n * logk) and space complexity should not be more than O(k).

Note: Order of elements in the output is not important.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 sec
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output 1 :
1 2 3 5  */
public class KSmallestElement {
    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		// Write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<k;i++)
        {
            pq.add(input[i]);
        }
        
        for(int i=k;i<input.length;i++)
        {
            int maxVal=pq.peek();
            if(maxVal>input[i])
                maxVal=input[i];
            if(maxVal!=pq.peek())
            {
                pq.poll();
                pq.add(maxVal);
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(!pq.isEmpty())
            arr.add(pq.poll());
        return arr;

	}
    public static void main(String[] args) {
        int[] arr1 = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        int k1 = 4;
        ArrayList<Integer> result1 = KSmallestElement.kSmallest(arr1.length, arr1, k1);
        System.out.println("Sample Input 1:");
        printArray(arr1);
        System.out.println(k1 + " smallest elements:");
        printArrayList(result1);

        int[] arr2 = {5, 10, 2, 7, 15, 3};
        int k2 = 3;
        ArrayList<Integer> result2 = KSmallestElement.kSmallest(arr2.length, arr2, k2);
        System.out.println("\nSample Input 2:");
        printArray(arr2);
        System.out.println(k2 + " smallest elements:");
        printArrayList(result2);
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArrayList(ArrayList<Integer> list) {
        for (int num : list) {
            System.out.println(num);
        }
    }

}
