public class AdjMatrix {

    int vertices;
    int matrix[][];

    AdjMatrix(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int source, int destination){
        matrix[source][destination] = 1;
        matrix[destination][source] =1;
    }

    void printMatrix(){
        for(int i = 0; i < vertices; i++){
            for(int j =0; j < vertices; j++){
                System.out.println(matrix[i][j] + "");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        AdjMatrix adj = new AdjMatrix(5);

        adj.addEdge(4, 4);
        adj.printMatrix();
    }
}
