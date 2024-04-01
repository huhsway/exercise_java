package 자료구조.셋;

public class MySet<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MySet() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean add(T item) {
        if (!contains(item)) {
            if (size == elements.length) {
                increaseCapacity();
            }
            elements[size++] = item;
            return true;
        }
        return false;
    }

    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public static void main(String[] args) {
        MySet<Integer> mySet = new MySet<>();

        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(1);

        System.out.println("Set 내의 요소 개수: " + mySet.size());
        System.out.println("Set이 비어있는가? " + mySet.isEmpty());
        System.out.println("Set 내의 요소: " + mySet);

        mySet.remove(2);
        System.out.println("Set 내의 요소 개수 (2 삭제 후): " + mySet.size());
        System.out.println("Set 내의 요소: " + mySet);
    }
}
