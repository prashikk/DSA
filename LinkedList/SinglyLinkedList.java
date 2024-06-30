package LinkedList;

public class SinglyLinkedList<E> {
    
    private static class Node<E> {
        E data;
        Node<E> next;
        
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<E> head;
    private int size;
    
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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
        head = null;
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
}


