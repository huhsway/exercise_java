package 자료구조.리스트.링크드리스트;

// 단일 연결 리스트
public class Main {

    private static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
            this.next = null;
        }

    }

    private static class LinkedList {
        private Node head;
        public LinkedList() {
            this.head = new Node("head");
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

        private Node findPrevious(String item) {
            Node currNode = this.head;
            while (currNode.next != null && !currNode.next.value.equals(item)) {
                currNode = currNode.next;
            }
            if (currNode.next == null) {
                throw new IllegalArgumentException("Previous item not found: " + item);
            }
            return currNode;
        }

        private void append(String value) {
            Node newNode = new Node(value);
            Node currNode = this.head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }

        private void insert(String value, String item) {
            Node currNode = this.find(item);
            Node newNode = new Node(value);
            newNode.next = currNode.next;
            currNode.next = newNode;
        }

        public void remove(String item) {
            Node preNode = this.findPrevious(item);
            preNode.next = preNode.next.next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node currNode = this.head;
            while (currNode.next != null) {
                sb.append(currNode.next.value).append(" ");
                currNode = currNode.next;
            }
            return sb.toString().trim();
        }

    }


    public static void main(String[] args) {
        try {
            LinkedList linkedList = new LinkedList();
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



