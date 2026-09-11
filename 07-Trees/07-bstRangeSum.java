public class bstRangeSum {

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

    // Sums all node values within [low, high], pruning branches that can't possibly be in range
    int rangeSum(Node root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (root.data >= low && root.data <= high) {
            sum += root.data;
        }
        if (root.data > low) {
            sum += rangeSum(root.left, low, high); // left subtree could still hold values >= low
        }
        if (root.data < high) {
            sum += rangeSum(root.right, low, high); // right subtree could still hold values <= high
        }
        return sum;
    }

    public static void main(String[] args) {
        bstRangeSum tree = new bstRangeSum();
        int[] values = {10, 100, 30, 150, 0};
        for (int v : values) tree.root = tree.insert(tree.root, v);

        int low = 10, high = 100;
        System.out.println("Sum of nodes in [" + low + ", " + high + "] = " +
                tree.rangeSum(tree.root, low, high));
    }
}
