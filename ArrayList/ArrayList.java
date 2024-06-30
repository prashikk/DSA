package ArrayList;

import java.util.Arrays;

public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear to let GC do its work
        return oldValue;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    private int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
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

    public boolean isEmpty() {
        return false;
    }
}
