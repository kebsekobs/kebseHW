package HW1.code;

public class DynamicArray <T>{
    private final int DEFAULT_SIZE = 10;
    private final int DEFAULT_RATE = 2;
    private T[] array;

    public DynamicArray(){
        array = (T[])new Object[DEFAULT_SIZE];

    }

    public DynamicArray(int firstSize){
        if (firstSize > -1) {
            array = (T[]) new Object[firstSize];
        }
        else {array = (T[])new Object[DEFAULT_SIZE];}
    }

    public T get(int index){
        if(capacity() <= index | index < 0){throwException();}
        return array[index];
    }

    public void set(int index,T value){
        if(capacity() <= index | index < 0){throwException();}
        array[index] = value;
    }

    public void resize(int newSize){
        if (newSize < 0){throwException();}
        T[] newArray = array.clone();
        array = (T[])new Object[newSize];
        if (Math.min(newSize, newArray.length) >= 0)
            System.arraycopy(newArray, 0, array, 0, Math.min(newSize, newArray.length));
    }

    public int capacity(){
        return array.length;
    }

    public int size(){
        int number = 0;
        for(int i = 0; i < capacity(); i++){
        if(array[i] != null){
            number = i;
        }}
        return number + 1;
    }

    public int findFirst(T value){
        for(int i = 0; i < capacity(); i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public int findLast(T value){
        for(int i = capacity() - 1; i > -1; i--){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }


    public void add(T value){
        if (size() >= capacity()) {
            resize(capacity() * DEFAULT_RATE + 1);
        }
        set(size(), value);
    }

    public void insert(int index, T value){
        if(index < 0){throwException();}
        int number = -1;
        if(index >= capacity()){
            resize(Math.max(capacity() * DEFAULT_RATE + 1, index + 1));
        }
        if (array[index] != null) {
            int oldSize = capacity();
            for (int i = 0; i < capacity(); i++) {
                if (array[i] != null) {
                    number = i;
                }
            }
            if (number == capacity() - 1) {
                resize(capacity() * DEFAULT_RATE + 1);
            }
            if (oldSize - index >= 0) System.arraycopy(array, index, array, index + 1, oldSize - index);
        }
        array[index] = value;
    }

    public void remove(int index){
        if(capacity() <= index | index < 0){throwException();}
        array[index] = null;
        if (capacity() - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, capacity() - 1 - index);
    }

    public void throwException(){
        throw new ArithmeticException("ЭЭээээээ куда прёшь??!?!?!??!?");
    }
}

