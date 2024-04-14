package 자료구조.해시테이블;

/*
멤버변수 DEFAULT_CAPACITY, keys, values, capacity, size
멤버함수 getHash, resize, put, findByHash, get, remove, containsKey, size
 */
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
        // hash = key.toString().chars().sum();
        char[] arr = key.toString().toCharArray();
        for (char c : arr) {
            hash += (int) c;
        }
        return hash % capacity;
    }

    private void resize() {
        int oldCapacity = capacity; // 기존 용량을 저장
        capacity *= 2; // 용량 2배 증가
        Object[] newKeys = new Object[capacity];
        Object[] newValues = new Object[capacity];

        for (int i = 0; i < oldCapacity; i++) {
            if (keys[i] != null) {
                K currentKey = (K) keys[i];
                V currentValue = (V) values[i];
                int hash = getHash(currentKey);
                while (newKeys[hash] != null) {
                    hash = (hash + 1) % capacity;
                }
                newKeys[hash] = currentKey;
                newValues[hash] = currentValue;
            }
        }

        keys = newKeys;
        values = newValues;
    }

    public void put(K key, V value) {
        int hash = getHash(key);
        while (keys[hash] != null) {
            if (keys[hash].equals(key)) {
                values[hash] = value;
                return;
            }
            hash = (hash + 1) % capacity;
        }

        keys[hash] = key;
        values[hash] = value;
        size++;

        if ((double) size / capacity > 0.7) {
            resize();
        }
    }

    private int findByHash(K key) {
        int hash = getHash(key);
        while (keys[hash] != null) {
            if (keys[hash].equals(key)) {
                return hash;
            }
            hash = (hash + 1) % capacity;
        }
        return -1;
    }

    public V get(K key) {
        int hash = findByHash(key);
        if (hash != -1) {
            return (V) values[hash];
        }
        return null;
    }

    public void remove(K key) {
        int hash = findByHash(key);
        if (hash != -1) {
            keys[hash] = null;
            values[hash] = null;
            size--;
        }
    }

    public boolean containsKey(K key) {
        return findByHash(key) != -1;
    }

    public static void main(String[] args) {
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>();

        myHashTable.put("one", 1);
        myHashTable.put("two", 2);
        myHashTable.put("three", 3);

        System.out.println("Value for 'two': " + myHashTable.get("two")); // 2

        myHashTable.remove("one");
        System.out.println("Contains key 'one'? " + myHashTable.containsKey("one")); // false
    }

}