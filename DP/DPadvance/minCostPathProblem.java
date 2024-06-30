package DP.DPadvance;
/*Problem statement
An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).

From a cell (i, j), you can move in three directions:

1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= M <= 10 ^ 2
1 <= N <=  10 ^ 2

Time Limit: 1 sec
Sample Input 1 :
3 4
3 4 1 2
2 1 8 9
4 7 8 1
Sample Output 1 :
13
Sample Input 2 :
3 4
10 6 9 0
-23 8 9 90
-200 0 89 200
Sample Output 2 :
76
Sample Input 3 :
5 6
9 6 0 12 90 1
2 7 8 5 78 6
1 6 0 5 10 -4 
9 6 2 -10 7 4
10 -2 0 5 5 7
Sample Output 3 :
18 */
public class minCostPathProblem {
    public static int minCostPath(int[][] input) {
		//Your code goes here
		    int m=input.length;
		int n=input[0].length;
        
        int[][] dp = new int[m+1][n+1];
		for (int i=0;i<dp.length;i++)
		{
			for (int j=0;j<dp[0].length;j++)
			{
                
                dp[i][j]=Integer.MAX_VALUE;
			}
		}
        
        for (int i=m-1;i>=0;i--)
		{
			for (int j=n-1;j>=0;j--)
			{
                
                if (i==m-1 && j==n-1)
				{
					dp[i][j]=input[i][j];
					continue;
				}
				int ans1=dp[i+1][j];
				int ans2=dp[i][j+1];
				int ans3=dp[i+1][j+1];
				
				dp[i][j]=input[i][j]+Math.min(ans1, Math.min(ans2, ans3));
			}
		}
		return dp[0][0];
	}
    public static void main(String[] args) {
        // Test cases
        int[][] input1 = {
            {3, 4, 1, 2},
            {2, 1, 8, 9},
            {4, 7, 8, 1}
        };
        System.out.println("Minimum cost path for input 1: " + minCostPath(input1));  // Output: 13
        
        int[][] input2 = {
            {10, 6, 9, 0},
            {-23, 8, 9, 90},
            {-200, 0, 89, 200}
        };
        System.out.println("Minimum cost path for input 2: " + minCostPath(input2));  // Output: 76
        
        int[][] input3 = {
            {9, 6, 0, 12, 90, 1},
            {2, 7, 8, 5, 78, 6},
            {1, 6, 0, 5, 10, -4},
            {9, 6, 2, -10, 7, 4},
            {10, -2, 0, 5, 5, 7}
        };
        System.out.println("Minimum cost path for input 3: " + minCostPath(input3));  // Output: 18
    }
}
