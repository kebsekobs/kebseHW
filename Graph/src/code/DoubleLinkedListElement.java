package code;

public class DoubleLinkedListElement{
    DoubleLinkedListElement next;
    DoubleLinkedListElement prev;
    int weight;
    int finish;
    int start;

    public DoubleLinkedListElement(DoubleLinkedListElement Prev, DoubleLinkedListElement Next, int Weight, int Finish, int Start) {
        prev = Prev;
        next = Next;
        weight = Weight;
        finish = Finish;
        start = Start;
    }
}
