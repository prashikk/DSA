package DP.DPadvance;
/*Problem statement
Miss. Noor Rashid is a teacher. She wants to give some chocolates to the students in her class. All the students sit in a line, and each of them has a score according to performance. Noor wants to give at least one chocolate to each student. She distributes chocolates to them such that If two students sit next to each other, then the one with the higher score must get more chocolates. Miss. Noor wants to save money, so she wants to minimize the total number of chocolates.

Note :
When two students have an equal score, they are allowed to have a different number of chocolates. 
Detailed explanation ( Input/output format, Notes, Images )
Constraints
1 <= N <= 10^5
1 <= score <= 10^5

Time Limit: 1 sec
Sample Input 1 :
4
1 4 4 6
Sample Output 1 :
6
Explanation:
One of the ways in which the chocolates can be distributed, such Noor has to give minimum number of chocolates, are: The first student can be given one chocolate, second student can be given two chocolates, third student can be one chocolate and fourth can be given two chocolates.  
Sample Input 2 :
3
8 7 5
Sample Output 2 :
6 */
public class minumumNumberOfChocolates {
    
	public static int getMin(int arr[], int N){
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
            
        int dp[]=new int[N+1];
        dp[0]=1;
        int i=0;
        int sum=0;
        for(i=1; i<N;i++)
        {
            if(arr[i]>arr[i-1])
            {
                dp[i]=dp[i-1]+1;
            }
            else
                dp[i]=1;
        }
        for(i=N-2;i>=0;i--)
        {
            if(arr[i]>arr[i+1] && dp[i]<=dp[i+1])
            {
                dp[i]=dp[i+1]+1;
            }
        }
        for(i=0;i<N;i++)
            sum+=dp[i];
        return sum;
    }
    public static void main(String[] args) {
        // Sample inputs
        int[] arr1 = {1, 4, 4, 6};
        int[] arr2 = {8, 7, 5};

        // Compute and print results
        System.out.println("Minimum chocolates for students in line 1: " + getMin(arr1, arr1.length)); // Output: 6
        System.out.println("Minimum chocolates for students in line 2: " + getMin(arr2, arr2.length)); // Output: 6
    }
}
