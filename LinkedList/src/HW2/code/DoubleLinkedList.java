package HW2.code;

public class DoubleLinkedList<T>{
    private DoubleLinkedListElement<T> first;
    private DoubleLinkedListElement<T> last;

    public DoubleLinkedList() {
        first =  null;
        last = null;
    }

    public void addFirst(T Value) {
        final DoubleLinkedListElement currFirst = first;
        final DoubleLinkedListElement newDoubleLinkedListElement = new DoubleLinkedListElement(null, currFirst, Value);
        first = newDoubleLinkedListElement;
        if(currFirst == null)
            last = newDoubleLinkedListElement;
        else
            currFirst.prev = newDoubleLinkedListElement;
    }

    public void addLast(T Value) {
        final DoubleLinkedListElement currLast = last;
        final DoubleLinkedListElement newDoubleLinkedListElement = new DoubleLinkedListElement(currLast, null, Value);
        last = newDoubleLinkedListElement;
            if(currLast == null)
            first = newDoubleLinkedListElement;
        else
            currLast.next = newDoubleLinkedListElement;
    }

    public T getLast() {
        return last.value;
    }

    public T getFirst() {
        return first.value;
    }

    public void insert(DoubleLinkedListElement<T> element, T newElement) {
        DoubleLinkedListElement<T> node = new DoubleLinkedListElement<T>(element, element.next, newElement);
        node.next = element.next;
        node.prev = element;
        if (element == last) addLast(newElement);
        else {
            element.next = node;
            node.next.prev = node;
        }
    }

    public DoubleLinkedListElement<T> search(T searchValue) {
        DoubleLinkedListElement<T> element = first;
        while (element != null) {
            if (element.value.equals(searchValue)) return element;
            element = element.next;
        }
        return null;
    }
}
