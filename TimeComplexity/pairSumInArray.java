package TimeComplexity;
/*Problem statement
You have been given an integer array/list(ARR) and a number 'num'. Find and return the total number of pairs in the array/list which sum to 'num'.

Note:
Given array/list can contain duplicate elements. 
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4
0 <= num <= 10^9

Time Limit: 1 sec
Sample Input 1:
1
9
1 3 6 2 5 4 3 2 4
7
Sample Output 1:
7
Sample Input 2:
2
9
1 3 6 2 5 4 3 2 4
12
6
2 8 10 5 -2 5
10
Sample Output 2:
0
2


 Explanation for Input 2:
Since there doesn't exist any pair with sum equal to 12 for the first query, we print 0.

For the second query, we have 2 pairs in total that sum up to 10. They are, (2, 8) and (5, 5). */
public class pairSumInArray {
    public static int pairSum(int[] arr, int num) {
		//Your code goes here
		int n=arr.length;
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]+arr[j]==num) {
					count++;
					
				}
			}
		}
		return count;
	}
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 7, -1, 5};
        int num1 = 6;
        System.out.println(pairSum(arr1, num1)); // Output: 3
    }
}
