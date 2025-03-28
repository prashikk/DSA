package DP;
/*Problem statement
A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count and return all possible ways in which the child can run-up to the stairs.

Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1:
4
Sample Output 1:
7
Sample Input 2:
10
Sample Output 2:
274 */
public class stairCase {
    public static long staircase(int n) {
		//Your code goes here
		long storage[]=new long[n+1];
		storage[0]=1;
		storage[1]=1;
		for(int i=2;i<storage.length;i++) {
			long op2=0,op3=0;
			long op1=storage[i-1];
			if(i-2>=0)
			 op2=storage[i-2];
			if(i-3>=0)
			 op3=storage[i-3];
			storage[i]=op1+op2+op3;
		}
		return storage[n];
	}
    public static void main(String[] args) {
        // Test Case 1
        int n1 = 4;
        System.out.println("Number of ways to climb " + n1 + " stairs: " + stairCase.staircase(n1));

        // Test Case 2
        int n2 = 10;
        System.out.println("Number of ways to climb " + n2 + " stairs: " + stairCase.staircase(n2));
    }
}
