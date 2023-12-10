public class Graph { // graph class adapted from: https://www.youtube.com/watch?v=dS44jZyj5gU&ab_channel=freeCodeCamp.org

    private MyArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    private double latitude, longitude;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected){
        this.vertices = new MyArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data, double latitude, double longitude){
        Vertex newVertex = new Vertex(data, latitude, longitude);
        this.vertices.add(0, newVertex);
        return newVertex;
    }

    public Edge addEdge(Vertex v1, Vertex v2, Double weight){
        if(!this.isWeighted){
            weight = null;
        }
        v1.addEdge(v2, weight);
        if(!this.isDirected){
            v2.addEdge(v1, weight);
        }
        return null;
    }

    public void removeEdge(Vertex v1, Vertex v2){
        v1.removeEdge(v2);
        if(!this.isDirected){
            v2.removeEdge(v1);
        }
    }

    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }
    public MyArrayList<Vertex> getVertices() {
        return this.vertices;
    }
    public boolean isWeighted(){
        return this.isWeighted;
    }
    public boolean isDirected(){
        return this.isDirected;
    }

    // searches for vertex in adj list
    public Vertex getVertexByValue(String value){
        for(Vertex v : this.vertices){
            if(v.getData().equals(value)){
                return v;
            }
        }
        return null;
    }
    public void print(){
        for(Vertex v : this.vertices){
            v.print(isWeighted);
        }
    }

    public double getMinLat (){
        double min = this.vertices.get(0).getLatitude();
        for(Vertex v :vertices){
            if(min > v.getLatitude()){
                min = v.getLatitude();
            }
        }
        return min;
    }
    public double getMinLon (){
        double min = this.vertices.get(0).getLongitude();
        for(Vertex v :vertices){
            if(min > v.getLongitude()){
                min = v.getLongitude();
            }
        }
        return min;
    }
    public double getMaxLat (){
        double max = this.vertices.get(0).getLatitude();
        for(Vertex v :vertices){
            if(max < v.getLatitude()){
                max = v.getLatitude();
            }
        }
        return max;
    }
    public double getMaxLon (){
        double max = this.vertices.get(0).getLatitude();
        for(Vertex v :vertices){
            if(max < v.getLatitude()){
                max = v.getLatitude();
            }
        }
        return max;
    }


}
