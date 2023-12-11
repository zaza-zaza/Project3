import javax.swing.*;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


/**
 * @author Zachary Garson
 * zgarson@u.rochester.edu
 * 12/10/23
 * Project 3
 */
public class Test {
    static boolean show, showDirections = false;
    public static String file, startVertex, endVertex;

    public static void main(String[] args) throws IOException{

        // this section of the code accepts the arguments for the program to function
        String java = args[0];
        String StreetMap = args[1];
        file = args[2];

        for(int i = 0; i < args.length; i++){
            if(args[i].equals("--show")){
                show = true;
            } else if(args[i].equals("--directions")){
                showDirections = true;
                try {
                    startVertex = args[i + 1];
                    endVertex = args[i + 2];
                } catch (IndexOutOfBoundsException e){
                    e.getMessage();
                }
            }
        }

        // reading in the text file and packaging the data into vertices and edges for the graph class to accept
        Graph graph = new Graph(true, false);
        MyArrayList<Vertex> vertices = new MyArrayList<>();
        MyArrayList<Edge> edges = new MyArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts[0].equals("i")) {
                    // read in vertex entries
                    String vertexName = parts[1];
                    double latitude = Double.parseDouble(parts[2]);
                    double longitude = Double.parseDouble(parts[3]);

                    Vertex vertex = graph.addVertex(vertexName, latitude, longitude);
                    vertices.add(vertex);

                } else if (parts[0].equals("r")) {
                    // read in edge entries
                    String edgeName = parts[1];
                    Vertex v1 = graph.getVertexByValue(parts[2]);
                    Vertex v2 = graph.getVertexByValue(parts[3]);

                    if (v1 != null && v2 != null) {
                        // Calculate distance and add edges using the haversine function in the Vertex class
                        double weight = v1.getDistance(v1.getLatitude(), v2.getLatitude(), v1.getLongitude(), v2.getLongitude());
                        Edge e = graph.addEdge(v1, v2, weight);
                        edges.add(e);
                        // Since it's an undirected graph, add the reverse edge as well
                        graph.addEdge(v2, v1, weight);
                    } else {
                        System.out.println("Error: Vertices not found for edge.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double minLon = vertices.get(0).getLongitude();
        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i).getLongitude() < minLon){
                minLon = vertices.get(i).getLongitude();
            }
        }
        double maxLon = vertices.get(0).getLongitude();
        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i).getLongitude() > minLon){
                maxLon = vertices.get(i).getLongitude();
            }
        }
        double minLat = vertices.get(0).getLatitude();
        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i).getLongitude() < minLat){
                minLat = vertices.get(i).getLongitude();
            }
        }
        double maxLat = vertices.get(0).getLatitude();
        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i).getLongitude() > maxLat){
                maxLat = vertices.get(i).getLongitude();
            }
        }
        Dijkstra.shortestPath(graph, graph.getVertexByValue(startVertex), graph.getVertexByValue(endVertex), showDirections);
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setTitle("Map of " + file);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Map map = new Map(vertices, minLat, maxLat, minLon, maxLon);
        frame.add(map);
        frame.setVisible(show);
    }
}
