package Stack;

import java.util.ArrayList;

public class StackUsingArrayList<E> {
    private ArrayList<E> stack;

    public StackUsingArrayList() {
        stack = new ArrayList<>();
    }

    // Push operation: Adds an element to the top of the stack
    public void push(E element) {
        stack.add(element);
    }

    // Pop operation: Removes and returns the element from the top of the stack
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        return stack.remove(stack.size() - 1);
    }

    // Peek operation: Returns the element at the top of the stack without removing it
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return stack.get(stack.size() - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        // Example usage:
        StackUsingArrayList<Integer> stack = new StackUsingArrayList<>();
    
        stack.push(1);
        stack.push(2);
        stack.push(3);
    
        System.out.println("Stack: " + stack.stack); // Printing the internal ArrayList representation
    
        System.out.println("Top element: " + stack.peek()); // Output: 3
    
        System.out.println("Popped element: " + stack.pop()); // Output: 3
    
        System.out.println("Stack size: " + stack.size()); // Output: 2
    
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
    
        // Pop all elements
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
    
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
    }

}


