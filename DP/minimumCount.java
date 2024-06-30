package DP;
/*Problem statement
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.

That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)

B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)

C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.
Sample Input 2 :
9
Sample Output 2 :
1 */
public class minimumCount {
    public static int minCount(int n) {
		//Your code goes here
		int storage[]=new int[n+1];
		if(n<=3) {
			return n;
		}
		storage[0]=0;
		storage[1]=1;
		storage[2]=2;
		storage[3]=3;
		for(int i=4;i<=n;i++) {
			int ans=i;
			for(int j=1;j<=Math.sqrt(i);j++) {
				ans =Math.min(ans, storage[i-j*j]+1);
			}
			storage[i]=ans;
		}
		return storage[n];
	}

    public static void main(String[] args) {
        // Test Case 1
        int n1 = 12;
        System.out.println("Minimum count for n = " + n1 + ": " + minimumCount.minCount(n1));

        // Test Case 2
        int n2 = 9;
        System.out.println("Minimum count for n = " + n2 + ": " + minimumCount.minCount(n2));
    }
}
