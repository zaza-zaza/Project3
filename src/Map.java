import javax.swing.*;
import java.awt.*;


/**
 * @author Zachary Garson
 * zgarson@u.rochester.edu
 * 12/10/23
 * Project 3
 */
public class Map extends JComponent {

    public static MyArrayList<Vertex> vertices; // Latitude and longitude coordinates
    double minLat, minLon, maxLat, maxLon;
    double domain, range;



    public Map(MyArrayList<Vertex> vertices, double minLat, double maxLat, double minLon, double maxLon ){
        this.vertices = new MyArrayList<>();
        this.minLat = minLat;
        this.minLon = minLon;
        this.maxLat = maxLat;
        this.maxLon = maxLon;
    }


    public void paintComponent(Graphics g){
        domain = maxLat - minLat;
        range = maxLon - minLon;

        for(int i = 0; i < vertices.size(); i++){
            g.setColor(Color.BLACK);
            double x1 = this.getHeight() - ((this.getHeight() * (vertices.get(i).getLatitude() - minLat)));
            double y1 = ((this.getWidth()) * (vertices.get(i).getLatitude() - minLon)) / domain;
            double x2 = this.getHeight() - ((this.getHeight() * (vertices.get(i + 1).getLatitude() - minLat)));
            double y2 = ((this.getWidth()) * (vertices.get(i + 1).getLatitude() - minLon)) / domain;
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }

    }

    public static void main(String[] args){
        MyArrayList<Vertex> vertex = new MyArrayList<>();
        vertex.add(new Vertex("a", 100, 5));
        vertex.add(new Vertex("b", 1, 2));

        // getting the min and max for lon and lat
        double minLon = vertex.get(0).getLongitude();
        for(int i = 0; i < vertex.size(); i++){
            if(vertex.get(i).getLongitude() < minLon){
                minLon = vertex.get(i).getLongitude();
            }
        }
        double maxLon = vertex.get(0).getLongitude();
        for(int i = 0; i < vertex.size(); i++){
            if(vertex.get(i).getLongitude() > minLon){
                maxLon = vertex.get(i).getLongitude();
            }
        }
        double minLat = vertex.get(0).getLatitude();
        for(int i = 0; i < vertex.size(); i++){
            if(vertex.get(i).getLongitude() < minLat){
                minLat = vertex.get(i).getLongitude();
            }
        }
        double maxLat = vertex.get(0).getLatitude();
        for(int i = 0; i < vertex.size(); i++){
            if(vertex.get(i).getLongitude() > maxLat){
                maxLat = vertex.get(i).getLongitude();
            }
        }

        JFrame frame = new JFrame();
        Map map = new Map(vertex, minLat, maxLat, minLon, maxLon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setVisible(true);

    }


}