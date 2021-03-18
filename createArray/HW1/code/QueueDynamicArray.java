package HW1.code;

public class QueueDynamicArray<T> {
    private DynamicArray<T> data;
    private int head;
    private int tail = 0;

    public QueueDynamicArray(int size){
        DynamicArray dynamicArray = new DynamicArray(size);
        this.data = dynamicArray;
        this.head = size - 1;
    }

    public void enqueue(T value){
            if(tail >= data.capacity()){
                if(data.get(0) != null){
                    throwMemException();
                }
                else {
                    data.set(0, value);
                    head = 0;
                    tail = 1;
                }
            }
            else if(data.get(tail) != null){
                throwMemException();
            }
            else {
                data.set(tail, value);
                head = tail;
                tail += 1;
            }
    }

    public void dequeue(){
        if(data.get(head) != null){
            data.set(head, null);
            if(head == 0){ head = data.capacity() - 1;}

        }
        else {throwNullException();}
    }




    public void throwMemException(){
        throw new ArithmeticException("Ну и что, что массив динамический, очередь же зациклена");
        /*в java есть Checked и Unchecked исключения и мне очень нужно Unchecked, но их очень мало,
        * а самому такое я не знаю как написать(знаю только как написать Checked), поэтому буду
        * использовать везде арифметик*/
    }
    public void throwNullException(){
        throw new NullPointerException("Пусто пусто выросла капуста");
    }
}

