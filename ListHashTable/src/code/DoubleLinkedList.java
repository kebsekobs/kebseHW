package code;

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
        if(last == null){return null;}
        return last.value;
    }

    public T getFirst() {
        if(first == null){return null;}
        return first.value;
    }

    public DoubleLinkedListElement<T> getHead(){
        return first;
    }

    public boolean isEmpty() {
        return first == null;
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


    public void delete(DoubleLinkedListElement<T> element) {
        if (element == first) {deleteFirst(); return;}
        if (element == last) {deleteLast(); return;}
        element.next.prev = element.prev;
        element.prev.next = element.next;
    }

    public T deleteFirst() {
        if (first == null) return null;
        T element = first.value;
        if (first == last){
            first = null;
            last = null;}
        else {
            first = first.next;
            first.prev = null;
        }
        return element;
    }

    public T deleteLast() {
        if (last == null) return null;
        T element = last.value;
        if (last == first){
            first = null;
            last = null;}
        else {
            last = last.prev;
            last.next = null;
        }
        return element;
    }


    public T getValue(int number){
        DoubleLinkedListElement<T> element = first;
        int count = 0;
        while (element != null) {
            if (count == number){ return element.value;}
            count++;
            element = element.next;
        }
        return null;
    }

    public DoubleLinkedListElement<T> getElement(int number){
        DoubleLinkedListElement<T> element = first;
        int count = 0;
        while (element != null) {
            if (count == number){ return element;}
            count++;
            element = element.next;
        }
        return null;
    }
}