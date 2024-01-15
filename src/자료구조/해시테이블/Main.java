import java.util.LinkedList;

class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index].removeIf(entry -> entry.key.equals(key));
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashtable = new HashTable<>();
        hashtable.put("one", 1);
        hashtable.put("two", 2);
        hashtable.put("three", 3);

        System.out.println(hashtable.get("one")); // Output: 1
        System.out.println(hashtable.get("two")); // Output: 2

        hashtable.remove("two");
        System.out.println(hashtable.get("two")); // Output: null

        System.out.println(hashtable.size()); // Output: 2
        System.out.println(hashtable.isEmpty()); // Output: false
    }
}
