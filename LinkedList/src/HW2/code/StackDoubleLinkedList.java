package HW2.code;

public class StackDoubleLinkedList<T> {
    private DoubleLinkedList<T> data;
    private DoubleLinkedListElement<T> top;

    public StackDoubleLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        this.data = doubleLinkedList;
        this.top = data.getHead();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void push(T element){
        data.addFirst(element);
        top = data.getHead();
    }

    public T pop(){
        T forReturn = data.getFirst();
        data.deleteFirst();
        return forReturn;
    }

    public T peek(){
        return data.getFirst();
    }
}
