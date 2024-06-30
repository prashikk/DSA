package Queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueUsingLinkedList<T> {
    private LinkedList<T> queue;

    public QueueUsingLinkedList() {
        queue = new LinkedList<>();
    }

    // Enqueue: Add an element to the end of the queue
    public void enqueue(T element) {
        queue.addLast(element);
    }

    // Dequeue: Remove an element from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.removeFirst();
    }

    // Peek: Look at the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.getFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return queue.size();
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element is: " + queue.peek());
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Queue size: " + queue.size());

        System.out.println("Front element is: " + queue.peek());
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Queue size: " + queue.size());

        System.out.println("Front element is: " + queue.peek());
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Queue size: " + queue.size());

        // Uncommenting the below line will throw an exception since the queue is empty
        // System.out.println(queue.dequeue());
    }
}
