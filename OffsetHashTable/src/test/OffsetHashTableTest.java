package test;
import code.OffsetHashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OffsetHashTableTest extends Assertions {
    @Test
    public void test_add_and_get() {
        OffsetHashTable offsetHashTable = new OffsetHashTable(8);
        offsetHashTable.add(1, "25");
        offsetHashTable.add(17, "26");
        offsetHashTable.add(9, "27");
        assertEquals("25", offsetHashTable.get(1));
        assertEquals("26", offsetHashTable.get(17));
        assertEquals("27", offsetHashTable.get(9));
    }

    @Test
    public void test_remove() {
        OffsetHashTable offsetHashTable = new OffsetHashTable(8);
        offsetHashTable.add(1, "25");
        offsetHashTable.add(17, "26");
        offsetHashTable.add(9, "27");
        offsetHashTable.remove(17);
        assertEquals("25", offsetHashTable.get(1));
        assertEquals("27", offsetHashTable.get(9));
        assertEquals(null, offsetHashTable.get(17));

    }
}
