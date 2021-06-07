package code;

public class AjacencyMatrixGraph {
    int matrix[][];
    int vertex;

    public AjacencyMatrixGraph(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int start, int finish, int weight){
        if(start >= vertex | finish >= vertex | start < 0 | finish < 0){throwException();}
        matrix[start][finish] = weight;
    }

    public int getEdge(int start, int finish){
        if(start >= vertex | finish >= vertex | start < 0 | finish < 0){throwException();}
        return matrix[start][finish];
    }

    public void deleteEdge(int start, int finish){
        if(start >= vertex | finish >= vertex | start < 0 | finish < 0){throwException();}
        matrix[start][finish] = 0;
    }

    public void addVertex(){
        vertex++;
        int[][] newMatrix = new int[vertex][vertex];
        for (int i = 0; i < vertex - 1; i++){
            for (int j = 0; j < vertex - 1; j++){
                newMatrix[i][j] = matrix[i][j];
            }
        }
        matrix = newMatrix;
    }

    public void cleanUp(){
        matrix = new int[0][0];
        vertex = 0;
    }

    public void throwException(){
        throw new ArrayIndexOutOfBoundsException("ЭЭээээээ куда прёшь??!?!?!??!?");
    }

    public int getVertex(){return vertex;}

}
