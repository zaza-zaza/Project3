
public class Vertex { // vertex class adapted from: https://www.youtube.com/watch?v=dS44jZyj5gU&ab_channel=freeCodeCamp.org

    private String data;
    private MyArrayList<Edge> edges;
    protected Vertex v1, v2;
    protected Double distance, ac, bc, longitude, latitude, x1, y1, x2, y2;


    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public Vertex(String name, double latitude, double longitude){
        this.data = name;
        this.edges = new MyArrayList<Edge>();
        this.latitude = latitude;
        this.longitude = longitude;
        this.v1 = v1;
        this.v2 = v2;
        this.ac = ac;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
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

    public double getDistance(double x1, double x2, double y1, double y2){
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
