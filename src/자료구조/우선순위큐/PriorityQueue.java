package 자료구조.우선순위큐;

public class PriorityQueue<T extends Comparable<T>> {
    private Object[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public PriorityQueue() {
        this.heap = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (((T) heap[parentIndex]).compareTo((T) heap[index]) < 0) { // < 0 최대 힙, > 0 최소 힙
                // swap
                Object temp = heap[index];
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temp;

                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int newIndex = 0;
        while (true) {
            int leftChildIndex = 2 * newIndex + 1;
            int rightChildIndex = 2 * newIndex + 2;
            int index = newIndex;

            if (leftChildIndex < size && ((T) heap[leftChildIndex]).compareTo((T) heap[index]) > 0) { // > 0 최대 힙, < 0 최소 힙
                index = leftChildIndex;
            }
            if (rightChildIndex < size && ((T) heap[rightChildIndex]).compareTo((T) heap[index]) > 0) { // > 0 최대 힙, < 0 최소 힙
                index = rightChildIndex;
            }

            // 현재 노드가 자식 노드와 바꿔야 할 경우에만 교체
            if (index != newIndex) {
                // swap
                Object temp = heap[newIndex];
                heap[newIndex] = heap[index];
                heap[index] = temp;

                newIndex = index;
            } else {
                break;
            }
        }
    }

    public T peek() {
        if (size == 0) {
            return null; // Return null if PriorityQueue is empty
        }
        return (T) heap[0];
    }

    public void push(T value) {
        if (size == heap.length) {
            int newCapacity = heap.length * 2;
            Object[] newHeap = new Object[newCapacity];
            for (int i = 0; i < heap.length; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }
        heap[size++] = value;
        heapifyUp();
    }

    public T pop() {
        if (size == 0) {
            return null; // Return null if PriorityQueue is empty
        }

        T poppedValue = (T) heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null; // Clearing the reference
        size--;
        heapifyDown();
        return poppedValue;
    }
}
