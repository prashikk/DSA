package Strings;
/*Problem statement
For a given a string(str) and a character X, write a function to remove all the occurrences of X from the given string.

The input string will remain unchanged if the given character(X) doesn't exist in the input string.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
aabccbaa
a
Sample Output 1:
bccb
Sample Input 2:
xxyyzxx
y
Sample Output 2:
xxzxx */
public class removeCharacter {
    public static String removeAllOccurrencesOfChar(String str, char ch) {
		// Your code goes here

		int n=str.length();
		String result="";
		
		int i=0;
		while(i<n) {
			if(str.charAt(i)!=ch) {
				result+=str.charAt(i);
				
			}
			i++;
			
		}
		
		return result;
	}
    public static void main(String[] args) {
        System.out.println(removeAllOccurrencesOfChar("aabccbaa", 'a'));
    }
}
