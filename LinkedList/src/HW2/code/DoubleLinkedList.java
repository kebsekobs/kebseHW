package HW2.code;

public class DoubleLinkedList<T>{
    private DoubleLinkedListElement first;
    private DoubleLinkedListElement last;

    public DoubleLinkedList() {
        first =  null;
        last = null;
    }

    public void addFirst(T Value) {
        final DoubleLinkedListElement currFirst = first;
        final DoubleLinkedListElement newDoubleLinkedListElement = new DoubleLinkedListElement(null, currFirst, Value);
        first = newDoubleLinkedListElement;
        if(currFirst == null)  // if empty list
            last = newDoubleLinkedListElement;
        else
            currFirst.prev = newDoubleLinkedListElement;
    }

    public void addLast(T Value) {
        final DoubleLinkedListElement currLast = last;
        final DoubleLinkedListElement newDoubleLinkedListElement = new DoubleLinkedListElement(currLast, null, Value);
        last = newDoubleLinkedListElement;
        if(currLast == null)  // if empty list
            first = newDoubleLinkedListElement;
        else
            currLast.next = newDoubleLinkedListElement;
    }

    public T getLast() {
        return (T) last.value;
    }

    public T getFirst() {
        return (T) first.value;
    }
}
