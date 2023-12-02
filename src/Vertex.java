
public class Vertex {

    private String data;
    private MyArrayList<Edge> edges;
    protected Vertex v1, v2;
    protected Double distance, ac, bc, longitude, latitude;


    public Vertex(String name){
        this.data = name;
        this.edges = new MyArrayList<Edge>();
        this.longitude = longitude;
        this.latitude = latitude;
        this.v1 = v1;
        this.v2 = v2;
        this.ac = ac;
        this.distance = distance;
    }
    public void addEdge(Vertex endVertex, Double weight){
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public double getDistance(Vertex v1, Vertex v2){
        this.ac = Math.abs(v1.latitude - v2.latitude);
        this.bc = Math.abs(v1.longitude - v2.longitude);
        return Math.hypot(ac, bc);
    }

    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edges.getLast().equals(endVertex));
    }

    public String getData() {
        return this.data;
    }
    public MyArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void print(boolean showWeight) {
        String message = "";

        if (this.edges.size() == 0) { // changed this
            System.out.println(this.data + " -->");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStart().data + " -->  ";
            }

            message += this.edges.get(i).getEnd().data;

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
