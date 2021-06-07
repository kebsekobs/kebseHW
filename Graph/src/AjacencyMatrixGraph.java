public class AjacencyMatrixGraph {
    int matrix[][];
    int vertex;

    public AjacencyMatrixGraph(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int start, int finish, int weight){
        matrix[start][finish] = weight;
    }

    public int getEdge(int start, int finish){
        return matrix[start][finish];
    }

    public void deleteEdge(int start, int finish){
        matrix[start][finish] = 0;
    }

    public void addVertex(){
        vertex++;
        int[][] newMatrix = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++){
            for (int j = 0; j < vertex; j++){
                newMatrix[i][j] = matrix[i][j];
            }
        }
        matrix = newMatrix;
    }

    public void cleanUp(){
        matrix = new int[0][0];
    }

}
