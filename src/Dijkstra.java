import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class Dijkstra{

    public static HashTable[] dijkstra(Graph g, Vertex startV){
        HashTable<String, Double> dist = new HashTable<>();
        HashTable<String, Vertex> prev = new HashTable<>();
        PriorityQueue<Comparer> pq = new PriorityQueue<>();

        pq.insert(new Comparer(startV, 0.0));

        // iterate through table and assign 0 or infinity to each value

        for(Vertex v : g.getVertices()){
            if(!v.equals(startV)){
                dist.put(v.getData(), Double.MAX_VALUE);
            }
            prev.put(v.getData(), new Vertex("Null"));
        }

        dist.put(startV.getData(), 0.0);

        while(pq.size() != 0){
            Vertex current = pq.deleteMin().v;
            for(Edge e : current.getEdges()){
                Double alt = dist.get(current.getData()) + e.getWeight();
                String neighbor = e.getEnd().getData();
                if(alt < dist.get(neighbor)){
                    dist.put(neighbor, alt);
                    prev.put(neighbor, current);
                    pq.insert(new Comparer(e.getEnd(), dist.get(neighbor)));
                }
            }
        }

        return new HashTable[]{dist, prev};
    }

    public static void pathPrinter(HashTable[] table){
        System.out.println("Distances:");

        for(Iterator keys = table[0].keys().iterator(); keys.hasNext();){
            String nextKey = keys.next().toString();
            System.out.println(nextKey + ": " + table[0].get(nextKey));
        }
        System.out.println();
        for(Iterator keys = table[1].keys().iterator(); keys.hasNext();){
            String nextKey = keys.next().toString();
            Vertex nextV = (Vertex) table[1].get(nextKey);
            System.out.println(nextKey + ": " + nextV.getData());
        }

    }

    public static void shortestPath(Graph g, Vertex startV, Vertex dest){
        HashTable[] dijkstraTable = dijkstra(g, startV);
        HashTable dist = dijkstraTable[0];
        HashTable prev = dijkstraTable[1];

        Double dDist = (Double) dist.get(dest.getData());
        System.out.println("Shortest distance between " + startV.getData() + " and " + dest.getData() + ":");
        System.out.println(dDist);

        MyArrayList<Vertex> shortPath = new MyArrayList<>();
        Vertex v = dest;

        while(v.getData() != "Null"){
            shortPath.add(0, v);
            v = (Vertex) prev.get(v.getData());
        }
        System.out.println("Shortest path: ");
        for(Vertex pathV : shortPath){
            System.out.println(pathV.getData());
        }
    }

    public static void main(String[] args){

        Graph testGraph = new Graph(true, true);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");

        testGraph.addEdge(a, c, 100.0);
        testGraph.addEdge(a, b, 3.0);
        testGraph.addEdge(a, d, 4.0);
        testGraph.addEdge(d, c, 3.0);
        testGraph.addEdge(d, e, 8.0);
        testGraph.addEdge(e, b, 2.0);
        testGraph.addEdge(e, f, 10.0);
        testGraph.addEdge(b, g, 9.0);
        testGraph.addEdge(e, g, 50.0);

        Dijkstra.pathPrinter(dijkstra(testGraph, a));
        shortestPath(testGraph, a, g);
    }
}