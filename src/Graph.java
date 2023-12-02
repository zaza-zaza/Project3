
public class Graph {

    private MyArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected){
        this.vertices = new MyArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(0, newVertex);
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
    public MyArrayList<Vertex> getVertices() {
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
            if(v.getData().equals(value)){
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
        Graph g = new Graph(true, false);
        Vertex cliftonStation = g.addVertex("Clifton");
        Vertex capeMayStation = g.addVertex("Cape May");
        Vertex a = g.addVertex("a");
        Vertex b = g.addVertex("c");
        Vertex c = g.addVertex("d");
        Vertex d = g.addVertex("e");
        Vertex e = g.addVertex("f");
        Vertex f = g.addVertex("g");
        Vertex h = g.addVertex("h");
        Vertex i = g.addVertex("i");
        Vertex j = g.addVertex("j");
        Vertex k = g.addVertex("k");
        Vertex l = g.addVertex("l");
        Vertex m = g.addVertex("m");

        g.addEdge(cliftonStation, capeMayStation, 1000.0);
        g.addEdge(a,b, 2.0);
        g.addEdge(b,c, 3.0);
        g.addEdge(c,d, 4.0);
        g.addEdge(d,e, 2.0);
        g.addEdge(e,f, 5.0);
        g.addEdge(f,h, 3.0);

        g.print();
    }
}
