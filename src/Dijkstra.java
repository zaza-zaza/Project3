import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author Zachary Garson
 * zgarson@u.rochester.edu
 * 12/10/23
 * Project 3
 */
public class Dijkstra{

    public static HashTable[] dijkstra(Graph g, Vertex startV){
        HashTable<String, Double> dist = new HashTable<>();
        HashTable<String, Vertex> prev = new HashTable<>();
        PriorityQueue<Comparer> pq = new PriorityQueue<>();

        pq.add(new Comparer(startV, 0.0));

        // iterate through table and assign 0 or infinity to each value

        for(Vertex v : g.getVertices()){
            if(!v.equals(startV)){
                dist.put(v.getData(), Double.MAX_VALUE);
            }
            prev.put(v.getData(), new Vertex("Null", 0, 0));
        }

        dist.put(startV.getData(), 0.0);

        // find the shortest path so long as there are values in the queue
        while(pq.size() != 0){
            Vertex current = pq.poll().v;
            for(Edge e : current.getEdges()){
                Double alt = dist.get(current.getData()) + e.getWeight();
                String neighbor = e.getEnd().getData();
                if(alt < dist.get(neighbor)){
                    dist.put(neighbor, alt);
                    prev.put(neighbor, current);
                    pq.add(new Comparer(e.getEnd(), dist.get(neighbor)));
                }
            }
        }

        return new HashTable[]{dist, prev};
    }

    public static void pathPrinter(HashTable[] table){
        System.out.println("Distances:");

        // iterates through and prints each path along the way
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


    public static void shortestPath(Graph g, Vertex startV, Vertex dest, boolean showDirections){
        HashTable[] dijkstraTable = dijkstra(g, startV);
        HashTable dist = dijkstraTable[0];
        HashTable prev = dijkstraTable[1];

        // returns the shortest
        Double dDist = (Double) dist.get(dest.getData());
        if(showDirections) {
            System.out.println("Shortest distance between " + startV.getData() + " and " + dest.getData() + ":");
            System.out.println(dDist + " meters.");
        }
        MyArrayList<Vertex> shortPath = new MyArrayList<>();
        Vertex v = dest;

        // store array of the roads along the shortest path
        while(v.getData() != "Null"){
            shortPath.add(0, v);
            v = (Vertex) prev.get(v.getData());
        }

        // if "--directions" print the shortest path
        if(showDirections) {
            System.out.println("Shortest path: ");
            for (Vertex pathV : shortPath) {
                System.out.println(pathV.getData());
            }
        }
    }
}