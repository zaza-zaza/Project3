public class Edge { // Edge class adapted from https://www.youtube.com/watch?v=dS44jZyj5gU&ab_channel=freeCodeCamp.org

    private Vertex start;
    private Vertex end;
    private Double weight;

    // store the vertices with the weight
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
