public class Vertex implements Comparable<Vertex>{

    public final String ID;
    public double dist, longitude, latitude, ac, bc;
    public boolean visited;
    public Vertex path;
    public Vertex vertex1, vertex2;

    Vertex(String ID, double longitude, double latitude){
     this.ID = ID;
     this.longitude = longitude;
     this.latitude = latitude;
     this.dist = dist;
     this.ac = ac;
     this.bc =bc;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setPath(Vertex path) {
        this.path = path;
    }

    public double getDist(Vertex v1, Vertex v2) {
        // creating distance between vertices
        ac = Math.abs(v1.getLatitude() - v2.getLatitude());
        bc = Math.abs(v1.getLongitude() - v2.getLongitude());
        return Math.hypot(ac, bc);
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public boolean isVisited() {
        return visited;
    }

    public Vertex getPath() {
        return path;
    }

    @Override
    public int compareTo(Vertex o) {
        return 0;
    }
}
