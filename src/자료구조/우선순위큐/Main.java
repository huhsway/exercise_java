package 자료구조.우선순위큐;

import java.util.ArrayList;
import java.util.List;

/*
이 코드는 최대 힙(Max Heap)을 이용하여 우선순위 큐를 구현하였습니다. push 메서드로 요소를 추가하고, pop 메서드로 최대 우선순위 요소를 꺼낼 수 있습니다. 최소 힙(Min Heap)을 원한다면 heapifyUp과 heapifyDown 메서드 내에서 부등호 방향을 반대로 바꿔주면 됩니다.
private void heapifyUp() {
    int index = size() - 1;
    while (index > 0) {
        int parentIndex = (index - 1) / 2;
        if (heap.get(parentIndex).compareTo(heap.get(index)) <= 0) { // 부등호 방향 변경
            break;
        }
        swap(index, parentIndex);
        index = parentIndex;
    }
}

private void heapifyDown() {
    int index = 0;
    int lastIndex = size() - 1;

    while (true) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex <= lastIndex && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) { // 부등호 방향 변경
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex <= lastIndex && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) { // 부등호 방향 변경
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
이렇게 수정하면 최소 힙이 됩니다.
*/

class PriorityQueue<T extends Comparable<T>> {
    private List<T> heap;

    public PriorityQueue() {
        this.heap = new ArrayList<>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        return heap.get(0);
    }

    public void push(T value) {
        heap.add(value);
        heapifyUp();
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }

        T poppedValue = heap.get(0);
        T bottomValue = heap.remove(size() - 1);

        if (!isEmpty()) {
            heap.set(0, bottomValue);
            heapifyDown();
        }

        return poppedValue;
    }

    private void heapifyUp() {
        int index = size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex).compareTo(heap.get(index)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown() {
        int index = 0;
        int lastIndex = size() - 1;

        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largestIndex = index;

            if (leftChildIndex <= lastIndex && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
                largestIndex = leftChildIndex;
            }
            if (rightChildIndex <= lastIndex && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
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
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

public class Main {
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
