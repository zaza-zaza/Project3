import java.util.Iterator;

public class DFSGraph {

    private int vertices; // records the number of vertices

    // declaring adjacency matrix
    private URLinkedList<Integer> adjList[];

    // graph constructor
    DFSGraph(int v){

        vertices = v;
        adjList = new URLinkedList[v];
        for(int i = 0; i < v; i++){
            adjList[i] = new URLinkedList();
        }
    }


    // add edge method
    void addEdge(int v, int w){
        adjList[v].add(w);
    }

    // dfs helper function
    void dfsHelper(int v, boolean visited[]){

        // if the current node is visited
        visited[v] = true;
        System.out.print(v + " ");

        // find all adjecent verticies
        Iterator<Integer> i = adjList[v].iterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                dfsHelper(n, visited);
            }
        }
    }

    // chooses the starting vertex
    void DFS(int v){

        // initialize the vertices
        boolean visited[] = new boolean[vertices];

        dfsHelper(v, visited);
    }

    public static void main(String[] args){
        DFSGraph g = new DFSGraph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);

        g.DFS(0);
    }
}
