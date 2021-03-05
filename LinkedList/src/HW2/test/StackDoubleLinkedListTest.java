package HW2.test;

import HW2.code.StackDoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackDoubleLinkedListTest extends Assertions{
    @Test
    public void test_add_first_and_last_and_get_first_and_last(){
        StackDoubleLinkedList stackDoubleLinkedList = new StackDoubleLinkedList();
        stackDoubleLinkedList.push(15);
        assertEquals(15, stackDoubleLinkedList.peek());
        stackDoubleLinkedList.push(21);
        assertEquals(21, stackDoubleLinkedList.pop());
        assertEquals(15, stackDoubleLinkedList.pop());
        assertTrue(stackDoubleLinkedList.isEmpty());
    }

}
