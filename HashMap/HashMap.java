package HashMap;
import java.util.*;

public class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private ArrayList<LinkedList<Entry<K, V>>> buckets;
    private int size;

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int initialCapacity) {
        buckets = new ArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            buckets.add(new LinkedList<>());
        }
        size = 0;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.size();
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;

        // Check load factor
        if ((double) size / buckets.size() > LOAD_FACTOR) {
            rehash();
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public V remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return entry.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private void rehash() {
        ArrayList<LinkedList<Entry<K, V>>> oldBuckets = buckets;
        buckets = new ArrayList<>(oldBuckets.size() * 2);

        for (int i = 0; i < oldBuckets.size() * 2; i++) {
            buckets.add(new LinkedList<>());
        }

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                int newIndex = getIndex(entry.key);
                buckets.get(newIndex).add(entry);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding elements
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);

        // Testing get
        System.out.println("Value of key 'two': " + map.get("two")); // Output: 2
        System.out.println("Value of key 'five': " + map.get("five")); // Output: null

        // Testing containsKey
        System.out.println("Contains key 'three'? " + map.containsKey("three")); // Output: true
        System.out.println("Contains key 'six'? " + map.containsKey("six")); // Output: false

        // Testing remove
        System.out.println("Removed value of key 'three': " + map.remove("three")); // Output: 3
        System.out.println("After removal, size: " + map.size()); // Output: 3
    }

    public Integer[] keySet() {
        return null;
    }
}
