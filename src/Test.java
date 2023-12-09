
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
    public String startInt;


    public static void main(String[] args) throws IOException{


        Graph graph = new Graph(true, false);
        MyArrayList<Vertex> vertices = new MyArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ur.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts[0].equals("i")) {
                    // It's a vertex entry
                    String vertexName = parts[1];
                    double latitude = Double.parseDouble(parts[2]);
                    double longitude = Double.parseDouble(parts[3]);

                    Vertex vertex = graph.addVertex(vertexName, latitude, longitude);
                    Vertex addV = new Vertex(vertexName, latitude, longitude);
                    vertices.add(addV);

                } else if (parts[0].equals("r")) {
                    // It's an edge entry
                    String edgeName = parts[1];
                    Vertex v1 = graph.getVertexByValue(parts[2]);
                    Vertex v2 = graph.getVertexByValue(parts[3]);

                    if (v1 != null && v2 != null) {
                        // Calculate distance and add edges
                        double weight = v1.getDistance(v1.getLatitude(), v2.getLatitude(), v1.getLongitude(), v2.getLongitude());
                        graph.addEdge(v1, v2, weight);
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

//        Vertex a = new Vertex("a", 500.0, 500.0);
//        Vertex b = new Vertex("b", 30.0, -100.0);
//
//        vertices.add(a);
        SwingUtilities.invokeLater(() -> new Map(vertices));
        for(Vertex v : vertices){
            System.out.println(v.getLatitude() + " " + v.getLongitude());
        }





        Dijkstra.shortestPath(graph, vertices.get(0), vertices.get(50));
    }
}
