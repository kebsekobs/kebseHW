package code;

import java.util.Objects;

public class BinarySearchTree {
    private Node root = null;

    public Node search(String key) {
        if (root == null)
            return null;
        return searchRec(root, key);
    }

    private Node searchRec(Node node, String key){
            if (node == null | key.equals(node.getKey())){return node;}
            if (key.compareTo(node.getKey()) < 0){return searchRec(node.getLeft(), key);}
            else{ return searchRec(node.getRight(), key);}}


    public String minimum(){
        if (root == null)
            throw new RuntimeException("Min value isn't exist in empty tree");
        return minimumRec(root).getKey();
    }
    private Node minimumRec(Node node){
            if (node.getLeft() == null){ return node;}
            return minimumRec(node.getLeft());}

    public String maximum() {
        if (root == null)
            throw new RuntimeException("Max value isn't exist in empty tree");
        return maximumRec(root).getKey();
    }

    public Node maximumRec(Node node){
        if (node.getRight() == null){ return node;}
        return maximumRec(node.getRight());}

    public Node next(Node node){
            if(node.getRight() != null){
                return minimumRec(node.getRight());}
            Node anotherNode = node.getParent();
            while( anotherNode != null && node == anotherNode.getRight()){
                node = anotherNode;
                anotherNode = anotherNode.getParent();
            }
            return anotherNode;}

    public Node prev(Node node){
        if(node.getLeft() != null){
            return maximumRec(node.getLeft());}
        Node anotherNode = node.getParent();
        while( anotherNode != null && node == anotherNode.getLeft()){
            node = anotherNode;
            anotherNode = anotherNode.getParent();}
        return anotherNode;}



    public boolean insert(String key) {
        if (root == null) {
            root = new Node(key, null);
            return true;
        } else {
            return insertRec(root, key);
        }
    }


    private boolean insertRec(Node node, String key) {
        if (key.equals(node.getKey())) {
            return false;
        } else if (key.compareTo(node.getKey()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(key, node));
                return true;
            } else {
                return insertRec(node.getLeft(), key);
            }
        } else if (key.compareTo(node.getKey()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new Node(key, node));
                return true;
            } else {
                return insertRec(node.getRight(), key);
            }
        }
        return false;
    }

    public void delete(String key){
        root = deleteRec(root, key);
    }


    public Node deleteRec(Node node, String key){
        if (node == null) {
            return null;
        }
        if (key.equals(node.getKey())) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }

            if (node.getLeft() == null) {
                return node.getRight();
            }
            String smallestValue = minimumRec(node.getRight()).getKey();
            node.setKey(smallestValue);
            node.setRight(deleteRec(node.getRight(), smallestValue));
            return node;
        }
        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(deleteRec(node.getLeft(), key));
            return node;
        }

        node.setRight(deleteRec(node.getRight(), key));
            return node;
    }

    public String floor(String key){
        if (root == null)
            return null;
        return floorRec(root, key);
    }

    private String floorRec(Node node,String key){
        if (node == null) {
            return null;
        }
        if (Objects.equals(node.getKey(), key)) {
            return node.getKey();
        }

        // If root's key is smaller,
        // ceil must be in right subtree
        if (key.compareTo(node.getKey()) < 0) {
            return floorRec(node.getLeft(), key);
        }

        // Else, either left subtree or root
        // has the ceil value
        else{
            String floor = floorRec(node.getRight(), key);
            if(floor == null){
                return node.getKey();
            }
            return (key.compareTo(node.getKey()) >= 0) ? floor : node.getKey();
        }

    }

    public String ceil(String key){
        if (root == null)
            return null;
        return ceilRec(root, key);
    }

    private String ceilRec(Node node,String key){
        if (node == null) {
            return null;
        }
        if (Objects.equals(node.getKey(), key)) {
            return node.getKey();
        }

        // If root's key is smaller,
        // ceil must be in right subtree
        if (key.compareTo(node.getKey()) > 0) {
            return ceilRec(node.getRight(), key);
        }

        // Else, either left subtree or root
        // has the ceil value
        else{
            String ceil = ceilRec(node.getLeft(), key);
            if(ceil == null){
                return node.getKey();
            }
            return (key.compareTo(node.getKey()) <= 0) ? ceil : node.getKey();
        }
    }
}

