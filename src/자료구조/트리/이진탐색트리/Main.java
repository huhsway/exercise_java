package 자료구조.트리.이진탐색트리;

public class Main {
    private static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private static class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            root = null;
        }

        // 이진 탐색 트리에 노드를 삽입하는 메서드
        public void insert(int key) {
            root = insertRec(root, key);
        }

        private Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }

            return root;
        }

        // 이진 탐색 트리에서 노드를 검색하는 메서드
        public boolean search(int key) {
            return searchRec(root, key);
        }

        private boolean searchRec(Node root, int key) {
            if (root == null) {
                return false;
            }

            if (root.key == key) {
                return true;
            }

            if (key < root.key) {
                return searchRec(root.left, key);
            }

            return searchRec(root.right, key);
        }

        // 이진 탐색 트리를 전위 순회하여 노드를 출력하는 메서드
        public void preorderTraversal() {
            preorderTraversalRec(root);
        }

        private void preorderTraversalRec(Node root) {
            if (root != null) {
                System.out.print(root.key + " ");
                preorderTraversalRec(root.left);
                preorderTraversalRec(root.right);
            }
        }

        // 이진 탐색 트리를 중위 순회하여 노드를 출력하는 메서드
        public void inorderTraversal() {
            inorderTraversalRec(root);
        }

        private void inorderTraversalRec(Node root) {
            if (root != null) {
                inorderTraversalRec(root.left);
                System.out.print(root.key + " ");
                inorderTraversalRec(root.right);
            }
        }

        // 이진 탐색 트리를 후위 순회하여 노드를 출력하는 메서드
        public void postorderTraversal() {
            postorderTraversalRec(root);
        }

        private void postorderTraversalRec(Node root) {
            if (root != null) {
                postorderTraversalRec(root.left);
                postorderTraversalRec(root.right);
                System.out.print(root.key + " ");
            }
        }

        public static void main(String[] args) {
            BinarySearchTree tree = new BinarySearchTree();

            // 노드 삽입
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            // 노드 검색
            System.out.println("30을 검색 결과: " + tree.search(30));
            System.out.println("45을 검색 결과: " + tree.search(45));

            // 중위 순회하여 노드 출력
            System.out.println("중위 순회 결과: ");
            tree.inorderTraversal();
        }
    }
}
