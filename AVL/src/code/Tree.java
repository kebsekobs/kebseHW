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

    public int height(){
        if(root == null){return -1;}
        else{return root.getHeight();}
    }
    private int height(Node node){
        if(node == null){return -1;}
        else{return node.getHeight();}
    }

    private void updateHeight(Node node){
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return height(node.getRight()) - height(node.getLeft());
        }
    }

    private Node rebalance(Node node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.getRight().getRight()) > height(node.getRight().getLeft())) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (height(node.getLeft().getLeft()) > height(node.getLeft().getRight())) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        return node;
    }

    public void insert(String key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node node, String key) {
        if(node == null){return new Node(key);}
        else if (node.getKey().compareTo(key) > 0) {
            node.setLeft(insertRec(node.getLeft(), key));
        } else if (node.getKey().compareTo(key) < 0) {
            node.setRight(insertRec(node.getRight(), key));
        } else {
            throw new RuntimeException("Duplicate Key!");
        }
        return rebalance(node);
    }

    private Node rotateRight(Node node) {
        Node nNode = node.getLeft();
        Node anotherNode = nNode.getRight();
        nNode.setRight(node);
        node.setLeft(anotherNode);
        updateHeight(node);
        updateHeight(nNode);
        return nNode;
    }

    private Node rotateLeft(Node node) {
        Node nNode = node.getRight();
        Node anotherNode = nNode.getLeft();
        nNode.setLeft(node);
        node.setRight(anotherNode);
        updateHeight(node);
        updateHeight(nNode);
        return nNode;
    }

    public void delete(String key) {
            root = deleteRec(root, key);
    }

    private Node deleteRec(Node node, String key) {
        if(node == null){ return node;}
        else if (node.getKey().compareTo(key) > 0) {
            node.setLeft(deleteRec(node.getLeft(), key));
        } else if (node.getKey().compareTo(key) < 0) {
            node.setRight(deleteRec(node.getRight(), key));
        }
        else {
            if (node.getLeft() == null || node.getRight() == null) {
                if(node.getLeft() == null){node = node.getRight();}
                else{node = node.getLeft();}
            }
            else {
                Node mostLeftChild = getMinRec(node.getRight());
                node.setKey(mostLeftChild.getKey());
                node.setRight(deleteRec(node.getRight(), node.getKey()));
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }
}