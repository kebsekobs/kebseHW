import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import mainCode.BinarySearchTree;

public class TestBinarySearchTree extends Assertions {
    @Test
    public void test_add_first_and_last_and_get_first_and_last(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1, "hah");
        binarySearchTree.insert(21, "hih");
    }
}
