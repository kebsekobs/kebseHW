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

}
