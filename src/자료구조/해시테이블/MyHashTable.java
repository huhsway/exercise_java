package 자료구조.해시테이블;

public class MyHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int capacity;
    private int size;

    public MyHashTable() {
        this.capacity = DEFAULT_CAPACITY;
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
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

        /**
         * 로드 팩터 (load factor)를 확인하여 해시 테이블의 크기가 일정 수준을 초과하면 (size와 capacity의 비율이 0.7을 초과하면) 배열의 크기를 조절하기 위해 resize 메서드를 호출합니다. 해시 테이블의 크기가 커질 때 충돌 가능성을 줄이기 위해 배열을 확장하고 모든 기존 항목을 새 배열로 이동시킵니다.
         */

        if ((double) size / capacity > 0.7) {
            resize();
        }
    }

    public V get(K key) {
        int index = findKeyIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    public void remove(K key) {
        int index = findKeyIndex(key);
        if (index != -1) {
            keys[index] = null;
            values[index] = null;
            size--;
        }
    }

    public boolean containsKey(K key) {
        return findKeyIndex(key) != -1;
    }

    public int size() {
        return size;
    }

    private int customHashCode(K key) {
        int hash = 0;
        for (char c : key.toString().toCharArray()) {
            hash += (int) c;
        }
        return hash;
    }

    private int hash(K key) {
        return Math.abs(customHashCode(key) % capacity);
    }

    private int findKeyIndex(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return index;
            }
            index = (index + 1) % capacity;
        }
        return -1;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newKeys = new Object[newCapacity];
        Object[] newValues = new Object[newCapacity];

        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                K key = (K) keys[i];
                V value = (V) values[i];
                int index = hash(key);
                while (newKeys[index] != null) {
                    index = (index + 1) % newCapacity;
                }
                newKeys[index] = key;
                newValues[index] = value;
            }
        }

        keys = newKeys;
        values = newValues;
        capacity = newCapacity;
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

