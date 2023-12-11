
public class Vertex { // vertex class adapted from: https://www.youtube.com/watch?v=dS44jZyj5gU&ab_channel=freeCodeCamp.org

    private String data;
    private MyArrayList<Edge> edges;
    protected Vertex v1, v2;
    protected Double distance, ac, bc, longitude, latitude;


    public Vertex(String name, double latitude, double longitude){
        this.data = name;
        this.edges = new MyArrayList<Edge>();
        this.longitude = longitude;
        this.latitude = latitude;
        this.v1 = v1;
        this.v2 = v2;
        this.ac = ac;
        this.distance = distance;
    }
    public void addEdge(Vertex endVertex, Double weight) {
        this.edges.add(0, new Edge(this, endVertex, weight));
    }

    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude(){
        return longitude;
    }

//    public double getDistance(Double x1, Double x2, Double y1, Double y2){
//        this.ac = Math.abs(x1 - x2);
//        this.bc = Math.abs(y1 - y2);
//        return Math.hypot(ac, bc);
//    }

    // haversine algorithm to adjust distance to the curvature of the earth source:
    //https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/#
    public double getDistance(Double x1, Double x2, Double y1, Double y2){
        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);

        // Haversine formula
        double dlat = x2 - x1;
        double dlon = y2 - y1;
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(x1) * Math.cos(x2) * Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Radius of the Earth in kilometers (mean value)
        double R = 6371.0;

        // Calculate the distance in kilometers
        double distance = R * c;

        // Convert distance to meters
        return distance * 1000;
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

    // converts the decimal lat and lon to cartesian coords in meters
    public double getX(){
        // cartesian coordinates of latitude in meters
        return 6378100 * Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
    }
    public double getY(){
        // cartesian coordinates of latitude in meters
        return 6378100 * Math.cos(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
    }
}
