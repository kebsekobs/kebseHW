package HW2.code;

public class DoubleLinkedListElement <T> {
    DoubleLinkedListElement<T> next;
    DoubleLinkedListElement<T> prev;
    T value;

    public DoubleLinkedListElement(DoubleLinkedListElement Prev, DoubleLinkedListElement Next, T Value) {
        this.prev = Prev;
        this.next = Next;
        this.value = Value;
    }
}
