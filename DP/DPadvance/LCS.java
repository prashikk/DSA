package DP.DPadvance;
/*Problem statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0. */

public class LCS {
    private static int lcsM(String s, String t, int[][] storage) {
		int m = s.length();
		int n = t.length();
		
		if(storage[m][n] != -1){
			return storage[m][n];
		}
		if(m == 0 || n == 0){
			storage[m][n] = 0;
			return storage[m][n];
		}
		if(s.charAt(0) == t.charAt(0)){
			storage[m][n] = 1 + lcsM(s.substring(1), t.substring(1), storage);
		}else{
			int op1 = lcsM(s, t.substring(1), storage);
			int op2 = lcsM(s.substring(1), t, storage);
			storage[m][n] = Math.max(op1, op2);
		}
		return storage[m][n];
	}
	public static int lcsM(String s, String t){
		int storage[][] = new int[s.length() + 1][t.length() + 1];
		for(int i = 0; i < s.length() + 1; i++){
			for(int j = 0; j < t.length() + 1; j++){
				storage[i][j] = -1;
			}
		}
		return lcsM(s, t, storage);
	}

	public static int lcs(String s, String t) {
		//Your code goes here
		if(s.length() == 0 || t.length() == 0){
			return 0;
		}
		
		if(s.charAt(0) == t.charAt(0)){
			return 1 + lcs(s.substring(1), t.substring(1));
		}else{
			int op1 = lcs(s, t.substring(1));
			int op2 = lcs(s.substring(1), t);
			return Math.max(op1, op2);
    }
	}
    public static void main(String[] args) {
        // Test cases
        String s1 = "adebc";
        String t1 = "dcadb";
        System.out.println("Longest Common Subsequence length for input 1: " + lcs(s1, t1));  // Output: 3
        
        String s2 = "ab";
        String t2 = "defg";
        System.out.println("Longest Common Subsequence length for input 2: " + lcs(s2, t2));  // Output: 0
    }
}
