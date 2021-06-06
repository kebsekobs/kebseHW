package code;
import java.util.ArrayList;


public class ListHashTable<K, T> {

    private ArrayList<DoubleLinkedListElement<K, T>> data;

    public ListHashTable(int capacity) {
        data = new ArrayList<DoubleLinkedListElement<K, T>>();
        data.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            data.add(null);
        }
    }
}
