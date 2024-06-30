package Strings;
/*Problem statement
Reverse the given string word wise. That is, the last word in given string should come at 1st place, last second word at 2nd place and so on. Individual words should remain as it is.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= |S| <= 10^7
where |S| represents the length of string, S.
Sample Input 1:
Welcome to Coding Ninjas
Sample Output 1:
Ninjas Coding to Welcome
Sample Input 2:
Always indent your code
Sample Output 2:
code your indent Always */
public class reverseStringWordwise {
    
	public static String reverseWordWise(String input) {
		// Write your code here
		int n=input.length();
		int currentwordstart=0;
		String rev = "";
		
		int i=0;
		for(;i<input.length();i++) {
			if(input.charAt(i)==' ') {
			int currentwordend=i-1;
			String revword="";
			for(int j=currentwordstart;j<=currentwordend;j++) {
				revword= input.charAt(j)+revword;
				
			}
			rev+=revword+" ";
			currentwordstart=i+1;
			
			}
		}
		int currentwordend=i-1;
		String revword="";
		for(int j=currentwordstart;j<=currentwordend;j++) {
			revword= input.charAt(j)+revword;
		}
		rev+=revword;
		String reverse="";
		for(int j=0;j<input.length();j++) {
			reverse=rev.charAt(j)+reverse;
		}
		return reverse;
		

	}
    public static void main(String[] args) {
        String str = "I am a good boy";
        System.out.println(reverseWordWise(str));
    }
}
