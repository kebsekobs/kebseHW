package HW1.test;

import HW1.code.QueueDynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestQueueDynamicArray extends Assertions{
    @Test
    public void test_init(){
        QueueDynamicArray queueDynamicArray = new QueueDynamicArray(5);
    }

    @Test
    public void test_enqueue(){
        QueueDynamicArray queueDynamicArray = new QueueDynamicArray(5);
        queueDynamicArray.enqueue('a');
        queueDynamicArray.enqueue('b');
        queueDynamicArray.enqueue('c');
        queueDynamicArray.enqueue('d');
        queueDynamicArray.enqueue('e');
        assertThrows(ArithmeticException.class, () -> queueDynamicArray.enqueue(999));
    }
    @Test
    public void test_dequeue(){
        QueueDynamicArray queueDynamicArray = new QueueDynamicArray(5);
        queueDynamicArray.enqueue('a');
        queueDynamicArray.enqueue('b');
        queueDynamicArray.enqueue('c');
        queueDynamicArray.enqueue('d');
        queueDynamicArray.enqueue('e');
        queueDynamicArray.dequeue();
        queueDynamicArray.dequeue();
        queueDynamicArray.dequeue();
        queueDynamicArray.dequeue();
        queueDynamicArray.dequeue();
        assertThrows(NullPointerException.class, () -> queueDynamicArray.dequeue());
    }
    @Test
    public void test_peek() {
        QueueDynamicArray queueDynamicArray = new QueueDynamicArray(5);

        assertThrows(NullPointerException.class, () -> queueDynamicArray.peek());
        queueDynamicArray.enqueue('e');
        assertEquals('e', queueDynamicArray.peek());
        queueDynamicArray.enqueue('q');
        assertEquals('e', queueDynamicArray.peek());
        queueDynamicArray.enqueue('w');
        assertEquals('e', queueDynamicArray.peek());
        queueDynamicArray.enqueue('f');
        assertEquals('e', queueDynamicArray.peek());
        queueDynamicArray.enqueue('o');
        assertEquals('e', queueDynamicArray.peek());
    }
    @Test
    public void test_size(){
        QueueDynamicArray queueDynamicArray = new QueueDynamicArray(5);
        assertEquals(0, queueDynamicArray.size());
        queueDynamicArray.enqueue('e');
        assertEquals(1, queueDynamicArray.size());
        queueDynamicArray.enqueue('a');
        assertEquals(2, queueDynamicArray.size());
        queueDynamicArray.enqueue('s');
        assertEquals(3, queueDynamicArray.size());
        queueDynamicArray.enqueue('d');
        assertEquals(4, queueDynamicArray.size());
        queueDynamicArray.enqueue('f');
        assertEquals(5, queueDynamicArray.size());
        queueDynamicArray.dequeue();
        assertEquals(4, queueDynamicArray.size());
        queueDynamicArray.dequeue();
        assertEquals(3, queueDynamicArray.size());
        queueDynamicArray.dequeue();
        assertEquals(2, queueDynamicArray.size());
        queueDynamicArray.dequeue();
        assertEquals(1, queueDynamicArray.size());
        queueDynamicArray.dequeue();
        assertEquals(0, queueDynamicArray.size());
    }

}
