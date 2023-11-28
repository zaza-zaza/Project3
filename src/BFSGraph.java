public class BFSGraph extends URLinkedList {
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
    void addEdge(int rootNode){
        // initializing verices
        boolean visited[] = new boolean[vertices];

        // creating queue from linked list
        URLinkedList<Integer> q = new URLinkedList<>();

        // if the currnt node is visited enqueue
        visited[rootNode] = true;
        q.add(rootNode);

        while(q.size() != 0){
            // dequeue entry
            rootNode = q.pollFirst();
            System.out.println(rootNode + " ");

            // find adjacent nodes

            Iterator<Integer> i = adjList[rootNode].iterator();
        }
    }


}
