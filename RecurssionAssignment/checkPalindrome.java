package RecurssionAssignment;
/*Problem statement
Determine if a given string ‘S’ is a palindrome using recursion. Return a Boolean value of true if it is a palindrome and false if it is not.

Note: You are not required to print anything, just implement the function. Example:
Input: s = "racecar"
Output: true
Explanation: "racecar" is a palindrome.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
abbba
Sample Output 1:
true
Explanation Of Sample Input 1 :
“abbba” is a palindrome
Sample Input 2:
abcd
Sample Output 2:
false
Explanation Of Sample Input 2 :
“abcd” is not a palindrome.
Constraints:
0 <= |S| <= 10^6
where |S| represents the length of string S. */
public class checkPalindrome {
    public static boolean isStringPalindrome(String input) {
		// Write your code here
		if(input.length()<=1){
			return true;
		}
		if(input.charAt(0)==input.charAt(input.length()-1)){
			return isStringPalindrome(input.substring(1, input.length()-1));
		}
		else{
			return false;
		}

	}
    public static void main(String[] args) {
        System.out.println(isStringPalindrome("racecar"));
    }
}
