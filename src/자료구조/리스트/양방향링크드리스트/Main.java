package 자료구조.리스트.양방향링크드리스트;

public class Main {

    private static class Node {
        String value;
        Node prev;
        Node next;

        public Node(String value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

    }

    private static class DoublyLinkedList {
        private Node head;
        private Node tail;

        public DoublyLinkedList() {
            this.head = new Node("head");
            this.tail = this.head;
        }

        private Node find(String item) {
            Node currNode = this.head;
            while (currNode != null && !currNode.value.equals(item)) {
                currNode = currNode.next;
            }
            if (currNode == null) {
                throw new IllegalArgumentException("Item not found: " + item);
            }
            return currNode;
        }

        private void append(String value) {
            Node newNode = new Node(value);
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }

        private void insert(String value, String item) {
            Node currNode = this.find(item);
            Node newNode = new Node(value);
            newNode.next = currNode.next;
            newNode.prev = currNode;
            if (currNode.next != null) {
                currNode.next.prev = newNode;
            }
            currNode.next = newNode;
        }

        public void remove(String item) {
            Node targetNode = this.find(item);
            if (targetNode == this.tail) {
                this.tail = targetNode.prev;
            }
            targetNode.prev.next = targetNode.next;
            if (targetNode.next != null) {
                targetNode.next.prev = targetNode.prev;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node currNode = this.head.next;
            while (currNode != null) {
                sb.append(currNode.value).append(" ");
                currNode = currNode.next;
            }
            return sb.toString().trim();
        }
    }

    public static void main(String[] args) {
        try {
            DoublyLinkedList linkedList = new DoublyLinkedList();
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
