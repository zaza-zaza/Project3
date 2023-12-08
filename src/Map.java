import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Map extends JFrame {

    private MyArrayList<Vertex> vertices;
    private int width, height;

    double x1,x2,y1,y2;

    public Map (MyArrayList<Vertex> vertices){
        this.vertices = vertices;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void drawGraph(Graphics2D g2d){


        for(int i = 0; i < vertices.size() - 1; i++){
            drawEdge(g2d, vertices.get(i), vertices.get(i + 1));
        }

        for(int i = 0; i < vertices.size(); i++){
            drawVertex(g2d, vertices.get(i));
        }

    }

    private void drawEdge(Graphics2D g2d, Vertex v1, Vertex v2){

        double x1 = 1000 - (v1.getLatitude());
        double y1 = 1000 - (v1.getLongitude());
        double x2 = 1000 - (v2.getLatitude());
        double y2 = 1000 - (v2.getLongitude());

        Line2D.Double l = new Line2D.Double(x1, y1, x2, y2);
        g2d.draw(l);
    }

    private void drawVertex(Graphics2D g2d, Vertex v){
        g2d.setColor(Color.BLUE);

        double x = 1000 - (v.getLatitude());
        double y = 1000 - (v.getLongitude());


        Ellipse2D.Double point = new Ellipse2D.Double(x - 5,
                y - 5, 5, 5);
        g2d.fill(point);

    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGraph(g2d);
    }

    public static void main(String[] args){
        MyArrayList<Vertex> vList = new MyArrayList<>();
        Vertex a = new Vertex("a", 10.1, 300.0);
        Vertex b = new Vertex("b", 30.0, 100.0);
        Vertex c = new Vertex("c", 300.0, 50.0);
        Vertex d = new Vertex("d", 30.0, 500.0);


        vList.add(a);
        vList.add(b);
        vList.add(c);
        vList.add(d);
        SwingUtilities.invokeLater(() -> new Map(vList));


    }

}