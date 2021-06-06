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

    public T add(K key, T value) {
        DoubleLinkedListElement<K, T> node = getNodeForKey(key);
        if (node != null) {
            T oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        node = new DoubleLinkedListElement<K, T>(null, null, value, key);
        int index = getIndexForKey(key);
        if (data.get(index) != null) {
            node.next = data.get(index);
            node.next.prev = node;
        }
        data.set(index, node);
        return null;
    }

    public T remove(K key) {
        DoubleLinkedListElement<K, T> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int hashKey = getIndexForKey(key);
            data.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }
}
