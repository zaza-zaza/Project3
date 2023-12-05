
public class Vertex { // vertex class adapted from: https://www.youtube.com/watch?v=dS44jZyj5gU&ab_channel=freeCodeCamp.org

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
        this.edges.add(0, new Edge(this, endVertex, weight));
    }

    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude(){
        return longitude;
    }

    public double getDistance(Double x1, Double x2, Double y1, Double y2){
        this.ac = Math.abs(x1 - x2);
        this.bc = Math.abs(y1 - y2);
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

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
