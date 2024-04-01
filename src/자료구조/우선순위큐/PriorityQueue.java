package 자료구조.우선순위큐;

import java.util.ArrayList;
import java.util.List;

/*
이 코드는 최대 힙(Max Heap)을 이용하여 우선순위 큐를 구현하였습니다. 최소 힙(Min Heap)을 원한다면 heapifyUp과 heapifyDown 메서드 내에서 부등호 방향을 반대로 바꿔주면 됩니다.
import java.util.Arrays;

class PriorityQueue<T extends Comparable<T>> {
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
        heap[size] = value;
        size++;
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
            if (((T) heap[parentIndex]).compareTo((T) heap[index]) >= 0) {
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
            int largestIndex = index;

            if (leftChildIndex < size && ((T) heap[leftChildIndex]).compareTo((T) heap[largestIndex]) > 0) {
                largestIndex = leftChildIndex;
            }
            if (rightChildIndex < size && ((T) heap[rightChildIndex]).compareTo((T) heap[largestIndex]) > 0) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex != index) {
                swap(index, largestIndex);
                index = largestIndex;
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
        heap = Arrays.copyOf(heap, newCapacity);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.push(3);
        priorityQueue.push(1);
        priorityQueue.push(4);
        priorityQueue.push(2);

        System.out.println(priorityQueue.pop()); // Output: 4 (가장 큰 요소를 꺼냄)
        System.out.println(priorityQueue.pop()); // Output: 3
        System.out.println(priorityQueue.pop()); // Output: 2
        System.out.println(priorityQueue.pop()); // Output: 1
    }
}

*/

// 최소힙
import java.util.Arrays;

class PriorityQueue<T extends Comparable<T>> {
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
        heap[size] = value;
        size++;
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
            if (((T) heap[parentIndex]).compareTo((T) heap[index]) <= 0) {
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
            int smallestIndex = index;

            if (leftChildIndex < size && ((T) heap[leftChildIndex]).compareTo((T) heap[smallestIndex]) < 0) {
                smallestIndex = leftChildIndex;
            }
            if (rightChildIndex < size && ((T) heap[rightChildIndex]).compareTo((T) heap[smallestIndex]) < 0) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex != index) {
                swap(index, smallestIndex);
                index = smallestIndex;
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
        heap = Arrays.copyOf(heap, newCapacity);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.push(3);
        priorityQueue.push(1);
        priorityQueue.push(4);
        priorityQueue.push(2);

        System.out.println(priorityQueue.pop()); // Output: 1 (가장 작은 요소를 꺼냄)
        System.out.println(priorityQueue.pop()); // Output: 2
        System.out.println(priorityQueue.pop()); // Output: 3
        System.out.println(priorityQueue.pop()); // Output: 4
    }
}
