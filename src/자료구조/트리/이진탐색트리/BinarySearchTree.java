package 자료구조.트리.이진탐색트리;

public class BinarySearchTree {
    private int value;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public int getValue() {
        return this.value;
    }

    public BinarySearchTree getLeft() {
        return this.left;
    }

    public BinarySearchTree getRight() {
        return this.right;
    }

    public BinarySearchTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void insert(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new BinarySearchTree(value);
            } else {
                this.left.insert(value);
            }
        } else if (value > this.value) {
            if (this.right == null) {
                this.right = new BinarySearchTree(value);
            } else {
                this.right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == this.value) {
            return true;
        } else if (value < this.value && this.left != null) {
            return this.left.contains(value);
        } else if (value > this.value && this.right != null) {
            return this.right.contains(value);
        }
        return false;
    }

    public void preorder() {
        System.out.print(this.value + " ");
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }

    public void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.inorder();
        }
    }

    public void postorder() {
        if (this.left != null) {
            this.left.postorder();
        }
        if (this.right != null) {
            this.right.postorder();
        }
        System.out.print(this.value + " ");
    }
}

class Main {
    public static void main(String[] args) {
        BinarySearchTree rootNode = new BinarySearchTree(10);
        rootNode.insert(7);
        rootNode.insert(8);
        rootNode.insert(12);
        rootNode.insert(11);

        System.out.println(rootNode.getLeft().getRight().getValue()); // 8
        System.out.println(rootNode.getRight().getLeft().getValue()); // 11

        System.out.print("Preorder traversal: ");
        rootNode.preorder();
        System.out.println();

        System.out.print("Inorder traversal: ");
        rootNode.inorder();
        System.out.println();

        System.out.print("Postorder traversal: ");
        rootNode.postorder();
        System.out.println();
    }
}
