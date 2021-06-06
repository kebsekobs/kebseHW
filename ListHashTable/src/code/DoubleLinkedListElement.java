package code;

public class DoubleLinkedListElement <K, T> {
    DoubleLinkedListElement<K, T> next;
    DoubleLinkedListElement<K, T> prev;
    K key;
    T value;


    public DoubleLinkedListElement(DoubleLinkedListElement Prev, DoubleLinkedListElement Next, T Value, K Key) {
        prev = Prev;
        next = Next;
        value = Value;
        key = Key;
    }
}
