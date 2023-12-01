public class Vertex {

    private String ID;
    private URLinkedList<Edge> edges;

    public Vertex(String name){
        this.ID = name;
        this.edges = new URLinkedList<Edge>();
    }
    public void addEdge(Vertex endVertex, Double weight){
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edges.peekLast().equals(endVertex));
    }

    public String getID() {
        return this.ID;
    }
    public URLinkedList<Edge> getEdges() {
        return this.edges;
    }

    public void print(boolean showWeight) {
        String message = "";

        if (this.edges.size() == 0) {
            System.out.println(this.ID + " -->");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStart().ID + " -->  ";
            }

            message += this.edges.get(i).getEnd().ID;

            if (showWeight) {
                message += " (" + this.edges.get(i).getWeight() + ")";
            }

            if (i != this.edges.size() - 1) {
                message += ", ";
            }
        }
        System.out.println(message);
    }
}
