package code;

public class DoubleLinkedListElement{
    DoubleLinkedListElement next;
    DoubleLinkedListElement prev;
    int weight;
    int to;
    int key;

    public DoubleLinkedListElement(DoubleLinkedListElement Prev, DoubleLinkedListElement Next, int Weight, int To, int Key) {
        prev = Prev;
        next = Next;
        weight = Weight;
        to = To;
        key = Key;
    }
}
