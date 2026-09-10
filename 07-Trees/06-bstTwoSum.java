public class bstTwoSum {

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

    // Checks whether (target - currentValue) exists anywhere in the tree, excluding currentValue itself
    boolean valueExists(Node root, int target, int excludeValue) {
        if (root == null) return false;

        int required = target - excludeValue;
        if (root.data == required && root.data != excludeValue) {
            return true;
        }
        return required < root.data
                ? valueExists(root.left, target, excludeValue)
                : valueExists(root.right, target, excludeValue);
    }

    // Walks every node as a candidate "first number", checking if its complement exists elsewhere
    boolean twoSum(Node root, Node current, int target) {
        if (current == null) return false;
        if (valueExists(root, target, current.data)) return true;
        return twoSum(root, current.left, target) || twoSum(root, current.right, target);
    }

    public static void main(String[] args) {
        bstTwoSum tree = new bstTwoSum();
        int[] values = {10, 20, 40, 45, 60, 70, 75, 80};
        for (int v : values) tree.root = tree.insert(tree.root, v);

        System.out.println("Two nodes sum to 50?: " + tree.twoSum(tree.root, tree.root, 50));
        System.out.println("Two nodes sum to 1000?: " + tree.twoSum(tree.root, tree.root, 1000));
    }
}
