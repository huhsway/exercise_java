//package 자료구조.힙.최소힙;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Heap {
//    private List<Integer> heap;
//
//    public Heap() {
//        this.heap = new ArrayList<>();
//    }
//
//    private void swap(int a, int b) {
//        int temp = heap.get(a);
//        heap.set(a, heap.get(b));
//        heap.set(b, temp);
//    }
//
//    public int size() {
//        return heap.size();
//    }
//
//    public void print() {
//        System.out.println(heap);
//    }
//
//    public void push(int value) {
//        int idx, parent = 0;
//        heap.add(value);
//        idx = heap.size() - 1;
//        parent = (idx - 1) / 2;
//
//        while (parent >= 0 && heap.get(parent) > value) {
//            swap(idx, parent);
//            idx = parent;
//            parent = (idx - 1) / 2;
//        }
//        print();
//    }
//
//    public int pop() {
//        if (heap.isEmpty()) return -1;
//
//        int idx, value, lastIdx;
//        idx = value = lastIdx = 0;
//        lastIdx = heap.size() - 1;
//        value = heap.remove(lastIdx);
//
//        while (idx < lastIdx) {
//            int leftChildIdx = idx * 2 + 1;
//            int rightChildIdx = idx * 2 + 2;
//
//            if (lastIdx < leftChildIdx) {
//                break;
//            } else if (lastIdx < rightChildIdx) {
//                if (heap.get(idx) > heap.get(leftChildIdx)) {
//                    swap(idx, leftChildIdx);
//                    idx = leftChildIdx;
//                } else {
//                    break;
//                }
//            } else {
//                if (heap.get(idx) > heap.get(leftChildIdx) && heap.get(idx) > heap.get(rightChildIdx)) {
//                    if (heap.get(leftChildIdx) < heap.get(rightChildIdx)) {
//                        swap(idx, leftChildIdx);
//                        idx = leftChildIdx;
//                    } else {
//                        swap(idx, rightChildIdx);
//                        idx = rightChildIdx;
//                    }
//                } else if (heap.get(idx) > heap.get(leftChildIdx)) {
//                    swap(idx, leftChildIdx);
//                    idx = leftChildIdx;
//                } else if (heap.get(idx) > heap.get(rightChildIdx)) {
//                    swap(idx, rightChildIdx);
//                    idx = rightChildIdx;
//                } else {
//                    break;
//                }
//            }
//        }
//        return value;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Heap heap = new Heap();
//        heap.push(3);
//        heap.push(1);
//        heap.push(4);
//        heap.push(2);
//
//        System.out.println(heap.pop()); // Output: 4
//        System.out.println(heap.pop()); // Output: 3
//        System.out.println(heap.pop()); // Output: 2
//        System.out.println(heap.pop()); // Output: 1
//    }
//}
//
