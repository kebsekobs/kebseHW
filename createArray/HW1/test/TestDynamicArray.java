package HW1.test;

import HW1.code.DynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDynamicArray extends Assertions {
    @Test
    public void test_resize_and_size(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.resize(1);
        assertEquals(1, dynamicArray.size());
    }
    @Test
    public void test_set_and_get(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.resize(1);
        dynamicArray.set(0, 5);
        assertEquals(5, dynamicArray.get(0));
    }
    @Test
    public void test_resize_exception(){
        DynamicArray dynamicArray = new DynamicArray();
        assertThrows(ArithmeticException.class, () -> dynamicArray.resize(-1));
    }

    @Test
    public void test_get_exception(){
        DynamicArray dynamicArray = new DynamicArray();
        assertThrows(ArithmeticException.class, () -> dynamicArray.get(-1));
        assertThrows(ArithmeticException.class, () -> dynamicArray.get(10));
    }

    @Test
    public void test_set_exception(){
        DynamicArray dynamicArray = new DynamicArray();
        assertThrows(ArithmeticException.class, () -> dynamicArray.set(-1, 5));
        assertThrows(ArithmeticException.class, () -> dynamicArray.set(10, 18));
    }

    @Test
    public void test_init_with_int(){
        DynamicArray dynamicArray = new DynamicArray(5);
        assertEquals(5, dynamicArray.size());
    }

    @Test
    public void test_init_without_correct_int(){
        DynamicArray dynamicArray = new DynamicArray(-5);
        assertEquals(10, dynamicArray.size());
    }

    @Test
    public void test_findFirst(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.resize(3);
        dynamicArray.set(0, 5);
        dynamicArray.set(1, 2);
        dynamicArray.set(2, 5);
        assertEquals(0, dynamicArray.findFirst(5));
    }

    @Test
    public void test_findFirst_incorrect(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.resize(3);
        dynamicArray.set(0, 5);
        dynamicArray.set(1, 2);
        dynamicArray.set(2, 5);
        assertEquals(-1, dynamicArray.findFirst(3));
    }

    @Test
    public void test_findLast(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.resize(3);
        dynamicArray.set(0, 5);
        dynamicArray.set(1, 2);
        dynamicArray.set(2, 5);
        assertEquals(2, dynamicArray.findLast(5));
    }

    @Test
    public void test_findLast_incorrect(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.resize(3);
        dynamicArray.set(0, 5);
        dynamicArray.set(1, 2);
        dynamicArray.set(2, 5);
        assertEquals(-1, dynamicArray.findFirst(3));
    }

    @Test
    public void test_for_me(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.resize(5);
        dynamicArray.set(0, 5);
        dynamicArray.set(2, 5);
        dynamicArray.resize(3);
        assertEquals(5, dynamicArray.get(2));
    }

    @Test
    public void test_add(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.resize(4);
        dynamicArray.set(0, 5);
        dynamicArray.set(2, 5);
        dynamicArray.add(3);
        dynamicArray.add(4);
        assertEquals(3, dynamicArray.get(3));
        assertEquals(4, dynamicArray.get(4));
        assertEquals(8, dynamicArray.size());
        assertNull(dynamicArray.get(7));

    }
}
