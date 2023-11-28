import javax.swing.tree.FixedHeightLayoutCache;
import java.sql.SQLOutput;

public class GraphEdge {
    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        static class Node{
            int value, weight;
            Node(int value, int weight){
                this.value = value;
                this.weight = weight;
            }
        }

        // creating adjacency list

        URLinkedList<URLinkedList<Node>> adjList = new URLinkedList<>();

        // creating graph constructor
        public Graph(URLinkedList<Edge> edges){

            for(int i = 0; i < edges.size();  i++){
                adjList.add(i, new URLinkedList<>());
            }

            // adding edges to the graph

            for(Edge e : edges){
                adjList.get(e.src).add(new Node(e.dest, e.weight));
            }
        }

        // printing the adjacency matrix
        public static void printMatrix(Graph graph){
            int srcVertex = 0;
            int listSize = graph.adjList.size();

            System.out.println("The vertices and edges of the graph");
            while(srcVertex < listSize){

                // adjacency list traversal
                for(Node edge : graph.adjList.get(srcVertex)){
                    System.out.println("Vertex: " + srcVertex + "==>" +
                            edge.value + " (" + edge.weight + ")");
                }
                System.out.println();
                srcVertex++;
            }
        }
    }

    public static void main(String[] args){
        URLinkedList<Edge> edges = new URLinkedList<>();

        edges.add(new Edge(0,1,2));
        edges.add(new Edge(0,2,4));
        edges.add(new Edge(1,2,4));
        edges.add(new Edge(2,0,5));
        edges.add(new Edge(2, 1, 4));
        edges.add(new Edge(3, 2, 3));
        edges.add(new Edge(4, 5, 1));
        edges.add(new Edge(5, 4, 3));

        Graph graph = new Graph(edges);

        Graph.printMatrix(graph);
    }
}
