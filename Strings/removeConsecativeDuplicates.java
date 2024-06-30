package Strings;
/*Problem statement
For a given string(str), remove all the consecutive duplicate characters.

Example:
Input String: "aaaa"
Expected Output: "a"

Input String: "aabbbcc"
Expected Output: "abc"
 Input Format:
The first and only line of input contains a string without any leading and trailing spaces. All the characters in the string would be in lower case.
Output Format:
The only line of output prints the updated string.
Note:
You are not required to print anything. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Constraints:
0 <= N <= 10^6
Where N is the length of the input string. */
public class removeConsecativeDuplicates {
    public static String removeConsecutiveDuplicates(String str) {
		//Your code goes here

			int n=str.length();
		String str1="";
		char ch=str.charAt(0);
		str1=str1+ch;
		
		
		int i=1;
		while(i<n){

			if(str.charAt(i)!=str.charAt(i-1)) {
				str1+=str.charAt(i);
				
			}
			i++;
		}
		return str1;
		
	}
    public static void main(String[] args) {
        String str1 = "aabccba";
        String str2 = "aabbccddee";
        String str3 = "abcd";
    
    System.out.println(removeConsecutiveDuplicates(str1)); // Output: "abcba"
    System.out.println(removeConsecutiveDuplicates(str2)); // Output: "abcde"
    System.out.println(removeConsecutiveDuplicates(str3)); // Output: "abcd"
    }
}
