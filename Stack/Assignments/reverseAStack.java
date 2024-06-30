package Stack.Assignments;

import java.util.Stack;

/*Problem statement
You have been given two stacks that can store integers as the data. Out of the two given stacks, one is populated and the other one is empty. You are required to write a function that reverses the populated stack using the one which is empty.

For Example:
Alt txt

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^3
-2^31 <= data <= 2^31 - 1

Time Limit: 1sec 
Sample Input 1:
6
1 2 3 4 5 10
Note:
Here, 10 is at the top of the stack.
Sample Output 1:
1 2 3 4 5 10
Note:
Here, 1 is at the top of the stack.
Sample Input 2:
5
2 8 15 1 10
Sample Output 2:
2 8 15 1 10 */
public class reverseAStack {
    private static void insert(Stack<Integer> stack, int temp) {

		if(stack.isEmpty()) {
			stack.push(temp);
		}
		else {
			int temp2=stack.pop();
			insert(stack,temp);
			stack.push(temp2);
		}
	}

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
			if(!input.isEmpty()) {
			int temp=input.pop();
			reverseStack(input,extra);
			insert(input,temp);
		}
	}

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Stack<Integer> extra = new Stack<>();
        reverseStack(stack, extra);

        // Printing the reversed stack
        System.out.print("Reversed stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
