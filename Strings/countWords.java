package Strings;
/*Problem statement
For a given input string(str), find and return the total number of words present in it.

It is assumed that two words will have only a single space in between. Also, there wouldn't be any leading and trailing spaces in the given input string.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 sec
Sample Input 1:
Coding Ninjas!
Sample Output 1:
2
Sample Input 2:
this is a sample string
Sample Output 2:
5 */
public class countWords {

    public static int countWords(String str) {	
int n=str.length();
		if(n==0){
			return 0 ;
		}
		
		String words[]=str.split("\\s+");
		return words.length;
	}
    public static void main(String[] args) {
        String str = "prashik khotkar";
        System.out.println(countWords(str));
    }
}
