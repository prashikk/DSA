package PriorityQueue.assignments;

import ArrayList.ArrayList;

/*Problem statement
Implement the function RemoveMin for the min priority queue class.

For a minimum priority queue, write the function for removing the minimum element present. Remove and return the minimum element.

Note : main function is given for your reference which we are using internally to test the code. */
public class removeMin {

    public class PQ {
        private ArrayList<Integer> heap;
    
        public PQ() {
            heap = new ArrayList<Integer>();
        }
    
        boolean isEmpty() {
            return heap.isEmpty();
        }
    
        int size() {
            return heap.size();
        }
    
        int getMin() throws PriorityQueueException {
            if (isEmpty()) {
                throw new PriorityQueueException("Priority queue is empty");
            }
            return heap.get(0);
        }
    
        void insert(int element) {
            heap.add(element);
            int childIndex = heap.size() - 1;
            while (childIndex > 0) {
                int parentIndex = (childIndex - 1) / 2;
                if (heap.get(childIndex) < heap.get(parentIndex)) {
                    // Swap child with parent
                    int temp = heap.get(childIndex);
                    heap.set(childIndex, heap.get(parentIndex));
                    heap.set(parentIndex, temp);
                    childIndex = parentIndex;
                } else {
                    break;
                }
            }
        }
    
        int removeMin() throws PriorityQueueException {
            if (isEmpty()) {
                throw new PriorityQueueException("Priority queue is empty");
            }
    
            int removedElement = heap.get(0);
            int lastElement = heap.remove(heap.size() - 1);
    
            if (!isEmpty()) {
                heap.set(0, lastElement);
                heapifyDown(0);
            }
    
            return removedElement;
        }
    
        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestIndex = index;
    
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallestIndex)) {
                smallestIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallestIndex)) {
                smallestIndex = rightChildIndex;
            }
    
            if (smallestIndex != index) {
                // Swap with the smallest child
                int temp = heap.get(index);
                heap.set(index, heap.get(smallestIndex));
                heap.set(smallestIndex, temp);
                heapifyDown(smallestIndex);
            }
        }
    
        public static void main(String[] args) {
            PQ pq = new PQ();
            pq.insert(3);
            pq.insert(1);
            pq.insert(5);
            pq.insert(2);
    
            try {
                while (!pq.isEmpty()) {
                    System.out.print(pq.removeMin() + " ");
                }
                // Output: 1 2 3 5
            } catch (PriorityQueueException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    class PriorityQueueException extends Exception {
        public PriorityQueueException(String message) {
            super(message);
        }
    }
}
