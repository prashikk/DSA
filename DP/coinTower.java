package DP;
/*Problem statement
Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. The person to make the last move wins the game. Can you find out who wins the game?

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10 ^ 6
2 <= X <= Y<= 50

Time Limit: 1 sec
Sample Input 1 :
4 2 3
Sample Output 1 :
Whis
Sample Input 2 :
10 2 4
Sample Output 2 :
Beerus
Explanation to Sample Input 1:
Initially, there are 4 coins,  In the first move, Beerus can remove either 1, 2, or 3 coins in all three cases, Whis can win by removing all the remaining coins. */
public class coinTower {
    public static String findWinner(int n, int x, int y) {
		//Your code goes here
		      int[] dp = new int[n+1];
        // 0 - Whis wins ; 1 - Beerus wins
        dp[0]=0;
        dp[1]=1;
    
        for (int i=2;i<=n;i++)
        {
            //Beerus wins if dp[i-1] or dp[i-x] or dp[i-y] is 0, i.e, Whis wins when the number of coins is (i-1), (i-x) or (i-y)
            //If none of them are 0, then Beerus cannot win => This means Whis wins for i number of coins
            if (dp[i-1]==0)
            {
                dp[i]=1;
            }
            else if ((i-x)>=0 && dp[i-x]==0)
            {
                dp[i]=1;
            }
            else if ((i-y)>=0 && dp[i-y]==0)
            {
                dp[i]=1;
            }
            else
            {
                dp[i]=0;
            }
            /*
            if (dp[i]==1)
            	System.out.println("For n="+i+" coins, Winner is: Beerus");
        	else
            	System.out.println("For n="+i+" coins, Winner is: Whis");
            */
        }
        
        if (dp[n]==1)
            return "Beerus";
        else
            return "Whis";
    }
    public static void main(String[] args) {
        // Test cases
        int n1 = 4, x1 = 2, y1 = 3;
        int n2 = 10, x2 = 2, y2 = 4;
        
        System.out.println("Winner for n = 4, x = 2, y = 3: " + findWinner(n1, x1, y1)); // Output: Whis
        System.out.println("Winner for n = 10, x = 2, y = 4: " + findWinner(n2, x2, y2)); // Output: Beerus
    }
}
