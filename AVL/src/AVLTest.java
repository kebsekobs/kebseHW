import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import code.Tree;

public class AVLTest extends Assertions {
    private Tree createAVLTree() {
        Tree Tree = new Tree();
        Tree.insert("kebs");
        Tree.insert("kobs");
        Tree.insert("kabs");
        Tree.insert("kubs");
        Tree.insert("kibs");

        return Tree;
    }

    @Test
    public void max(){
        Tree tree = createAVLTree();
        assertEquals("kubs", tree.getMax());
    }

    @Test
    public void min(){
        Tree tree = createAVLTree();
        assertEquals("kabs", tree.getMin());
    }

    @Test
    public void delete(){
        Tree tree = createAVLTree();
        assertEquals("kabs", tree.getMin());
        assertEquals("kubs", tree.getMax());
        tree.delete("kabs");
        tree.delete("kubs");
        assertEquals("kebs", tree.getMin());
        assertEquals("kobs", tree.getMax());
    }



}
