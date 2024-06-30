package LinkedList;

public class DoublyLinkedList<E> {
    
    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;
        
        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public DoublyLinkedList() {
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
            newNode.prev = tail;
            tail = newNode;
        }
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
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List becomes empty
            }
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            removedNode = current;
            current.prev.next = current.next;
            current.next.prev = current.prev;
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
        while (current != null) {
            if (current.data.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
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

