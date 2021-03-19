package HW2.test;

import HW2.code.DoubleQueueLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleQueueTest extends Assertions{

    @Test
    public void test_pushLast(){
        DoubleQueueLinkedList doubleQueueLinkedList = new DoubleQueueLinkedList();
        doubleQueueLinkedList.pushLast("kkkk");
        assertEquals("kkkk", doubleQueueLinkedList.peekLast());
    }

    @Test
    public void test_pushFirst(){
        DoubleQueueLinkedList doubleQueueLinkedList = new DoubleQueueLinkedList();
        doubleQueueLinkedList.pushFirst("k065");
        assertEquals("k065", doubleQueueLinkedList.peekFirst());
    }

    @Test
    public void test_popLast(){
        DoubleQueueLinkedList doubleQueueLinkedList = new DoubleQueueLinkedList();
        doubleQueueLinkedList.pushLast("15");
        assertEquals("15", doubleQueueLinkedList.peekLast());
        doubleQueueLinkedList.pushLast("21");
        assertEquals("21", doubleQueueLinkedList.popLast());
        assertEquals("15", doubleQueueLinkedList.popLast());
    }

    @Test
    public void test_popFirst(){
        DoubleQueueLinkedList doubleQueueLinkedList = new DoubleQueueLinkedList();
        doubleQueueLinkedList.pushFirst("15");
        assertEquals("15", doubleQueueLinkedList.peekFirst());
        doubleQueueLinkedList.pushFirst("21");
        assertEquals("21", doubleQueueLinkedList.popFirst());
        assertEquals("15", doubleQueueLinkedList.popFirst());
    }


    @Test
    public void test_peekLast(){
        DoubleQueueLinkedList doubleQueueLinkedList = new DoubleQueueLinkedList();
        doubleQueueLinkedList.pushLast("15");
        assertEquals("15", doubleQueueLinkedList.peekLast());
        doubleQueueLinkedList.pushLast("21");
        assertEquals("21", doubleQueueLinkedList.popLast());
        assertEquals("15", doubleQueueLinkedList.popLast());
    }

    @Test
    public void test_peekFirst(){
        DoubleQueueLinkedList doubleQueueLinkedList = new DoubleQueueLinkedList();
        doubleQueueLinkedList.pushFirst("15");
        assertEquals("15", doubleQueueLinkedList.peekFirst());
        doubleQueueLinkedList.pushFirst("21");
        assertEquals("21", doubleQueueLinkedList.popFirst());
        assertEquals("15", doubleQueueLinkedList.popFirst());
    }


    @Test
    public void test_isEmpty(){
        DoubleQueueLinkedList doubleQueueLinkedList = new DoubleQueueLinkedList();
        doubleQueueLinkedList.pushLast("15");
        assertEquals("15", doubleQueueLinkedList.peekLast());
        doubleQueueLinkedList.pushFirst("21");
        assertEquals("21", doubleQueueLinkedList.popFirst());
        assertEquals("15", doubleQueueLinkedList.popLast());
        assertTrue(doubleQueueLinkedList.isEmpty());
    }

}
