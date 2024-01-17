package 자료구조.스택;

import java.util.*;

public class MyStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyStack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T item) {
        if (size == elements.length) {
            // 스택이 가득 차면 배열 크기를 늘린다.
            resize();
        }
        elements[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어 있습니다.");
        }
        T item = (T) elements[--size];
        elements[size] = null; // 메모리 누수 방지
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어 있습니다.");
        }
        return (T) elements[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("스택 크기: " + myStack.size()); // 3
        System.out.println("가장 위의 요소: " + myStack.peek()); // 3

        int poppedItem = myStack.pop();
        System.out.println("팝한 요소: " + poppedItem); // 3
        System.out.println("스택 크기 (팝 후): " + myStack.size()); // 2
    }
}
