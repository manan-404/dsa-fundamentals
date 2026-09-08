import java.util.LinkedList;
import java.util.Queue;

public class binaryTreeBasicTraversals {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    Node root;

    // Depth-first: root -> left -> right
    void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Depth-first: left -> root -> right (gives sorted order ONLY if tree is a BST)
    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Depth-first: left -> right -> root
    void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Breadth-first: level by level, using a queue
    void levelOrder(Node start) {
        if (start == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        binaryTreeBasicTraversals tree = new binaryTreeBasicTraversals();

        // Manually building this shape (not BST-ordered on purpose):
        //          1
        //        /   \
        //       2     3
        //      / \     \
        //     4   5     6
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        System.out.print("Pre-order:   ");
        tree.preOrder(tree.root);
        System.out.print("\nIn-order:    ");
        tree.inOrder(tree.root);
        System.out.print("\nPost-order:  ");
        tree.postOrder(tree.root);
        System.out.print("\nLevel-order: ");
        tree.levelOrder(tree.root);

        System.out.println("\nHeight: " + tree.height(tree.root));
        System.out.println("Total nodes: " + tree.countNodes(tree.root));
    }
}
