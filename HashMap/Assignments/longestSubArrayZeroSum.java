package HashMap.Assignments;
import java.util.*;
/*Problem statement
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1:
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output 1:
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897 
Note
You don't have to print anything. Just complete the definition of the function given and return the value accordingly. */
public class longestSubArrayZeroSum {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		// Write your code here
		 
         HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0,maxLen=-1;
        for (int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            //System.out.println("Current cumulative sum: "+sum);
            if (sum==0)
            {
                maxLen=i+1;
            }
            if (map.containsKey(sum))
            {
                int prevIndex=map.get(sum);
                //System.out.println("Sum found previously at index: "+prevIndex);
                int currLen=i-prevIndex;
                //System.out.println("Length of 0 sum: "+currLen);
                if (currLen>maxLen)
                {
                    maxLen=currLen;
                    //System.out.println("Max Length of 0 sum: "+maxLen);
                }
            }
            else
            {
                //System.out.println("Adding sum to HashMap");
                map.put(sum,i);
            }
            //System.out.println();
        }
        return maxLen;
	}
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {95, -97, -387, -435, -5, -70, 897, 127, 23, 284};
        System.out.println("Test Case 1: " + lengthOfLongestSubsetWithZeroSum(arr1)); // Expected output: 5

        // Test case 2
        int[] arr2 = {10, 20, -10, -20, 30};
        System.out.println("Test Case 2: " + lengthOfLongestSubsetWithZeroSum(arr2)); // Expected output: 3

        // Additional test cases
        // Test case 3
        int[] arr3 = {1, -1, 2, -2, 3, -3, 4, -4};
        System.out.println("Test Case 3: " + lengthOfLongestSubsetWithZeroSum(arr3)); // Expected output: 4

        // Test case 4
        int[] arr4 = {4, 2, -3, 1, 6};
        System.out.println("Test Case 4: " + lengthOfLongestSubsetWithZeroSum(arr4)); // Expected output: 2

        // Test case 5
        int[] arr5 = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        System.out.println("Test Case 5: " + lengthOfLongestSubsetWithZeroSum(arr5)); // Expected output: 8
    }
}
