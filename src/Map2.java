import javax.swing.*;
import java.awt.*;

public class Map2 extends JComponent {
    public Graph graph;
    public double domain, range = 0;

    Map2(Graph graph){
        graph = new Graph(true, false);
        setVisible(true);
    }

    public void paintComponent(Graphics g, Graph graph){
        domain = graph.getMaxLat() - graph.getMinLat();
        range = graph.getMaxLon() - graph.getMinLon();

        for(int i = 0; i <  graph.getVertices().size() - 1; i++){
            double x1 = this.getHeight() - ((this.getHeight() * (graph.getVertices().get(i).getLatitude() - graph.getMinLat())) / range);
            double y1 = ((this.getWidth() * (graph.getVertices().get(i).getLongitude())) / domain);
            double x2 = this.getHeight() - ((this.getHeight()*(graph.getVertices().get(i + 1).getLatitude() - graph.getMinLat())) / range);
            double y2 = ((this.getWidth() * (graph.getVertices().get(i + 1).getLongitude())) / domain);
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }

    public static void main(String[] args){


    }

}
