package code;

public class Node {
    private Node parent, left, right;
    private String key;


    public Node(String key, Node parent) {
        this.key = key;
        this.parent = parent;
        this.left = this.right = null;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node nParent) {
        this.parent = nParent;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node nLeft) {
        this.left = nLeft;
        if (nLeft != null)
            nLeft.parent = this;
    }

    public void setRight(Node nRight) {
        this.right = nRight;
        if (nRight != null)
            nRight.parent = this;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }





}