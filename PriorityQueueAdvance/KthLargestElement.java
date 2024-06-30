package PriorityQueueAdvance;

import java.util.PriorityQueue;

/*Problem statement
Given an array 'arr' of random integers and an integer 'k', return the kth largest element in the array.



Note: Try to do this in O(n*log k) time.


Example:
Input:
5
3 2 5 1 4
2
Output:
4
Explanation:
Array in non increasing form is [5,4,3,2,1]. So the 2nd largest is 4.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
9 4 8 7 11 3
2
Sample Output 1 :
9
Explanation of sample input 1:
arr = [9,4,8,7,11,3]
Array 'arr' in non increasing form is [11,9,8,7,4,3]. So the 2nd largest is 9.
Sample Input 2 :
8
2 6 10 11 13 4 1 20
4
Sample Output 2 :
10
Constraints :
1 <= n <= 10^5
1 <= arr[i] <= 10^5
1 <= k <= n
Time Limit: 1 sec */
public class KthLargestElement {
    public static int kthLargest(int n, int[] input, int k) {
		// Write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++)
        {
            pq.add(input[i]);
        }
        
        for(int i=k;i<input.length;i++)
        {
            int minVal=pq.peek();
            if(minVal<input[i])
                minVal=input[i];
            if(minVal!=pq.peek())
            {
                pq.poll();
                pq.add(minVal);
            }
        }
        
        int minVal=Integer.MAX_VALUE;
        while(!pq.isEmpty())
        {
            int check=pq.poll();
            if(check<minVal)
                minVal=check;
        }
        return minVal;
	}
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {3, 2, 5, 1, 4};
        int k1 = 2;
        int result1 = kthLargest(arr1.length, arr1, k1);
        System.out.println("2nd largest element in arr1: " + result1); // Expected output: 4
        
        int[] arr2 = {9, 4, 8, 7, 11, 3};
        int k2 = 2;
        int result2 = kthLargest(arr2.length, arr2, k2);
        System.out.println("2nd largest element in arr2: " + result2); // Expected output: 9
        
        int[] arr3 = {2, 6, 10, 11, 13, 4, 1, 20};
        int k3 = 4;
        int result3 = kthLargest(arr3.length, arr3, k3);
        System.out.println("4th largest element in arr3: " + result3); // Expected output: 10
    }
}
