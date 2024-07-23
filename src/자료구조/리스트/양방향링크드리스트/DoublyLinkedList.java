package 자료구조.리스트.양방향링크드리스트;

public class DoublyLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> prev, next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head, tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    private Node<T> find(T item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null.");
        Node<T> currNode = head;
        while (currNode != null) {
            if (currNode.value.equals(item)) return currNode;
            currNode = currNode.next;
        }
        throw new IllegalArgumentException("Item not found: " + item);
    }

    public void insert(T value, T item) {
        Node<T> currNode = find(item);
        Node<T> newNode = new Node<>(value);
        newNode.next = currNode.next;
        newNode.prev = currNode;
        if (currNode.next != null) {
            currNode.next.prev = newNode;
        } else {
            tail = newNode;
        }
        currNode.next = newNode;
    }

    public void remove(T item) {
        Node<T> targetNode = find(item);
        if (targetNode.prev != null) {
            targetNode.prev.next = targetNode.next;
        } else {
            head = targetNode.next;
        }
        if (targetNode.next != null) {
            targetNode.next.prev = targetNode.prev;
        } else {
            tail = targetNode.prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currNode = head;
        while (currNode != null) {
            sb.append(currNode.value);
            if (currNode.next != null) sb.append(" -> ");
            currNode = currNode.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
            linkedList.append("A");
            linkedList.insert("B", "A");
            linkedList.insert("C", "B");
            linkedList.remove("B");
            linkedList.append("D");
            linkedList.append("E");

            System.out.println(linkedList);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
