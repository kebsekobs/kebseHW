package test;

import code.AjacencyMatrixGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest extends Assertions {
    @Test
    public void test_add_and_get_edge() {
        AjacencyMatrixGraph ajacencyMatrixGraph = new AjacencyMatrixGraph(5);
        ajacencyMatrixGraph.addEdge(0, 2, 10);
        ajacencyMatrixGraph.addEdge(2, 1, 3);
        assertEquals(10, ajacencyMatrixGraph.getEdge(0, 2));
        assertEquals(3, ajacencyMatrixGraph.getEdge(2, 1));
    }

    @Test
    public void test_delete_edge() {
        AjacencyMatrixGraph ajacencyMatrixGraph = new AjacencyMatrixGraph(5);
        ajacencyMatrixGraph.addEdge(0, 2, 10);
        ajacencyMatrixGraph.addEdge(2, 1, 3);
        ajacencyMatrixGraph.deleteEdge(0, 2);
        assertEquals(0, ajacencyMatrixGraph.getEdge(0, 2));
        assertEquals(3, ajacencyMatrixGraph.getEdge(2, 1));
    }

    @Test
    public void test_add_vertex() {
        AjacencyMatrixGraph ajacencyMatrixGraph = new AjacencyMatrixGraph(5);
        ajacencyMatrixGraph.addEdge(0, 2, 10);
        ajacencyMatrixGraph.addEdge(2, 1, 3);
        ajacencyMatrixGraph.addVertex();
        ajacencyMatrixGraph.addEdge(3, 5, 6);
        assertEquals(10, ajacencyMatrixGraph.getEdge(0, 2));
        assertEquals(3, ajacencyMatrixGraph.getEdge(2, 1));
        assertEquals(6, ajacencyMatrixGraph.getEdge(3, 5));
    }

    @Test
    public void test_cleanUp() {
        AjacencyMatrixGraph ajacencyMatrixGraph = new AjacencyMatrixGraph(5);
        ajacencyMatrixGraph.addEdge(0, 2, 10);
        ajacencyMatrixGraph.addEdge(2, 1, 3);
        ajacencyMatrixGraph.cleanUp();
        assertEquals(0, ajacencyMatrixGraph.getVertex());
    }
}