package Queue;

import ArrayList.ArrayList;

public class QueueUsingArrayList<T> {
    private ArrayList<T> queue;

    public QueueUsingArrayList() {
        queue = new ArrayList<>();
    }

    // Enqueue: Add an element to the end of the queue
    public void enqueue(T element) {
        queue.add(element);
    }

    // Dequeue: Remove an element from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.remove(0);
    }

    // Peek: Look at the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.get(0);
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
        QueueUsingArrayList<Integer> queue = new QueueUsingArrayList<>();
        
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
