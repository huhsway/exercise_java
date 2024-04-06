package 자료구조.우선순위큐;

//public class Main {
//    public static void main(String[] args) {
//        // MyClass 인스턴스를 저장하는 최대힙 PriorityQueue 생성
//        PriorityQueue<MyClass> maxHeap = new PriorityQueue<>();
//
//        // PriorityQueue에 MyClass 인스턴스 추가
//        maxHeap.push(new MyClass(10));
//        maxHeap.push(new MyClass(5));
//        maxHeap.push(new MyClass(20));
//        maxHeap.push(new MyClass(1));
//
//        System.out.println("PriorityQueue에서 요소를 제거하며 출력:");
//        while (maxHeap.peek() != null) {
//            MyClass removed = maxHeap.pop();
//            System.out.println(removed.getValue());
//        }
//    }
//}

// // 사용자 정의 클래스 MyClass
//class MyClass implements Comparable<MyClass> {
//    private int value; // 비교를 위한 값
//
//    public MyClass(int value) {
//        this.value = value;
//    }
//
//    public int getValue() {
//        return this.value;
//    }
//
//    // MyClass 객체들을 비교하기 위한 compareTo 메소드
//    @Override
//    public int compareTo(MyClass other) {
//        // 최대힙을 위해 비교 방식을 반대로 함
//        return other.value - this.value;
//    }
//}

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
