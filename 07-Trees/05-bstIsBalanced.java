public class bstIsBalanced {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    Node root;

    Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    // Returns height normally, but returns -1 the instant an imbalance is found anywhere below -
    // this lets one traversal both compute height AND detect imbalance, instead of two separate passes.
    int height(Node node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1; // imbalance already found deeper down - bail out early

        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // imbalance at this node

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        bstIsBalanced tree = new bstIsBalanced();
        int[] values = {10, 30, 20, 50, 60, 22, 25, 90};
        for (int v : values) tree.root = tree.insert(tree.root, v);

        System.out.println("Is balanced?: " + tree.isBalanced(tree.root));
    }
}
