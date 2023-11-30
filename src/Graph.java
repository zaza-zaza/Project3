
public class Graph {

    public HashTable<String, Vertex> adjList; // ajdacency list
    public int edges;
    public int vertices; // track the number of vertices added to the graph


    public Heap<Edge> pq = new Heap<Edge>();

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


}
