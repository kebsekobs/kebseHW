package mainCode;

public class Node {
        public Integer key;
        public String value;
        public Node left = null;
        public Node right = null;
        public Node parent = null;

        public Node(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }
