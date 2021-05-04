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

    public Node search(String key) {
        if (root == null)
            return null;
        return searchRec(root, key);
    }

    private static Node searchRec(Node root, String key) {
        if (root == null)
            return null;
        if (root.getKey().equals(key))
            return root;
        if (root.getKey().compareTo(key) < 0)
            return searchRec(root.getRight(), key);
        return searchRec(root.getLeft(), key);
    }

    public void insert(String key) {
        if (root == null)
            root = new Node(key, null);
        else {
            Boolean heightIncrease = false;
            insertRec(root, key, heightIncrease);
        }
    }

    private static void insertRec(Node root, String key, Boolean heightIncrease) {
        if (root.getKey().compareTo(key) < 0) {
            if (root.getRight() != null) {
                insertRec(root.getRight(), key, heightIncrease);
                if (heightIncrease) {
                    if (root.getBalance() == -1) {
                        root.setBalance(0);
                        heightIncrease = false;
                    }
                    else if(root.getBalance() == 0) {
                        root.setBalance(1);
                    }
                    else {
                        if (root.getRight().getBalance() == 1) {
                            Node right = smallRotateLeft(root);
                            root.setBalance(-1);
                            right.setBalance(-1);
                            heightIncrease = false;
                        }
                    }
                }
            }
            else {
                Node node = new Node(key, root);
                if (root.getBalance() == 0)
                    heightIncrease = true;
                root.setBalance(root.getBalance() + 1);
            }
        }
        else {

        }
    }

    private static Node smallRotateLeft(Node root) {
        Node right = root.getRight();
        root.setRight(right.getLeft());
        if(root.getParent() != null && root.getParent().getRight() == root) {
            root.getParent().setRight(right);
        }
        else if (root.getParent() != null) {
            root.getParent().setLeft(right);
        }
        right.setLeft(root);

        return right;
    }

    private static Node smallRotateRight(Node root) {
        Node left = root.getLeft();
        root.setLeft(left.getRight());
        if(root.getParent() != null && root.getParent().getRight() == root) {
            root.getParent().setRight(left);
        }
        else if (root.getParent() != null) {
            root.getParent().setLeft(left);
        }
        left.setRight(root);

        return left;
    }

    private static Node bigRotateLeft(Node root) {
        smallRotateRight(root.getRight());
        return smallRotateLeft(root);
    }

    private static Node bigRotateRight(Node root) {
        smallRotateLeft(root.getLeft());
        return smallRotateRight(root);
    }

    public void delete(String key)
    {
        if (root == null)
            return;
        else {
            Boolean heightIncrease = false;
            insertDel(root, key, heightIncrease);
        }
    }


}
