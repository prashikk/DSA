package PriorityQueueAdvance;

import java.util.PriorityQueue;

import ArrayList.ArrayList;
import java.util.*;

/*Problem statement
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.

Time complexity should be O(nlogk) and space complexity should be not more than O(k).

Order of elements in the output is not important.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output :
12
16
20
25 */
public class KLargestElement {
    public static ArrayList<Integer> kLargest(int input[], int k) {
            ArrayList<Integer> ary=new ArrayList<>();
            PriorityQueue<Integer> pq= new PriorityQueue<>();
        int i=0;
        for( ;i<k;i++){
            pq.add(input[i]);
        }
        for( ;i<input.length;i++){
            int min=pq.peek();
            if(min<input[i])
            {
                pq.remove();
                pq.add(input[i]);
            }
        }
        while(!pq.isEmpty())
        {
            ary.add(pq.poll());
        }
        return ary;
		
	}

    public static void main(String[] args) {
        int[] arr1 = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        int k1 = 4;
        ArrayList<Integer> result1 = KLargestElement.kLargest(arr1, k1);
        System.out.println("Sample Input 1:");
        printArray(arr1);
        System.out.println("4 largest elements:");
        printArrayList(result1);

        int[] arr2 = {5, 10, 2, 7, 15, 3};
        int k2 = 3;
        ArrayList<Integer> result2 = KLargestElement.kLargest(arr2, k2);
        System.out.println("\nSample Input 2:");
        printArray(arr2);
        System.out.println("3 largest elements:");
        printArrayList(result2);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArrayList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
