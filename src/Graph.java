import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Graph { // graph class adapted from: https://www.youtube.com/watch?v=dS44jZyj5gU&ab_channel=freeCodeCamp.org

    private MyArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected){
        this.vertices = new MyArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data, double x, double y){
        Vertex newVertex = new Vertex(data, x, y);
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

    public static Graph loadGraphFromFile(String filePath) {
        Graph graph = new Graph(true, false);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts[0].equals("i")) {
                    // It's a vertex entry
                    String vertexName = parts[1];
                    double latitude = Double.parseDouble(parts[2]);
                    double longitude = Double.parseDouble(parts[3]);

                    Vertex vertex = graph.addVertex(vertexName, latitude, longitude);

                } else if (parts[0].equals("r")) {
                    // It's an edge entry
                    String edgeName = parts[1];
                    Vertex v1 = graph.getVertexByValue(parts[2]);
                    Vertex v2 = graph.getVertexByValue(parts[3]);

                    if (v1 != null && v2 != null) {
                        // Calculate distance and add edges
                        double weight = v1.getDistance(v1.getLongitude(), v2.getLongitude(), v1.getLatitude(), v2.getLatitude());
                        graph.addEdge(v1, v2, weight);
                        // Since it's an undirected graph, add the reverse edge as well
                        graph.addEdge(v2, v1, weight);
                    } else {
                        System.out.println("Error: Vertices not found for edge.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }


    public static void main(String[] args){
//        Graph g = new Graph(true, false);
//        Vertex cliftonStation = g.addVertex("Clifton");
//        Vertex capeMayStation = g.addVertex("Cape May");
//        Vertex a = g.addVertex("a");
//        Vertex b = g.addVertex("c");
//        Vertex c = g.addVertex("d");
//        Vertex d = g.addVertex("e");
//        Vertex e = g.addVertex("f");
//        Vertex f = g.addVertex("g");
//        Vertex h = g.addVertex("h");
//        Vertex i = g.addVertex("i");
//        Vertex j = g.addVertex("j");
//        Vertex k = g.addVertex("k");
//        Vertex l = g.addVertex("l");
//        Vertex m = g.addVertex("m");
//
//        g.addEdge(cliftonStation, capeMayStation, 1000.0);
//        g.addEdge(a,b, 2.0);
//        g.addEdge(b,c, 3.0);
//        g.addEdge(c,d, 4.0);
//        g.addEdge(d,e, 2.0);
//        g.addEdge(e,f, 5.0);
//        g.addEdge(f,h, 3.0);
//
//        g.print();
    }


}
