package Stack.Assignments;

import java.util.Stack;

/*Problem statement
For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.

If the expression can't be balanced, return -1.

Example:
Expression: {{{{
If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

Expression: {{{
In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be able to make the expression balanced and the output will be -1.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1:
{{{
Sample Output 1:
-1
Sample Input 2:
{{{{}}
Sample Output 2:
1 */
public class minimumBracketreversal {
    public static int countBracketReversals(String input) {
		//Your code goes here
			
		if(input.length()%2!=0) {
			return -1;
		}
		
		Stack<Character> stack= new Stack<>();
		for(int i=0;i<input.length();i++) {
			char current = input.charAt(i);
			if(current=='{') {
				stack.push(current);
			}
			else if(current =='}') {
				if(stack.isEmpty()|| stack.peek()=='}') {
					stack.push('}');
				}
				  else if(stack.peek()=='{')
	                {
	                    stack.pop();
	                }
			}
		}
		
		int count=0;
		while(stack.size()!=0) {
			char c1=(char)stack.pop();
			char c2= (char)stack.pop();
			if(c1==c2) {
				if(c2=='{') {
					c2='}';
				}
				if(c1=='}') {
					
					c1='{';
				}
				count++;
			}
			else {
				c1='{';
				c2='}';
				count++;
				count++;
			}
		}
		return count;
	}

    public static void main(String[] args) {
        String input1 = "{{{{}}}}"; // Balanced case
        String input2 = "}}{{";     // Needs 2 reversals to balance

        int reversals1 = countBracketReversals(input1);
        int reversals2 = countBracketReversals(input2);

        System.out.println("Input: " + input1);
        System.out.println("Minimum reversals needed: " + reversals1); // Output: 0

        System.out.println("Input: " + input2);
        System.out.println("Minimum reversals needed: " + reversals2); // Output: 2
    }
}
