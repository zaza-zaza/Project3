
public class Graph {

    public HashTable<String, Vertex> adjList; // adjacency list
    public int edges;
    public int vertices; // track the number of vertices added to the graph

    public int matrix[][];
    boolean visited[][];


    public Heap<Edge> pq = new Heap<>();

    // graph constructor
    Graph(){
        adjList = new HashTable<>();
        edges = 0;
        vertices = 0;
    }

    public void addVertex(Vertex vertex){
        adjList.put(vertex.ID, vertex);
        vertices++;
    }

    public void addVertex(Vertex vertex){

    }

    public static void main(String[] args){
//        Vertex v1 = new Vertex("v1", 13.5, 1.34);
//        Vertex v2 = new Vertex("v2", 100, 50);
//        Edge e = new Edge("e", v1, v2);
//        System.out.println(v1.getDist(v1, v2));
//        System.out.println(e.getWeight());
    }
}
