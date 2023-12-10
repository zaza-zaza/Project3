
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

}
