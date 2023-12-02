
public class GraphTraverser {

    // depth first search traversal
    public static void DFS(Vertex start, MyArrayList<Vertex> visited){

        System.out.println(start.getData());

        for (Edge e: start.getEdges()) {
            Vertex neighbor = e.getEnd();

            if (!visited.contains(neighbor)) {
                visited.add(0, neighbor);
                GraphTraverser.DFS(neighbor, visited);
            }
        }
    }

    // breadth first search
    public static void BFS(Vertex start, MyArrayList<Vertex> visited){
        MyQueue<Vertex> visitedQ = new MyQueue<>();
        visitedQ.enqueue(start);
        while(!visitedQ.isEmpty()){
            Vertex current = visitedQ.dequeue();
            System.out.println(current.getData());

            for(Edge e: current.getEdges()){
                Vertex neighbor = e.getEnd();

                if(!visited.contains(neighbor)){
                    visited.add(0, neighbor);
                    visitedQ.enqueue(neighbor);
                }
            }
        }
    }

    public static void main(String[] args){

        // delete this later
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        MyArrayList<Vertex> visitedVertices1 = new MyArrayList<Vertex>();
        MyArrayList<Vertex> visitedVertices2 = new MyArrayList<Vertex>();
        visitedVertices1.add(0, startingVertex);
        visitedVertices2.add(0, startingVertex);
        System.out.println("DFS:");
        GraphTraverser.DFS(startingVertex, visitedVertices1);
        System.out.println("BFS:");
        GraphTraverser.BFS(startingVertex, visitedVertices2);

    }
}
