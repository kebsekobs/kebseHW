package code;

public class BinarySearchTree {
    private Node root = null;

    public Node search(Node node, String key){
            if (node == null | key.equals(node.getKey())){
      return node;}
   if (key.compareTo(node.getKey()) < 0){
      return search(node.left, key);}
   else{ return search(node.right, key);}}

    public Node minimum(Node node){
            if (node.left == null){
            return node;}
    return minimum(node.left);}

    public Node maximum(Node node){
        if (node.right == null){
            return node;}
        return maximum(node.right);}

    public Node next(Node node){
            if(node.right != null){
                return minimum(node.right);}
            Node anotherNode = node.parent;
            while( anotherNode != null && node == anotherNode.right){
                node = anotherNode;
                anotherNode = anotherNode.parent;}
            return anotherNode;}

    public Node prev(Node node){
        if(node.left != null){
            return maximum(node.left);}
        Node anotherNode = node.parent;
        while( anotherNode != null && node == anotherNode.left){
            node = anotherNode;
            anotherNode = anotherNode.parent;}
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


    public void delete(Node node){
    Node parent = node.parent;
   if (node.left == null && node.right == null){
            if (parent.left == node){
    parent.left = null;}
            if (parent.right == node){
    parent.right = null;}}
            else if (node.left == null | node.right == null){
            if (node.left == null){
            if (parent.left == node){
                parent.left = node.right;}
            else{
                parent.right = node.right;}
            node.right.parent = parent;}
       else{
               if(parent.left == node){
    parent.left = node.left;}
           else{
    parent.right = node.left;}
    node.left.parent = parent;}}
   else{
    Node successor = next(node);
    node.key = successor.key;
     if (successor.parent.left == successor){
    successor.parent.left = successor.right;
       if (successor.right != null){
    successor.right.parent = successor.parent;}}
     else{
    successor.parent.right = successor.right;
       if (successor.right != null){
    successor.right.parent = successor.parent;}}}
}
}

