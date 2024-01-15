//package 자료구조.힙.최대힙;
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
//    public void push(int value) {
//        // 맨 뒤에 추가, Max Heap이므로 부모와 비교해서 큰 값을 부모와 swap
//        heap.add(value);
//        int idx = heap.size() - 1;
//        int parent = (idx - 1) / 2;
//
//        while (parent >= 0 && heap.get(parent) < value) {
//            swap(parent, idx);
//            idx = parent;
//            parent = (idx - 1) / 2;
//        }
//
//        print();
//    }
//
//    public int pop() {
//        if (heap.isEmpty()) return -1;
//
//        int lastIdx = heap.size() - 1;
//        swap(0, lastIdx);
//        int value = heap.remove(lastIdx);
//
//        int idx = 0;
//        while (idx < lastIdx) {
//            int leftChildIdx = idx * 2 + 1;
//            int rightChildIdx = idx * 2 + 2;
//
//            if (leftChildIdx >= lastIdx) {
//                break;
//            } else if (rightChildIdx >= lastIdx) {
//                if (heap.get(idx) < heap.get(leftChildIdx)) {
//                    swap(idx, leftChildIdx);
//                    idx = leftChildIdx;
//                } else {
//                    break;
//                }
//            } else {
//                if (heap.get(leftChildIdx) > heap.get(idx) && heap.get(rightChildIdx) > heap.get(idx)) {
//                    if (heap.get(leftChildIdx) > heap.get(rightChildIdx)) {
//                        swap(idx, leftChildIdx);
//                        idx = leftChildIdx;
//                    } else {
//                        swap(idx, rightChildIdx);
//                        idx = rightChildIdx;
//                    }
//                } else if (heap.get(leftChildIdx) > heap.get(idx)) {
//                    swap(leftChildIdx, idx);
//                    idx = leftChildIdx;
//                } else if (heap.get(rightChildIdx) > heap.get(idx)) {
//                    swap(rightChildIdx, idx);
//                    idx = rightChildIdx;
//                } else {
//                    break;
//                }
//            }
//        }
//        return value;
//    }
//
//    public void print() {
//        System.out.println(heap);
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
