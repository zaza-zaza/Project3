public class Graph {

    private URLinkedList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected){
        this.vertices = new URLinkedList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex v1, Vertex v2, Double weight){
        if(!this.isWeighted){
            weight = null;
        }
        v1.addEdge(v2, weight);
        if(!this.isDirected){
            v2.addEdge(v1, weight);
        }
    }

    public void removeEdge(Vertex v1, Vertex v2){
        v1.removeEdge(v2);
        if(!this.isDirected){
            v2.removeEdge(v1);
        }
    }

    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }
    public URLinkedList<Vertex> getVertices() {
        return this.vertices;
    }
    public boolean isWeighted(){
        return this.isWeighted;
    }
    public boolean isDirected(){
        return this.isDirected;
    }

    // searches for vertex in adj list
    public Vertex getVertexByValue(String value){
        for(Vertex v : this.vertices){
            if(v.getID() == value){
                return v;
            }
        }
        return null;
    }
    public void print(){
        for(Vertex v : this.vertices){
            v.print(isWeighted);
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(true, true);
        Vertex cliftonStation = g.addVertex("Clifton");
        Vertex capeMayStation = g.addVertex("Cape May");

        g.addEdge(cliftonStation, capeMayStation, 1000.0);
        g.print();
    }
}
