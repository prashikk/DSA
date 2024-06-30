package Strings;
/*Problem statement
Given a string, determine if it is a palindrome, considering only alphanumeric characters.

Palindrome
A palindrome is a word, number, phrase, or other sequences of characters which read the same backwards and forwards.
Example:
If the input string happens to be, "malayalam" then as we see that this word can be read the same as forward and backwards, it is said to be a valid palindrome.

The expected output for this example will print, 'true'.
From that being said, you are required to return a boolean value from the function that has been asked to implement.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1 :
abcdcba
Sample Output 1 :
true 
Sample Input 2:
coding
Sample Output 2:
false */
public class stringPalindrome {

    public static boolean isPalindrome(String str) {
		//Your code goes here
			int n= str.length();

		int m=n-1;
		boolean ispalen=false;

		if(n==1){
			return ispalen=true;
		}
		for(int i=0;i<n/2;i++) {
			
			if(str.charAt(i)==str.charAt(m)) {
				ispalen=true;
				m--;
				
			}
			else {
				ispalen=false;
			}
			
			
		}
		return ispalen;
	}
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str));
        String str2 = "prashik";
        System.out.println(isPalindrome(str2));
    }
}
