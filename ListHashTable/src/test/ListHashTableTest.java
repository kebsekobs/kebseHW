package test;

import code.ListHashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListHashTableTest extends Assertions {
    @Test
    public void test_add_and_get() {
        ListHashTable listHashTable = new ListHashTable(8);
        listHashTable.add(1, "25");
        listHashTable.add(17, "26");
        listHashTable.add(9, "27");
        assertEquals("25", listHashTable.get(1));
        assertEquals("26", listHashTable.get(17));
        assertEquals("27", listHashTable.get(9));
    }

    @Test
    public void test_remove() {
        ListHashTable listHashTable = new ListHashTable(8);
        listHashTable.add(1, "25");
        listHashTable.add(17, "26");
        listHashTable.add(9, "27");
        listHashTable.remove(17);
        assertEquals("25", listHashTable.get(1));
        assertEquals("27", listHashTable.get(9));
        assertEquals(null, listHashTable.get(17));

    }
}
