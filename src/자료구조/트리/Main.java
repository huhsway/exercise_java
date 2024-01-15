package 자료구조.트리;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void insertNode(int value) {
        TreeNode childNode = new TreeNode(value);
        children.add(childNode);
    }

    public boolean contains(int value) {
        if (this.value == value) {
            return true;
        }
        for (TreeNode childNode : children) {
            if (childNode.contains(value)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.insertNode(2);
        node1.children.get(0).insertNode(3);

        System.out.println(node1.contains(3));
    }
}

