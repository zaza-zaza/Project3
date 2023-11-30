import java.util.Iterator;

public class BFSGraph {
    private int vertices; // record number of vertices
    private URLinkedList<Integer> adjList[];

    // graph constructor

    BFSGraph(int v){
       vertices = v;
       adjList = new URLinkedList[v];
       for(int i = 0; i < v; i++){
           adjList[i] = new URLinkedList();
       }
    }
    // edge adding method
    void addEdge(int v, int w){
        adjList[v].add(w);
    }

    void BFS(int rootNode){
        // initializing verices
        boolean visited[] = new boolean[vertices];

        // creating queue from linked list
        URLinkedList<Integer> q = new URLinkedList<>();

        // if the current node is visited enqueue
        visited[rootNode] = true;
        q.add(rootNode);

        while(q.size() != 0){
            // dequeue entry
            rootNode = q.pollFirst();
            System.out.println(rootNode + " ");

            // find adjacent nodes

            Iterator<Integer> i = adjList[rootNode].iterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args){
        BFSGraph g = new BFSGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        //print BFS sequence
        System.out.println("Breadth-first traversal of graph with 0 as starting vertex:");
        g.BFS(0);
    }

}
