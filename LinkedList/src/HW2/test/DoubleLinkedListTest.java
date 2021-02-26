package HW2.test;

import HW2.code.DoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest  extends Assertions {

    @Test
    public void test_resize_and_size(){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(15);
        doubleLinkedList.addLast(21);
        assertEquals(15, doubleLinkedList.getFirst());
        assertEquals(21, doubleLinkedList.getLast());


    }
}
