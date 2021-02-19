package HW1.code;

public class DynamicArray <T>{
    private final int DEFAULT_SIZE = 10;
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
        if(size() <= index | index < 0){throwException();}
        return array[index];
    }

    public void set(int index,T value){
        if(size() <= index | index < 0){throwException();}
        array[index] = value;
    }

    public void resize(int newSize){
        if (newSize < 0){throwException();}
        T[] newArray = array.clone();
        array = (T[])new Object[newSize];
        for(int i = 0; i < newSize; i++){
            array[i] = newArray[i];
        }
    }

    public int size(){
        return array.length;
    }

    public int findFirst(T value){
        for(int i = 0; i < size(); i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public void throwException(){
        throw new ArithmeticException("ЭЭээээээ куда прёшь??!?!?!??!?");
    }
}

