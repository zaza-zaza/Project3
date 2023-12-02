public class Edge {

    private Vertex start;
    private Vertex end;
    private Double weight;

    public Edge(Vertex startV, Vertex endV, Double weight){
        this.start = startV;
        this.end = endV;
        this.weight = weight;
    }

    public Vertex getStart() {
        return this.start;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public Double getWeight() {
        return this.weight;
    }
}
