import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map;

public class GPSGraph {

    public static class Graph {
        private Map<String, Coordinate> nodes;
        private Map<String, Map<String, String>> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashMap<>();
        }

        public void addNode(String nodeId, Coordinate coordinate) {
            nodes.put(nodeId, coordinate);
            edges.put(nodeId, new HashMap<>());
        }

        public void addEdge(String roadId, String node1, String node2) {
            edges.get(node1).put(node2, roadId);
            edges.get(node2).put(node1, roadId); // Assuming an undirected graph
        }

        public Coordinate getCoordinate(String nodeId) {
            return nodes.get(nodeId);
        }

        public String getRoadId(String node1, String node2) {
            return edges.get(node1).get(node2);
        }

        public List<String> bfs(String startNode) {
            List<String> result = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();

            queue.add(startNode);
            visited.add(startNode);

            while (!queue.isEmpty()) {
                String currentNode = queue.poll();
                result.add(currentNode);

                for (String neighbor : edges.get(currentNode).keySet()) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            return result;
        }
    }

    public static class Coordinate {
        private double latitude;
        private double longitude;

        public Coordinate(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }

    public static Graph readGPSData(String filename) throws FileNotFoundException {
        Graph graph = new Graph();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\t");
                String type = parts[0];
                String nodeId = parts[1];
                double latitude = Double.parseDouble(parts[2]);
                double longitude = Double.parseDouble(parts[3]);

                Coordinate coordinate = new Coordinate(latitude, longitude);
                graph.addNode(nodeId, coordinate);

                if (type.equals("i")) {
                    // Process intersection data
                } else if (type.equals("r")) {
                    // Process road data
                    String roadId = nodeId;
                    String node1 = parts[4];
                    String node2 = parts[5];
                    graph.addEdge(roadId, node1, node2);
                }
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        String filename = "src/ur.txt"; // Replace with the actual filename

        try {
            Graph gpsGraph = readGPSData(filename);

            // Example usage:
            // Perform BFS starting from node "GILBERT-LONG"
            List<String> bfsResult = gpsGraph.bfs("GILBERT-LONG");
            System.out.println("BFS result starting from GILBERT-LONG: " + bfsResult);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
