public class bstFindSubtree {

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

    void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Finds the node with value == target and returns the subtree rooted there.
    // Returns null if not found.
    static Node find(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        return target < root.data ? find(root.left, target) : find(root.right, target);
    }

    public static void main(String[] args) {
        bstFindSubtree tree = new bstFindSubtree();
        int[] values = {50, 3, 30, 40, 55, 66, 73, 100};
        for (int v : values) tree.root = tree.insert(tree.root, v);

        System.out.print("Full tree in-order: ");
        tree.inOrder(tree.root);

        Node subtree = find(tree.root, 40);
        System.out.print("\nSubtree rooted at 40: ");
        tree.inOrder(subtree);
    }
}
