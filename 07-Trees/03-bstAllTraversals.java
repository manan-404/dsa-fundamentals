public class bstAllTraversals {

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

    void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        bstAllTraversals tree = new bstAllTraversals();
        tree.root = tree.insert(tree.root, 100);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 300);
        tree.root = tree.insert(tree.root, 60);

        System.out.print("Pre-order:  ");
        tree.preOrder(tree.root);
        System.out.print("\nIn-order:   ");
        tree.inOrder(tree.root);
        System.out.print("\nPost-order: ");
        tree.postOrder(tree.root);
    }
}
