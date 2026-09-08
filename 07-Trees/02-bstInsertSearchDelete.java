public class bstInsertSearchDelete {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    Node root;

    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    boolean search(Node root, int data) {
        if (root == null) return false;
        if (data == root.data) return true;
        return data < root.data ? search(root.left, data) : search(root.right, data);
    }

    // Finds the largest value in a subtree (used to find the in-order predecessor on delete)
    Node maximum(Node root) {
        if (root.right == null) return root;
        return maximum(root.right);
    }

    Node removeMax(Node root) {
        if (root.right == null) return root.left;
        root.right = removeMax(root.right);
        return root;
    }

    Node delete(Node root, int target) {
        if (root == null) return null;

        if (target < root.data) {
            root.left = delete(root.left, target);
        } else if (target > root.data) {
            root.right = delete(root.right, target);
        } else {
            // found the node to delete
            if (root.left == null && root.right == null) return null;      // no children
            if (root.left == null) return root.right;                     // one child (right)
            if (root.right == null) return root.left;                    // one child (left)

            // two children: replace with in-order predecessor (max of left subtree)
            Node predecessor = maximum(root.left);
            root.data = predecessor.data;
            root.left = removeMax(root.left);
        }
        return root;
    }

    boolean isEmpty() {
        return root == null;
    }

    void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        bstInsertSearchDelete tree = new bstInsertSearchDelete();
        System.out.println("Is empty? " + tree.isEmpty());

        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 100);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 0);

        System.out.print("In-order: ");
        tree.inOrder(tree.root);

        System.out.println("\nSearch 40: " + tree.search(tree.root, 40));
        System.out.println("Search 999: " + tree.search(tree.root, 999));
        System.out.println("Max value: " + tree.maximum(tree.root).data);

        tree.root = tree.delete(tree.root, 4);
        System.out.print("After deleting 4: ");
        tree.inOrder(tree.root);
    }
}
