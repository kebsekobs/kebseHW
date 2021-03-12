package HW1.code;

import javax.naming.SizeLimitExceededException;

public class QueueDynamicArray<T> {
    private DynamicArray<T> data;
    private int head = 0;
    private int tail = 0;

    public QueueDynamicArray(int size){
        DynamicArray dynamicArray = new DynamicArray(size);
        this.data = dynamicArray;
    }

    public void Enque(){
        if(tail < data.capacity()){
            if(data.get(tail) != null){
                throwException();
            }
        }
    }


    public void throwException() {
        try {
            throw new SizeLimitExceededException("Ну и что, что массив динамический, очередь же зациклена");
        } catch (SizeLimitExceededException e) {
            e.printStackTrace();
        }
    }
}

