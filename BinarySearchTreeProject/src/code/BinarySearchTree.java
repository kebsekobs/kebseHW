package code;

public class BinarySearchTree {
    private Node root = null;

    public Node search(Node node, String key){
            if (node == null | key.equals(node.getKey())){return node;}
            if (key.compareTo(node.getKey()) < 0){return search(node.getLeft(), key);}
            else{ return search(node.getRight(), key);}}

    public Node minimum(Node node){
            if (node.getLeft() == null){ return node;}
            return minimum(node.getLeft());}

    public Node maximum(Node node){
        if (node.getRight() == null){ return node;}
        return maximum(node.getRight());}

    public Node next(Node node){
            if(node.getRight() != null){
                return minimum(node.getRight());}
            Node anotherNode = node.getParent();
            while( anotherNode != null && node == anotherNode.getRight()){
                node = anotherNode;
                anotherNode = anotherNode.getParent();
            }
            return anotherNode;}

    public Node prev(Node node){
        if(node.getLeft() != null){
            return maximum(node.getLeft());}
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
    Node parent = node.getParent();
        if (node.getLeft() == null && node.getRight() == null){
            if (parent.getLeft() == node){parent.setLeft(null);}
            if (parent.getRight() == node){ parent.setRight(null);}}
        else if (node.getLeft() == null | node.getRight() == null){
            if (node.getLeft() == null){
                if (parent.getLeft() == node){parent.setLeft(node.getRight());}
                else{parent.setRight(node.getRight());}
                node.getRight().setParent(parent);}
       else{
           if(parent.getLeft() == node){ parent.setLeft(node.getLeft());}
           else{ parent.setRight(node.getLeft());}
           node.getLeft().setParent(parent);}}
       else{
            Node successor = next(node);
            node.setKey(successor.getKey());
            if (successor.getParent().getLeft() == successor){
                successor.getParent().setLeft(successor.getRight());
                if (successor.getRight() != null){
                    successor.getRight().setParent(successor.getParent());}}
            else{
                successor.getParent().setRight(successor.getRight());
                if (successor.getRight() != null){
                    successor.getRight().setParent(successor.getParent());}}}
       return parent;
    }
}

