package Stack.Assignments;

import java.util.Stack;

/*Problem statement
For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.

A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.

Example:
Expression: (a+b)+c
Since there are no needless brackets, hence, the output must be 'false'.

Expression: ((a+b))
The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.
Note:
You will not get a partial score for this problem. You will get marks only if all the test cases are passed.
Return "false" if no brackets are present in the input.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1 second
Sample Input 1:
a+(b)+c 
Sample Output 1:
true
Explanation:
The expression can be reduced to a+b+c. Hence, the brackets are redundant.
Sample Input 2:
(a+b)
Sample Output 2:
false */
public class checkRedundantBrackets {
    public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] str = expression.toCharArray();

        for (char ch : str) {
            if (ch == ')') {
                char top = stack.pop();
                boolean hasOperator = false;

                while (top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                    top = stack.pop();
                }

                if (!hasOperator) {
                    return true; // Found redundant brackets
                }
            } else {
                stack.push(ch);
            }
        }

        return false; // No redundant brackets found
    }
    public static void main(String[] args) {
        String expression1 = "((a + b))";
        String expression2 = "(a + (b * c))";
        String expression3 = "(a + b) * (c - d)";

        System.out.println(expression1 + " has redundant brackets: " + checkRedundantBrackets(expression1));
        System.out.println(expression2 + " has redundant brackets: " + checkRedundantBrackets(expression2));
        System.out.println(expression3 + " has redundant brackets: " + checkRedundantBrackets(expression3));
    }
}
