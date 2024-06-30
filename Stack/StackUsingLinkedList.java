package Stack;

// Node class for LinkedList
class Node<E> {
    E data;
    Node<E> next;

    // Constructor to initialize data and next
    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}

// Stack implemented using LinkedList
public class StackUsingLinkedList<E> {
    private Node<E> top; // Pointer to the top of the stack
    private int size;    // Size of the stack

    // Constructor to initialize an empty stack
    public StackUsingLinkedList() {
        this.top = null;
        this.size = 0;
    }

    // Push operation: Adds an element to the top of the stack
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top; // New node points to the current top
        top = newNode;      // New node becomes the top
        size++;
    }

    // Pop operation: Removes and returns the element from the top of the stack
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        E poppedData = top.data;
        top = top.next; // Move top to the next node
        size--;
        return poppedData;
    }

    // Peek operation: Returns the element at the top of the stack without removing it
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        // Example usage:
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

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

