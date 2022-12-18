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

    @Test
    public void ceil_and_floor(){
        BinarySearchTree binarySearchTree = createBinaryTree();
        assertEquals("kobs", binarySearchTree.ceil("klbs"));
        assertEquals("bebe", binarySearchTree.ceil("babs"));
        assertEquals("kubs", binarySearchTree.floor("kubs"));
        assertEquals("kubs", binarySearchTree.ceil("kubs"));
        assertEquals("kabs", binarySearchTree.floor("kbbs"));
        assertNull(binarySearchTree.ceil("zzzzzzzz"));
        assertEquals("kubs", binarySearchTree.floor("zzzzzzz"));
        assertEquals("bebe", binarySearchTree.ceil("aaaaaa"));
        assertNull(binarySearchTree.floor("aaaaaa"));
    }
}
