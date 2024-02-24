package 자료구조.트리.이진탐색트리;

class BinarySearchTree {
    int value;
    BinarySearchTree left;
    BinarySearchTree right;

    BinarySearchTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    void insert(int value) {
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

    boolean contains(int value) {
        if (value == this.value) {
            return true;
        } else if (value < this.value && this.left != null) {
            return this.left.contains(value);
        } else if (value > this.value && this.right != null) {
            return this.right.contains(value);
        }
        return false;
    }

    void preorder() {
        System.out.print(this.value + " ");
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }

    void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.inorder();
        }
    }

    void postorder() {
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

        System.out.println(rootNode.left.right.value); // 8
        System.out.println(rootNode.right.left.value); // 11

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
