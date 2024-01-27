package 자료구조.해시테이블;

import java.util.*;
public class MyHashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int capacity;
    private int size;

    public MyHashTable() {
        capacity = DEFAULT_CAPACITY;
        keys = new Object[capacity];
        values = new Object[capacity];
        size = 0;
    }

    private int getHash(K key) {
        int hash = 0;
        char[] arr = key.toString().toCharArray();
        for (char c : arr) {
            hash += (int) c;
        }
        return hash % capacity;
    }

    public void put(K key, V value) {
        int index = getHash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
            index = (index + 1) % capacity;
        }

        keys[index] = key;
        values[index] = value;
        size++;

        if ((double) size / capacity > 0.7) {
            resize();
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newKeys = new Object[newCapacity];
        Object[] newValues = new Object[newCapacity];

        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                K currentKey = (K) keys[i];
                V currentValue = (V) values[i];
                int index = getHash(currentKey);
                while (newKeys[index] != null) {
                    index = (index + 1) % newCapacity;
                }
                newKeys[index] = currentKey;
                newValues[index] = currentValue;
            }
        }

        keys = newKeys;
        values = newValues;
        capacity = newCapacity;
    }

    private int findByIndex(K key) {
        int index = getHash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return index;
            }
            index = (index + 1) % capacity;
        }
        return -1;
    }

    public V get(K key) {
        int index = findByIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    public void remove(K key) {
        int index = findByIndex(key);
        if (index != -1) {
            keys[index] = null;
            values[index] = null;
            size--;
        }
    }

    public boolean containsKey(K key) {
        return findByIndex(key) != -1;
    }

    public int size() {
        return size;
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