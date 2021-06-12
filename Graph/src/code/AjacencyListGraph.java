package code;
import java.util.ArrayList;

public class AjacencyListGraph {
    ArrayList<DoubleLinkedListElement> list;
    int vertex;

    public AjacencyListGraph(int vertex) {
        list = new ArrayList<DoubleLinkedListElement>();
        this.vertex = vertex;
        list.ensureCapacity(vertex);
        for (int i = 0; i < vertex; i++) {
            list.add(null);
        }
    }

    public void addEdge(int start, int weight, int finish) {
        if(start >= vertex | finish >= vertex | start < 0 | finish < 0){throwException();}
        DoubleLinkedListElement node = getNodeForKeyAndTo(start, finish);
        if (node != null) {
            node.weight = weight;
            return;
        }

        node = new DoubleLinkedListElement(null, null, weight, finish, start);
        if (list.get(start) != null) {
            node.next = list.get(start);
            node.next.prev = node;
        }
        list.set(start, node);
        return;
    }

    public void removeEdge(int start, int finish) {
        if(start >= vertex | finish >= vertex | start < 0 | finish < 0){throwException();}
        DoubleLinkedListElement node = getNodeForKeyAndTo(start, finish);
        if (node == null) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            list.set(start, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return;
    }

    public int getEdge(int start, int finish) {
        if(start >= vertex | finish >= vertex | start < 0 | finish < 0){throwException();}
        DoubleLinkedListElement node = getNodeForKeyAndTo(start, finish);
        return node == null ? 0 : node.weight;
    }

    public void addVertex(){
        list.add(null);
        vertex++;
    }

    public void cleanUp(){
        list = new ArrayList<DoubleLinkedListElement>();
        vertex = 0;
    }

    public int getVertex(){
        return vertex;
    }


    private DoubleLinkedListElement getNodeForKeyAndTo(int start, int finish) {
        DoubleLinkedListElement current = list.get(start);
        while (current != null) {
            if (current.finish == finish) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void throwException(){
        throw new ArrayIndexOutOfBoundsException("ЭЭээээээ куда прёшь??!?!?!??!?");
    }

}
