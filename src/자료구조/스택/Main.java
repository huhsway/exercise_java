package 자료구조.스택;

import java.util.ArrayList;
import java.util.List;

class Stack<T> {
    private List<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int lastIndex = list.size() - 1;
        T item = list.get(lastIndex);
        list.remove(lastIndex);
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
    }
}
