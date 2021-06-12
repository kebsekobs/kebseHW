package test;

import code.AjacencyListGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AjacencyListTest extends Assertions {
    @Test
    public void test_add_and_get_edge() {
        AjacencyListGraph ajacencyListGraph = new AjacencyListGraph(5);
        ajacencyListGraph.addEdge(0, 10, 2);
        ajacencyListGraph.addEdge(2, 3, 1);
        assertEquals(10, ajacencyListGraph.getEdge(0, 2));
        assertEquals(3, ajacencyListGraph.getEdge(2, 1));
    }

    @Test
    public void test_remove_edge() {
        AjacencyListGraph ajacencyListGraph = new AjacencyListGraph(5);
        ajacencyListGraph.addEdge(0, 10, 2);
        ajacencyListGraph.addEdge(2, 3, 1);
        ajacencyListGraph.removeEdge(0, 2);
        assertEquals(0, ajacencyListGraph.getEdge(0, 2));
        assertEquals(3, ajacencyListGraph.getEdge(2, 1));
    }

    @Test
    public void test_add_vertex() {
        AjacencyListGraph ajacencyListGraph = new AjacencyListGraph(5);
        ajacencyListGraph.addEdge(0, 10, 2);
        ajacencyListGraph.addEdge(2, 3, 1);
        ajacencyListGraph.addVertex();
        ajacencyListGraph.addEdge(3, 6, 5);
        assertEquals(10, ajacencyListGraph.getEdge(0, 2));
        assertEquals(3, ajacencyListGraph.getEdge(2, 1));
        assertEquals(6, ajacencyListGraph.getEdge(3, 5));
    }

    @Test
    public void test_cleanUp() {
        AjacencyListGraph ajacencyListGraph = new AjacencyListGraph(5);
        ajacencyListGraph.addEdge(0, 10, 2);
        ajacencyListGraph.addEdge(2, 3, 1);
        ajacencyListGraph.cleanUp();
        assertEquals(0, ajacencyListGraph.getVertex());
    }
}