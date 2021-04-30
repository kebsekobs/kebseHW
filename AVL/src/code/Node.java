package code;

public class Node {
    private Node parent, left, right;
    private String key;
    private int balance;


    public Node(String key, Node parent) {
        this.key = key;
        this.parent = parent;
        this.left = this.right = null;
        this.balance = 0;
    }

    public Node getParent() {
        return parent;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }






}