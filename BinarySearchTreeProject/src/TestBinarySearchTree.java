import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import code.BinarySearchTree;

public class TestBinarySearchTree extends Assertions {

    private BinarySearchTree createBinaryTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert("kebs");
        binarySearchTree.insert("kobs");
        binarySearchTree.insert("kabs");
        binarySearchTree.insert("kubs");
        binarySearchTree.insert("kibs");
        binarySearchTree.insert("kebe");
        binarySearchTree.insert("bebe");
        return binarySearchTree;
    }
    @Test
    public void max(){
        BinarySearchTree binarySearchTree = createBinaryTree();
        assertEquals("kubs", binarySearchTree.maximum());
    }

    @Test
    public void min(){
        BinarySearchTree binarySearchTree = createBinaryTree();
        assertEquals("bebe", binarySearchTree.minimum());
    }

    @Test
    public void delete(){
        BinarySearchTree binarySearchTree = createBinaryTree();
        assertEquals("bebe", binarySearchTree.minimum());
        assertEquals("kubs", binarySearchTree.maximum());
        binarySearchTree.delete("bebe");
        binarySearchTree.delete("kubs");
        assertEquals("kabs", binarySearchTree.minimum());
        assertEquals("kobs", binarySearchTree.maximum());
    }
}
