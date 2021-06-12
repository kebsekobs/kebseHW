package code;
import java.util.ArrayList;

public class AjacencyListGraph {
    ArrayList<DoubleLinkedListElement> list;
    int vertex;

    public AjacencyListGraph(int vertex) {
        list = new ArrayList<DoubleLinkedListElement>();
        list.ensureCapacity(vertex);
        for (int i = 0; i < vertex; i++) {
            list.add(null);
        }
    }

    public void addEdge(int key, int weight, int to) {
        DoubleLinkedListElement node = getNodeForKey(key);
        if (node != null) {
            node.weight = weight;
            node.to = to;
            return;
        }

        node = new DoubleLinkedListElement(null, null, weight, to, key);
        if (list.get(key) != null) {
            node.next = list.get(key);
            node.next.prev = node;
        }
        list.set(key, node);
        return;
    }





    private DoubleLinkedListElement getNodeForKey(int key) {
        DoubleLinkedListElement current = list.get(key);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


}
