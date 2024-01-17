package 자료구조.해시테이블;

import java.util.LinkedList;

public class MyHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] table;
    private int capacity;
    private int size;

    public MyHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new Object[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry>();
        }

        LinkedList<Entry> bucket = (LinkedList<Entry>) table[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
        size++;

        // 로드 팩터 (load factor)를 확인하여 배열 크기를 조절
        if ((double) size / capacity > 0.7) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry> bucket = (LinkedList<Entry>) table[index];
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry> bucket = (LinkedList<Entry>) table[index];
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key.equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newTable = new Object[newCapacity];

        for (Object bucket : table) {
            if (bucket != null) {
                LinkedList<Entry> entries = (LinkedList<Entry>) bucket;
                for (Entry entry : entries) {
                    int index = hash(entry.key);
                    if (newTable[index] == null) {
                        newTable[index] = new LinkedList<Entry>();
                    }
                    LinkedList<Entry> newBucket = (LinkedList<Entry>) newTable[index];
                    newBucket.add(entry);
                }
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    private class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>();

        myHashTable.put("one", 1);
        myHashTable.put("two", 2);
        myHashTable.put("three", 3);

        System.out.println("Size: " + myHashTable.size()); // 3
        System.out.println("Value for 'two': " + myHashTable.get("two")); // 2

        myHashTable.remove("one");
        System.out.println("Size (after removing 'one'): " + myHashTable.size()); // 2
        System.out.println("Contains key 'one'? " + myHashTable.containsKey("one")); // false
    }
}
