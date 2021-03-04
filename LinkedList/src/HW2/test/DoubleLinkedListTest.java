package HW2.test;

import HW2.code.DoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest  extends Assertions {

    @Test
    public void test_add_first_and_last_and_get_first_and_last(){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(15);
        doubleLinkedList.addLast(21);
        assertEquals(15, doubleLinkedList.getFirst());
        assertEquals(21, doubleLinkedList.getLast());
    }

    @Test
    public void test_insert_and_search(){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(15);
        doubleLinkedList.addLast(21);
        doubleLinkedList.insert(doubleLinkedList.search(21), 26);
        assertEquals(15, doubleLinkedList.getFirst());
        assertEquals(26, doubleLinkedList.getLast());
    }


    @Test
    public void test_delete(){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(15);
        doubleLinkedList.addLast(21);
        doubleLinkedList.insert(doubleLinkedList.search(15), 26);
        assertEquals(26, doubleLinkedList.getValue(1));
        doubleLinkedList.delete(doubleLinkedList.getElement(1));
        assertEquals(21, doubleLinkedList.getValue(1));
        assertEquals(21, doubleLinkedList.getLast());
        doubleLinkedList.deleteLast();
        assertEquals(15, doubleLinkedList.getLast());
        assertEquals(15, doubleLinkedList.getFirst());
        doubleLinkedList.deleteFirst();
        assertNull(doubleLinkedList.getFirst());
    }
}
