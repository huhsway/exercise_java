package 자료구조.우선순위큐;

public class PriorityQueue<T extends Comparable<T>> {
    private Object[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public PriorityQueue() {
        this.heap = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null; // Return null if PriorityQueue is empty
        }
        return (T) heap[0];
    }

    public void push(T value) {
        if (size == heap.length) {
            increaseCapacity();
        }
        heap[size++] = value;
        heapifyUp();
    }

    public T pop() {
        if (isEmpty()) {
            return null; // Return null if PriorityQueue is empty
        }

        T poppedValue = (T) heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null; // Clearing the reference
        size--;
        heapifyDown();
        return poppedValue;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (((T) heap[parentIndex]).compareTo((T) heap[index]) >= 0) { // 부모 >= 자식
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int newIndex = index;

            if (leftChildIndex < size && ((T) heap[leftChildIndex]).compareTo((T) heap[newIndex]) > 0) {
                newIndex = leftChildIndex;
            }
            if (rightChildIndex < size && ((T) heap[rightChildIndex]).compareTo((T) heap[newIndex]) > 0) {
                newIndex = rightChildIndex;
            }

            if (newIndex != index) {
                swap(index, newIndex);
                index = newIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void increaseCapacity() {
        int newCapacity = heap.length * 2;
        Object[] newHeap = new Object[newCapacity];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }
}

// 최소힙
//public class PriorityQueue<T extends Comparable<T>> {
//    private Object[] heap;
//    private int size;
//    private static final int DEFAULT_CAPACITY = 10;
//
//    public PriorityQueue() {
//        this.heap = new Object[DEFAULT_CAPACITY];
//        this.size = 0;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public T peek() {
//        if (isEmpty()) {
//            return null; // Return null if PriorityQueue is empty
//        }
//        return (T) heap[0];
//    }
//
//    public void push(T value) {
//        if (size == heap.length) {
//            increaseCapacity();
//        }
//        heap[size++] = value;
//        heapifyUp();
//    }
//
//    public T pop() {
//        if (isEmpty()) {
//            return null; // Return null if PriorityQueue is empty
//        }
//
//        T poppedValue = (T) heap[0];
//        heap[0] = heap[size - 1];
//        heap[size - 1] = null; // Clearing the reference
//        size--;
//        heapifyDown();
//        return poppedValue;
//    }
//
//    private void heapifyUp() {
//        int index = size - 1;
//        while (index > 0) {
//            int parentIndex = (index - 1) / 2;
//            if (((T) heap[parentIndex]).compareTo((T) heap[index]) <= 0) {
//                break;
//            }
//            swap(index, parentIndex);
//            index = parentIndex;
//        }
//    }
//
//    private void heapifyDown() {
//        int index = 0;
//
//        while (true) {
//            int leftChildIndex = 2 * index + 1;
//            int rightChildIndex = 2 * index + 2;
//            int newIndex = index;
//
//            if (leftChildIndex < size && ((T) heap[leftChildIndex]).compareTo((T) heap[newIndex]) < 0) {
//                newIndex = leftChildIndex;
//            }
//            if (rightChildIndex < size && ((T) heap[rightChildIndex]).compareTo((T) heap[newIndex]) < 0) {
//                newIndex = rightChildIndex;
//            }
//
//            if (newIndex != index) {
//                swap(index, newIndex);
//                index = newIndex;
//            } else {
//                break;
//            }
//        }
//    }
//
//    private void swap(int i, int j) {
//        Object temp = heap[i];
//        heap[i] = heap[j];
//        heap[j] = temp;
//    }
//
//    private void increaseCapacity() {
//        int newCapacity = heap.length * 2;
//        Object[] newHeap = new Object[newCapacity];
//        for (int i = 0; i < heap.length; i++) {
//            newHeap[i] = heap[i];
//        }
//        heap = newHeap;
//    }
//}
