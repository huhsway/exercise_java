package 자료구조.큐;

public class MyQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private int front; // 큐의 맨 앞 인덱스
    private int rear;  // 큐의 맨 뒤 인덱스
    private int capacity; // 배열의 용량

    public MyQueue() {
        capacity = DEFAULT_CAPACITY;
        elements = new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void enqueue(T item) {
        if (isFull()) {
            increaseCapacity();
        }
        rear = (rear + 1) % capacity;
        elements[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어 있습니다.");
        }
        T item = (T) elements[front];
        elements[front] = null; // 메모리 누수 방지
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어 있습니다.");
        }
        return (T) elements[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private void increaseCapacity() {
        int newCapacity = capacity * 2;
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % capacity];
        }
        elements = newElements;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println("큐 크기: " + myQueue.size()); // 3
        System.out.println("가장 앞 요소: " + myQueue.peek()); // 1

        int dequeuedItem = myQueue.dequeue();
        System.out.println("디큐한 요소: " + dequeuedItem); // 1
        System.out.println("큐 크기 (디큐 후): " + myQueue.size()); // 2
    }
}
