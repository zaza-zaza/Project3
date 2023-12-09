import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Map extends JFrame {

    private MyArrayList<Vertex> coordinates; // Latitude and longitude coordinates

    public Map(MyArrayList<Vertex> coordinates) {
        super("GeoGraph Drawer");

        this.coordinates = coordinates;

        int w = 900;
        int h = 900;


        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void drawGeoGraph(Graphics2D g2d) {
        // Draw edges
        for (int i = 0; i < coordinates.size() - 1; i++) {
            Vertex v1 = coordinates.get(i);
            Vertex v2 = coordinates.get(i + 1);

            // Draw edge between coordinates i and i + 1
            drawEdge(g2d, v1, v2, 900, 900);
        }

        // Draw vertices
        for (Vertex coordinate : coordinates) {
            // Draw vertex at the coordinate
            drawVertex(g2d, coordinate);
        }
    }

    private void drawEdge(Graphics2D g2d, Vertex v1, Vertex v2, int w, int h) {
        g2d.setColor(Color.BLACK);

        // Assuming simple scaling for illustration purposes
//        int x1 = (int) (coord1.getX() * 1);
//        int y1 = (int) (coord1.getY() * 1);
//        int x2 = (int) (coord2.getX() * 1);
//        int y2 = (int) (coord2.getY() * 1);

        double scaleX = w / (v2.getLatitude() - v1.getLongitude());
        double x1 = v1.getLatitude();
        double y1 = v1.getLongitude();
        double x2 = v2.getLatitude();
        double y2 = v2.getLongitude();

        Line2D.Double l = new Line2D.Double(x1, y1, x2, y2);
        g2d.draw(l);
//        g2d.drawLine(x1, y1, x2, y2);
    }

    private void drawVertex(Graphics2D g2d, Vertex coordinate) {
        g2d.setColor(Color.BLUE);

        // Assuming simple scaling for illustration purposes

        double x = coordinate.getLatitude();
        double y = coordinate.getLongitude();
        // Draw a circle to represent the vertex
        Ellipse2D.Double ellipse = new Ellipse2D.Double(x - 5, y - 5, 10, 10);
        g2d.fill(ellipse);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGeoGraph(g2d);
    }

    public static void main(String[] args) {
        // Example coordinates for a simple geographical graph
        MyArrayList<Vertex> coordinates = new MyArrayList<>();
        coordinates.add(new Vertex("a", 43.129807, 770.62742));
        coordinates.add(new Vertex("b", 43.12966, 77.628598));
        coordinates.add(new Vertex("c", 43.130478, 77.626726));
        coordinates.add(new Vertex("d",43.131081, 77.62623));
        coordinates.add(new Vertex("e", 43.131338, 77.625693));
        coordinates.add(new Vertex("f", 100.0, 200.0));
//        coordinates.add(new Vertex(100.0, 300.0));
//        coordinates.add(new Vertex(300.0, 250.0));
//        coordinates.add(new Ver)


        SwingUtilities.invokeLater(() -> new Map(coordinates));
    }
}
