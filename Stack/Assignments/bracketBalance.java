package Stack.Assignments;

import java.util.Stack;

/*Problem statement
For a given a string expression containing only round brackets or parentheses, check if they are balanced or not. Brackets are said to be balanced if the bracket which opens last, closes first.



Example:
Expression: (()())
Since all the opening brackets have their corresponding closing brackets, we say it is balanced and hence the output will be, 'true'.
You need to return a boolean value indicating whether the expression is balanced or not.

Note:
The input expression will not contain spaces in between.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^7
 Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1 :
(()()())
Sample Output 1 :
true
Sample Input 2 :
()()(()
Sample Output 2 :
false
Explanation to Sample Input 2:
The initial two pairs of brackets are balanced. But when you see, the opening bracket at the fourth index doesn't have its corresponding closing bracket which makes it imbalanced and in turn, making the whole expression imbalanced. Hence the output prints 'false'. */
public class bracketBalance {
    public static boolean isBalanced(String expression) {
        //Your code goes here
        		
		Stack stack=new Stack();
		char[]chararr=expression.toCharArray();
		
		for(int i=0;i<chararr.length;i++) {
			char current=chararr[i];
			
			if( current == '{' || current =='[' || current =='(') {
				stack.push(current);
				continue;
				
			}
			if(stack.isEmpty()) {
				return false;
			}
			
		
		  char popChar;   
          switch (current) {   
              case ')':   
              popChar = (char) stack.pop();   
              if (popChar == '{' || popChar == '[')   
                  return false;   
              break;   
              case '}':   
              popChar = (char) stack.pop();   
              if (popChar == '(' || popChar == '[')   
                  return false;   
              break;   
              case ']':   
              popChar = (char) stack.pop();   
              if (popChar == '(' || popChar == '{')   
                  return false;   
              break;   
          }   
      }   
      return (stack.isEmpty()); 
    }
    public static void main(String[] args) {
        // Example usage:
        String expression1 = "{[()]}";
        String expression2 = "{[(])}";
        String expression3 = "{{[[(())]]}}";

        System.out.println(expression1 + " is balanced: " + isBalanced(expression1)); // Output: true
        System.out.println(expression2 + " is balanced: " + isBalanced(expression2)); // Output: false
        System.out.println(expression3 + " is balanced: " + isBalanced(expression3)); // Output: true
    }
}
