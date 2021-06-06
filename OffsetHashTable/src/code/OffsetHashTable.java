package code;
import java.util.Arrays;

public class OffsetHashTable<T> {
    int FREE = Integer.MIN_VALUE;
    int size;
    int[] keys;
    T[] values;

    public OffsetHashTable(int size) {
        this.size = Math.max(3 * size / 2, size) + 1;
        keys = new int [this.size];
        values = (T[]) new Object[this.size];
        Arrays.fill(keys, FREE);
    }

    public void add(int key, T value) {
        for (int i = index(hash(key)); ; i++) {
            if (i == size) i = 0;
            if (keys[i] == FREE)
                keys[i] = key;
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }
    }

    public T get(int key) {
        for (int i = index(hash(key)); ; i++) {
            if (i == size) i = 0;
            if (keys[i] == FREE) throw new RuntimeException("No such key!");
            if (keys[i] == key) return values[i];
        }
    }

    public void remove(int key) {
        int removedKey = index(hash(key));
        int newKey = removedKey + 1;
        while (values[newKey] == null | keys[newKey] != keys[removedKey]){
            if (values[newKey] == null){
                values[removedKey] = null;
                return;}
            newKey++;}
        values[removedKey] = values[newKey];
        remove(newKey);
    }


    boolean containsKey(int key) {
        for (int i = index(hash(key)); ; i++) {
            if (i == size) i = 0;
            if (keys[i] == FREE) return false;
            if (keys[i] == key) return true;
        }
    }

    int hash(int key) {
        return (key >> 15) ^ key;
    }

    int index(int hash) {
        return Math.abs(hash) % size;
    }
}
