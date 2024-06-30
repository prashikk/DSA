package DP.DPadvance;
/*Problem statement
You are given a set of N integers. You have to return true if there exists a subset that sum up to K, otherwise return false.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3
1 <= a[i] <= 10^3, where a[i] denotes an element of the set 
1 <= K <= 10^3

Time Limit: 1 sec
Sample Input 1 :
4
4 3 5 2
13
Sample Output 1 :
No
Sample Input 2 :
5
4 2 5 6 7
14
Sample Output 2 :
Yes */
public class subsetSum {
    static boolean isSubsetPresent(int[] arr, int n, int sum) {

        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
          boolean[][] dp=new boolean[n+1][sum+1];
            for(int i=0;i<=n;i++)
            {
                dp[i][0]=true;
            }
        for(int i=1;i<=sum;i++)
        {
            dp[0][i]=false;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(j<arr[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        boolean result=dp[n][sum];
        return result;

    }
    public static void main(String[] args) {
        // Sample inputs
        int[] arr1 = {4, 3, 5, 2};
        int sum1 = 13;
        int[] arr2 = {4, 2, 5, 6, 7};
        int sum2 = 14;

        // Compute and print results
        System.out.println("Is there a subset that sums up to " + sum1 + "? " + (isSubsetPresent(arr1, arr1.length, sum1) ? "Yes" : "No")); // Output: No
        System.out.println("Is there a subset that sums up to " + sum2 + "? " + (isSubsetPresent(arr2, arr2.length, sum2) ? "Yes" : "No")); // Output: Yes
    }
}
