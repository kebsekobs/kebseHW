package code;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class EdgesListGraph {
    ArrayList<ArrayList<Integer>> list;

    public EdgesListGraph(int vertex) {
        list = new ArrayList<ArrayList<Integer>>();
        list.ensureCapacity(vertex);
        for (int i = 0; i < vertex; i++) {
            Array.set(list, i, new ArrayList<Integer>());
        }
    }


}
