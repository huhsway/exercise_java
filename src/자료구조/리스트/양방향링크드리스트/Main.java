package 자료구조.리스트.양방향링크드리스트;

public class DoublyLinkedList<T> { // T는 제네릭 타입 파라미터

    private static class Node<T> { // Node도 제네릭으로 변경
        T value; // value 필드를 T 타입으로 변경
        Node<T> prev;
        Node<T> next;

        public Node(T value) { // 생성자의 매개변수도 T 타입으로 변경
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = new Node<T>(null); // head 노드의 value는 null로 설정 (T 타입)
        this.tail = this.head;
    }

    private Node<T> find(T item) { // 매개변수와 비교 대상의 타입을 T로 변경
        Node<T> currNode = this.head;
        while (currNode != null && !currNode.value.equals(item)) {
            currNode = currNode.next;
        }
        if (currNode == null) {
            throw new IllegalArgumentException("Item not found: " + item);
        }
        return currNode;
    }

    public void append(T value) { // 매개변수 타입을 T로 변경
        Node<T> newNode = new Node<T>(value);
        newNode.prev = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public void insert(T value, T item) { // 매개변수 타입을 T로 변경
        Node<T> currNode = this.find(item);
        Node<T> newNode = new Node<T>(value);
        newNode.next = currNode.next;
        newNode.prev = currNode;
        if (currNode.next != null) {
            currNode.next.prev = newNode;
        }
        currNode.next = newNode;
    }

    public void remove(T item) { // 매개변수 타입을 T로 변경
        Node<T> targetNode = this.find(item);
        if (targetNode == this.tail) {
            this.tail = targetNode.prev;
        }
        if (targetNode.prev != null) {
            targetNode.prev.next = targetNode.next;
        }
        if (targetNode.next != null) {
            targetNode.next.prev = targetNode.prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currNode = this.head.next;
        while (currNode != null) {
            sb.append(currNode.value).append(" ");
            currNode = currNode.next;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        try {
            DoublyLinkedList<String> linkedList = new DoublyLinkedList<>(); // 사용 예시: 문자열 타입의 리스트
            linkedList.insert("A", "head");
            linkedList.insert("B", "A");
            linkedList.insert("C", "B");
            linkedList.remove("B");
            linkedList.append("D");
            linkedList.append("E");

            System.out.println(linkedList.toString());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}