package 자료구조.셋;

import java.util.Arrays;

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
                // 배열 크기가 부족하면 확장
                elements = Arrays.copyOf(elements, size * 2);
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
                // 해당 요소를 찾으면 삭제하고 뒤의 요소들을 앞으로 이동
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null; // 마지막 요소를 null로 설정
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

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }

    public static void main(String[] args) {
        MySet<Integer> mySet = new MySet<>();

        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(1); // 중복된 요소를 추가하려고 하지만 추가되지 않음

        System.out.println("Set 내의 요소 개수: " + mySet.size()); // 3
        System.out.println("Set이 비어있는가? " + mySet.isEmpty()); // false
        System.out.println("Set 내의 요소: " + mySet); // [1, 2, 3]

        mySet.remove(2);
        System.out.println("Set 내의 요소 개수 (2 삭제 후): " + mySet.size()); // 2
        System.out.println("Set 내의 요소: " + mySet); // [1, 3]
    }
}
