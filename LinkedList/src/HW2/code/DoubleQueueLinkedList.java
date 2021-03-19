package HW2.code;

public class DoubleQueueLinkedList<T> {
    private DoubleLinkedList<T> data;
    private DoubleLinkedListElement<T> top;

    public DoubleQueueLinkedList() {
            DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
            this.data = doubleLinkedList;
            this.top = data.getHead();
    }

    public boolean isEmpty(){
            return data.isEmpty();
        }

    public void pushLast(T element){
            data.addLast(element);
            top = data.getHead();
    }

    public void pushFirst(T element){
        data.addFirst(element);
        top = data.getHead();
    }

    public T popLast(){
            T forReturn = data.getLast();
            data.deleteLast();
            return forReturn;
    }

    public T popFirst(){
        T forReturn = data.getFirst();
        data.deleteFirst();
        return forReturn;
    }

    public T peekFirst(){
            return data.getFirst();
        }

    public T peekLast(){
        return data.getLast();
    }
}
