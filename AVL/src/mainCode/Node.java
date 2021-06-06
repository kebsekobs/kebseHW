package mainCode;

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

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getKey() {
        return key;
    }

    public int getBalance() {
        return balance;
    }




}