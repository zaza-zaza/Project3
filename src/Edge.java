public class Edge implements Comparable<Edge> {

    public final String ID;
    public double weight;
    public Vertex v, w;

    Edge(String ID, Vertex v, Vertex w){
        this.ID = ID;
        this.weight = weight;
        this.v = v;
        this.w = w;
    }
    public String getID() {
        return ID;
    }

    public double getWeight() {
        // edge weight for dijkstra's algorithm
        return v.getDist(v,w);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getV() {
        return v;
    }

    public void setV(Vertex v) {
        this.v = v;
    }

    public Vertex getW() {
        return w;
    }

    public void setW(Vertex w) {
        this.w = w;
    }


    @Override
    public int compareTo(Edge o) {
        return 0;
    }
}
