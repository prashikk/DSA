package DP.DPadvance;
/*Problem statement
You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.

Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:

1. Delete a character
2. Replace a character with another one
3. Insert a character
Note :
Strings don't contain spaces in between.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".

And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 

Hence, the minimum distance.
Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9 */
public class editDistance {
    
	private static int editDistanceM(String s, String t, int[][] storage) {
		int m = s.length();
		int n = t.length();
		if(storage[m][n] != -1){
			return storage[m][n];
		}
		
		if(m == 0){
			storage[m][n] = n;
			return storage[m][n];
		}
		if(n == 0){
			storage[m][n] = m;
			return storage[m][n];
		}
		if(s.charAt(0) == t.charAt(0)){
			storage[m][n] = editDistanceM(s.substring(1), t.substring(1), storage);
		}else{
			
			int op1 = editDistanceM(s, t.substring(1), storage);
			
			int op2 = editDistanceM(s.substring(1), t, storage);
			
			int op3 = editDistanceM(s.substring(1), t.substring(1), storage);
			storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
		}
		return storage[m][n];
        
    }

	public static int editDistance(String s, String t) {
		//Your code goes here
		      int m = s.length();
		int n = t.length();
		int storage[][] = new int[ m + 1][n + 1];
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				storage[i][j] = -1;
			}
		}
		return editDistanceM(s,t,storage);
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "abc";
        String t1 = "dc";
        System.out.println("Edit Distance for input 1: " + editDistance(s1, t1));  // Output: 2
        
        String s2 = "whgtdwhgtdg";
        String t2 = "aswcfg";
        System.out.println("Edit Distance for input 2: " + editDistance(s2, t2));  // Output: 9
    }
}
