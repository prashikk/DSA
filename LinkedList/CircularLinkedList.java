package LinkedList;

public class CircularLinkedList<E> {
    
    private static class Node<E> {
        E data;
        Node<E> next;
        
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = head; // Circular linking
        size++;
    }
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
            tail.next = head; // Update tail's next to head for circular linking
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = current.next.next;
        }
        size--;
        return removedNode.data;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    public boolean contains(E e) {
        Node<E> current = head;
        do {
            if (current.data.equals(e)) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }
    
    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        
        System.out.println("Element at index 1: " + list.get(1)); // Output: Banana
        list.remove(1); // Remove "Banana"
        System.out.println("List contains Banana: " + list.contains("Banana")); // Output: false
        System.out.println("Size of the list: " + list.size()); // Output: 2
        
        list.clear();
        System.out.println("Size of the list after clearing: " + list.size()); // Output: 0
    }
}

