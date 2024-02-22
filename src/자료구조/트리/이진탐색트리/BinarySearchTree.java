package 자료구조.트리.이진탐색트리;

class Node {
    private int key;
    private Node left, right;

    public Node(int item) {
        this.key = item;
        this.left = this.right = null;
    }

    // Getter and Setter methods for encapsulation
    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insert a node into the BST
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.getKey()) {
            root.setLeft(insertRecursive(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(insertRecursive(root.getRight(), key));
        }

        return root;
    }

    // Search for a node in the BST
    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.getKey()) {
            return true;
        }

        return key < root.getKey() ? searchRecursive(root.getLeft(), key) : searchRecursive(root.getRight(), key);
    }

    // Preorder Traversal
    public void preorderTraversal() {
        preorderTraversalRecursive(root);
    }

    private void preorderTraversalRecursive(Node root) {
        if (root != null) {
            System.out.print(root.getKey() + " ");
            preorderTraversalRecursive(root.getLeft());
            preorderTraversalRecursive(root.getRight());
        }
    }

    // Inorder Traversal
    public void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    private void inorderTraversalRecursive(Node root) {
        if (root != null) {
            inorderTraversalRecursive(root.getLeft());
            System.out.print(root.getKey() + " ");
            inorderTraversalRecursive(root.getRight());
        }
    }

    // Postorder Traversal
    public void postorderTraversal() {
        postorderTraversalRecursive(root);
    }

    private void postorderTraversalRecursive(Node root) {
        if (root != null) {
            postorderTraversalRecursive(root.getLeft());
            postorderTraversalRecursive(root.getRight());
            System.out.print(root.getKey() + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Search for nodes
        System.out.println("Search for 30: " + tree.search(30));
        System.out.println("Search for 45: " + tree.search(45));

        // Inorder traversal
        System.out.println("Inorder Traversal: ");
        tree.inorderTraversal();
    }
}
