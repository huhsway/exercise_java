package 자료구조.큐;

import java.util.LinkedList;

class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println(myQueue.dequeue()); // Output: 1
    }
}

