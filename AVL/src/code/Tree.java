package code;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public String getMin() {
        if (root == null)
            throw new RuntimeException("Min value isn't exist in empty tree");
        return getMinRec(root).getKey();
    }

    public String getMax() {
        if (root == null)
            throw new RuntimeException("Max value isn't exist in empty tree");
        return getMaxRec(root).getKey();
    }

    private static Node getMaxRec(Node root) {
        if (root.getRight() != null)
            return getMaxRec(root.getRight());
        return root;
    }

    private static Node getMinRec(Node root) {
        if (root.getLeft() != null)
            return getMinRec(root.getLeft());
        return root;
    }

    public static Node getSuccessor(Node item) {
        if(item == null)
            throw new IllegalArgumentException("Argument can't be null");
        if(item.getRight() != null)
            return getMinRec(item.getRight());

        Node cParent = item.getParent();
        Node current = item;
        while (cParent != null && cParent.getLeft() == current) {
            current = cParent;
            cParent = cParent.getParent();
        }
        return cParent;
    }

    public Node getPredecessor(Node item) {
        if(item == null)
            throw new IllegalArgumentException("Argument can't be null");
        if(item.getLeft() != null)
            return getMaxRec(item.getLeft());

        Node cParent = item.getParent();
        Node current = item;
        while (cParent != null && cParent.getRight() == current) {
            current = cParent;
            cParent = cParent.getParent();
        }
        return cParent;
    }
}
