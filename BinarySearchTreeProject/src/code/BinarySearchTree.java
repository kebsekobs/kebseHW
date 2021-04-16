package code;
public class BinarySearchTree {
    private Node root = null;

    public Node search(Node node, Integer key){
            if (node == null | key.equals(node.key)){
      return node;}
   if (key < node.key)
      return search(node.left, key);
   else{ return search(node.right, key);}}

    public Node minimum(Node node){
            if (node.left == null){
            return node;}
    return minimum(node.left);}

    public Node maximum(Node node){
        if (node.right == null){
            return node;}
        return maximum(node.right);}

        

    public boolean insert(Integer key, String value) {
        if (root == null) {
            root = new Node(key, value);
            return true;
        } else {
            return insert(root, key, value);
        }
    }


    private boolean insert(Node node, Integer key, String value) {
        if (key.equals(node.key)) {
            return false;
        } else if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key, value);
                return true;
            } else {
                return insert(node.left, key, value);
            }
        } else if (key > node.key) {
            if (node.right == null) {
                node.right = new Node(key, value);
                return true;
            } else {
                return insert(node.right, key, value);
            }
        }
        return false;
    }
}

