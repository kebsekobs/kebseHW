package code;

public class Node {
    private Node left, right;
    private String key;
    private int height;


    public Node(String key) {
        this.key = key;
        this.left = this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node nLeft) {
        this.left = nLeft;
    }

    public void setRight(Node nRight) {
        this.right = nRight;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getHeight(){return height;}

    public void setHeight(int height){this.height = height;}
}