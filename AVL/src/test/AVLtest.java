package test;
import code.Tree;
import code.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AVLtest extends Assertions {
    @Test
    public void getSuccessor_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");
        assertEquals("abcdefghijk", tree.getSuccessor(tree.search("abcdefghij")));
    }

    @Test
    public void getSuccessor_WrongTypePassedIn_returnsNull() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");


        Object actual = tree.getSuccessor(tree.search("ergergergerg"));
        assertNull(actual);
    }

    @Test
    public void getSuccessor_NotFound_returnsNull() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");


        Object actual = tree.getSuccessor(tree.search("abcdefghijkl"));
        assertNull(actual);
    }

    @Test
    public void getPredecessor_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefghi";
        String actual = tree.getPredecessor(tree.search("abcdefghij")).getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void getPredecessor_WrongTypePassedIn_returnsNull() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        Object actual = tree.getPredecessor(null);
        assertNull(actual);
    }

    @Test
    public void getPredecessor_NotFound_returnsNull() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        Object actual = tree.getPredecessor(tree.search("f"));
        assertNull(actual);
    }

    @Test
    public void getMin_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefgh";
        String actual = tree.getMin();
        assertEquals(expected, actual);
    }

    @Test
    public void getMax_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefgh";
        String actual = tree.getMax();
        assertEquals(expected, actual);
    }

    @Test
    public void search_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefghijkl";
        String actual = tree.search("abcdefghijkl").getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void search_NotFound_returnsNull() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        Object actual = tree.search("f");
        assertNull(actual);
    }

    // ACTION TESTS //
    @Test
    public void delete_ONECHILD_isRIGHTchild_hasRIGHTchild_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefg");
        tree.insert("abcdefghi");
        tree.insert("abcdefgh");
        tree.insert("abcdefghig");

        tree.delete("abcdefghi");

        String expected = "abcdefghig";
        String actual = tree.search("abcdefgh").getRight().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void delete_ONECHILD_isRIGHTchild_hasLEFTchild_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefg");
        tree.insert("abcdefghig");
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");

        tree.delete("abcdefghig");

        String expected = "abcdefghi";
        String actual = tree.search("abcdefgh").getRight().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void delete_ONECHILD_isLEFTchild_hasLEFTchild_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefg");
        tree.insert("abcdefgh");
        tree.insert("abcdef");
        tree.insert("abcde");

        tree.delete("abcdef");

        String expected = "abcde";
        String actual = tree.search("abcdefg").getLeft().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void delete_ONECHILD_isLEFTchild_hasRIGHTchild_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcdefg");

        tree.delete("abcde");

        String expected = "abcdefg";
        String actual = tree.search("abcdefgh").getLeft().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void delete_ZEROCHILDREN_isRIGHTchild_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcdefg");

        tree.delete("abcdefg");

        Object actual = tree.search("abcdefg");
        assertNull(actual);
    }

    @Test
    public void delete_ZEROCHILDREN_isLEFTchild_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");

        tree.delete("abcd");


        Object actual = tree.search("abcd");
        assertNull(actual);
    }

    @Test
    public void delete_TWOCHILDREN_isLEFTchild_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcde");
        tree.insert("abcdefghijkl");
        tree.insert("abcdef");
        tree.insert("abcdefghijklmn");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("ab");
        tree.insert("abcdefghi");
        tree.insert("abc");
        tree.insert("abcdefgh");
        tree.insert("abcdefghijklmnopq");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghijklmo");
        tree.insert("abcdefg");
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefg");

        tree.delete("abcde");

        String expected = "abcdef";
        String actual = tree.search("abcdefgh").getLeft().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void delete_TWOCHILDREN_isRIGHTchild_positive() {
        Tree tree = new Tree();


        tree.insert("abcdefgh");
        tree.insert("abcde");
        tree.insert("abcdefghijkl");
        tree.insert("abcdef");
        tree.insert("abcdefghijklmn");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("ab");
        tree.insert("abcdefghi");
        tree.insert("abc");
        tree.insert("abcdefgh");
        tree.insert("abcdefghijklmnopq");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghijklmo");
        tree.insert("abcdefg");

        tree.delete("abcdefghijkl");

        String expected = "abcdefghijklmn";
        String actual = tree.search("abcdefgh").getRight().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void delete_WrongType_DoNothing() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");

        tree.delete(null);
    }


    @Test
    public void insert_positive() {
        Tree tree = new Tree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefghijkl";
        String actual = tree.search("abcdefghijkl").getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void insert_WrongType_doNothing() {
        Tree tree = new Tree();
        tree.insert(null);
    }
}
