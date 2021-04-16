package code;
public class BinarySearchTree {
    private Node root = null;

    public boolean insert(Integer key, String value) {
        if (root == null) {
            root = new Node(key, value);
            return true;
        } else {
            return insert(root, key, value);
        }
    }

    
    private boolean insert(Node node, Integer key, String value) {
        if (key.equals(node.key)) {
            return false;
        } else if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key, value);
                return true;
            } else {
                return insert(node.left, key, value);
            }
        } else if (key > node.key) {
            if (node.right == null) {
                node.right = new Node(key, value);
                return true;
            } else {
                return insert(node.right, key, value);
            }
        }
        return false;
    }
}

