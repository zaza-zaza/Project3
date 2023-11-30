public class Vertex implements Comparable<Vertex>{

    public final String ID;
    public double dist, longitude, latitude;
    public boolean visited;
    public Vertex path;

    Vertex(String ID, double longitude, double latitude){
     this.ID = ID;
     this.longitude = longitude;
     this.latitude = latitude;
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

    public double getDist() {
        return dist;
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
