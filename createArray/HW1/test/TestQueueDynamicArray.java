package HW1.test;

import HW1.code.QueueDynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.SizeLimitExceededException;

public class TestQueueDynamicArray extends Assertions{
    @Test
    public void test_init(){
        QueueDynamicArray queueDynamicArray = new QueueDynamicArray(5);
    }

    @Test
    public void test_enqueue(){
        QueueDynamicArray queueDynamicArray = new QueueDynamicArray(5);
        queueDynamicArray.enqueue(1);
        queueDynamicArray.enqueue(2);
        queueDynamicArray.enqueue(23);
        queueDynamicArray.enqueue(25);
        queueDynamicArray.enqueue(28);
        assertThrows(ArithmeticException.class, () -> queueDynamicArray.enqueue(999));
    }

}
