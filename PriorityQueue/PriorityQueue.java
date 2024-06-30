package PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;


public class PriorityQueue<T extends Comparable<T>> {
    private T[] heap;
    private int size;
    private Comparator<T> comparator;

    public PriorityQueue() {
        this.heap = (T[]) new Comparable[10]; // Initial capacity of 10
        this.size = 0;
        this.comparator = null; // Default to natural ordering
    }

    public PriorityQueue(Comparator<T> comparator) {
        this();
        this.comparator = comparator;
    }

    public void enqueue(T item) {
        // Resize array if necessary
        if (size == heap.length - 1) {
            resize(2 * heap.length);
        }

        heap[size++] = item;
        bubbleUp(size - 1);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        T root = heap[0];
        heap[0] = heap[--size];
        heap[size] = null; // Avoid loitering
        bubbleDown(0);

        // Resize array if necessary
        if (size > 0 && size == heap.length / 4) {
            resize(heap.length / 2);
        }

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        heap = Arrays.copyOf(heap, capacity);
    }

    private void bubbleUp(int index) {
        while (index > 0 && isLess(parent(index), index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown(int index) {
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);
            int largest = index;

            if (left < size && isLess(largest, left)) {
                largest = left;
            }
            if (right < size && isLess(largest, right)) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private boolean isLess(int i, int j) {
        if (comparator != null) {
            return comparator.compare(heap[i], heap[j]) < 0;
        } else {
            return heap[i].compareTo(heap[j]) < 0;
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public static void main(String[] args) {
        // Example usage of the PriorityQueue class with integers
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.enqueue(3);
        pq.enqueue(1);
        pq.enqueue(5);
        pq.enqueue(2);

        while (!pq.isEmpty()) {
            System.out.print(pq.dequeue() + " ");
        }
        // Output: 5 3 2 1
    }
}
