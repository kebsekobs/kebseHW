public class AjacencyMatrixGraph {
    int matrix[][];
    int vertex;

    public AjacencyMatrixGraph(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }
}
