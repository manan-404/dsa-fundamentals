public class countNodesCompleteTree {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    Node root;

    private int leftHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int rightHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    // Exploits the "complete tree" guarantee: if left and right height match, the subtree
    // is a PERFECT tree, so its node count is known instantly (2^h - 1) - no need to visit
    // every node. Runs in O(log^2 n), better than the O(n) a naive full traversal would need.
    int countNodes(Node node) {
        if (node == null) return 0;

        int leftH = leftHeight(node);
        int rightH = rightHeight(node);

        if (leftH == rightH) {
            return (int) Math.pow(2, leftH) - 1;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        countNodesCompleteTree tree = new countNodesCompleteTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);

        System.out.println("Number of nodes = " + tree.countNodes(tree.root));
    }
}
