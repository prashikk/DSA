package HashMap.Assignments;

import HashMap.HashMap;

/*Problem statement
You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.

If two or more elements are having the maximum frequency, return the element which occurs in the array first.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6 
Sample Output 1 :
2
Sample Input 2 :
6
7 2 2 4 8 4
Sample Output 2 :
2
Explanation:
Here, both element '2' and element '4' have same frequency but '2' ocurr first in orignal array that's why we are returning '2' as output.  */
public class maximumFrequencyNumber {
    public static int maxFrequencyNumber(int[] arr){ 
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
			
	 HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(h.containsKey(arr[i])){
                h.put(arr[i],h.get(arr[i])+1);
            }
            else
                h.put(arr[i],1);
        }
        int max=0;
        int maxKey=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
       
        {
            if(h.get(arr[i])>max){
                max=h.get(arr[i]);
                maxKey=arr[i];}
        }
     


        return maxKey ;
    }
    public static void main(String[] args) {
        // Test case 1
        int[] testCase1 = {2, 12, 2, 11, 12, 2, 1, 2, 2, 11, 12, 2, 6};
        System.out.println("Test Case 1: " + maxFrequencyNumber(testCase1)); // Expected output: 2

        // Test case 2
        int[] testCase2 = {7, 2, 2, 4, 8, 4};
        System.out.println("Test Case 2: " + maxFrequencyNumber(testCase2)); // Expected output: 2

        // Additional test cases
        int[] testCase3 = {1, 2, 3, 4, 5, 1, 2, 1};
        System.out.println("Test Case 3: " + maxFrequencyNumber(testCase3)); // Expected output: 1

        int[] testCase4 = {5, 5, 5, 4, 4, 4, 4};
        System.out.println("Test Case 4: " + maxFrequencyNumber(testCase4)); // Expected output: 4

        int[] testCase5 = {10, 20, 20, 10, 30, 30, 30, 20};
        System.out.println("Test Case 5: " + maxFrequencyNumber(testCase5)); // Expected output: 20
    }
}
