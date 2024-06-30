package RecurssionHard;
import java.util.*;
/*Problem statement
You are given an sorted integer array of size 'n'.



Your task is to find and return all the unique subsets of the input array.



Subsets are arrays of length varying from 0 to 'n', that contain elements of the array. But the order of elements should remain the same as in the input array.



Note:
The order of subsets is not important. You can return the subsets in any order. However, in the output, you will see the subsets in lexicographically sorted order.


Constraints :
1 <= n <= 15
1 <= arr[i] <= 100

Time Limit: 1 sec
Example:
Input: 'n' = 3, 'arr' = [12, 15, 20]

Output: [[], [12], [12, 15], [12, 15, 20], [12, 20], [15], [15, 20], [20]]

Sample Explanation: Since there are no repeated numbers, a total of 8 subsets are generated.
Constraints :
1 <= n <= 15
1 <= arr[i] <= 100

Time Limit: 1 sec
Example:
Input: 'n' = 3, 'arr' = [12, 15, 20]

Output: [[], [12], [12, 15], [12, 15, 20], [12, 20], [15], [15, 20], [20]]

Sample Explanation: Since there are no repeated numbers, a total of 8 subsets are generated.
Input Format :
The first line will contain the value of ‘n’.

The second line will contain n integers, denoting the array 'arr' elements.
Output format :
Return all unique subsets in any order.
Note :
You don't need to print anything. It has already been taken care of. Just implement the given function.
Sample Input 1 :
3
12 15 20
Sample Output 1 :
[] (this represents an empty array)
12 
12 15 
12 15 20 
12 20 
15 
15 20 
20 
Explanation Of Sample Input 1 :
Since there are no repeated numbers, 8 subsets are generated.
Sample Input 2 :
3
1 1 2
Sample Output 2 :
[]    
1 
1 1 
1 1 2 
1 2 
2 
Explanation Of Sample Input 2 :
Since there are repeated numbers, the total number of unique subsets is 6.
Expected Time Complexity :
The expected time complexity is O(k * 2^n), where n is the size of the array and 'k' is the average size of a subset.
Expected Space Complexity :
The expected time complexity is O(k * 2^n), where n is the size of the array and 'k' is the average size of a subset. */
public class giveAllUniqueSubsets {
    public static void printSubsets(int input[]) {
		// Write your code here
		        int output[]=new int[0];
        printsubsets(input,0,output);

	}
	   public static void printsubsets(int input[],int si,int output[])
    { 
        if(si==input.length)
        {
            for(int i:output){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        printsubsets(input,si+1,output);
       
        int newoutput[]=new int[output.length+1];
          int j=0;
        for( ;j<output.length;j++)
        {
            newoutput[j]=output[j];
        }
        newoutput[j]=input[si];
        printsubsets(input,si+1,newoutput);
        }
        public static void main(String[] args) {
            // Test Case 1
            int[] arr1 = {12, 15, 20};
            System.out.println("Test Case 1:");
            System.out.println("Input Array: " + Arrays.toString(arr1));
            System.out.println("Unique Subsets:");
            giveAllUniqueSubsets.printSubsets(arr1);
            System.out.println();
    
            // Test Case 2
            int[] arr2 = {1, 1, 2};
            System.out.println("Test Case 2:");
            System.out.println("Input Array: " + Arrays.toString(arr2));
            System.out.println("Unique Subsets:");
            giveAllUniqueSubsets.printSubsets(arr2);
        }
}
