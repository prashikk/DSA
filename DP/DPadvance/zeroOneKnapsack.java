package DP.DPadvance;
/*Problem statement
A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13
Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51 */
public class zeroOneKnapsack {
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		//Your code goes here
		  int[][] dp = new int[n+1][maxWeight+1];
		
		for (int i=n-1;i>=0;i--)
		{
			for (int w=0;w<=maxWeight;w++)
			{
				if (weights[i]<=w)
				{
					int ans1=dp[i+1][w];
					int ans2=dp[i+1][w-weights[i]] + values[i];
					dp[i][w]=Math.max(ans1, ans2);
				}
				else
				{
					dp[i][w]=dp[i+1][w];
				}
			}
		}
		return dp[0][maxWeight];
	}
    public static void main(String[] args) {
        // Test cases
        int[] weights1 = {1, 2, 4, 5};
        int[] values1 = {5, 4, 8, 6};
        int maxWeight1 = 5;
        int n1 = weights1.length;
        System.out.println("Maximum value for Sample Input 1: " + knapsack(weights1, values1, n1, maxWeight1)); // Output: 13
        
        int[] weights2 = {12, 7, 11, 8, 9};
        int[] values2 = {24, 13, 23, 15, 16};
        int maxWeight2 = 26;
        int n2 = weights2.length;
        System.out.println("Maximum value for Sample Input 2: " + knapsack(weights2, values2, n2, maxWeight2)); // Output: 51
    }
}
