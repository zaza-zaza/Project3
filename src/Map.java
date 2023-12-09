import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.border.*;

public class Map extends JFrame {

    private MyArrayList<Vertex> vertices;
    private int width, height;

    public static double x1,x2,y1,y2, minX, minY, maxX, maxY, scaleX, scaleY;

    public Map (MyArrayList<Vertex> vertices){
        this.vertices = vertices;


//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
//        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MyArrayList<Vertex> readIn(String file){
        MyArrayList<Vertex> vList = new MyArrayList<>();
        try{
            Scanner s = new Scanner(new File(file));
            while(s.hasNextLine()){
                String[] split = s.nextLine().split("\t");
                if(split[0].equals("i")){
                    vList.add(new Vertex(split[1], Double.parseDouble(split[2]), Double.parseDouble(split[3])));
                }
            }

        } catch (IOException e){
            e.getMessage();
        }
        return vList;
    }

    private void drawGraph(Graphics2D g2d){

        double minLat =  getMinLat(readIn("ur.txt"));
        double maxLat = getMaxLat(readIn("ur.txt"));
        double minLon = getMinLon(readIn("ur.txt"));
        double maxLon = getMaxLon(readIn("ur.txt"));
        getMaxLat(readIn("ur.txt"));
        for(int i = 0; i < vertices.size() - 1; i++){
            drawEdge(g2d, vertices.get(i), vertices.get(i + 1), minLat, minLon,  maxLat, maxLon);
        }

        for(int i = 0; i < vertices.size(); i++){
            drawVertex(g2d, vertices.get(i));
        }

    }

    public int scale(){
        return 1;
    }
    public double getMinLat(MyArrayList<Vertex> arr){
        double min = arr.get(0).getLatitude();
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getLatitude() < min){
                min = arr.get(i).getLatitude();
            }
        }
        return min;
    }
    public double getMaxLat(MyArrayList<Vertex> arr){
        double max = arr.get(0).getLatitude();
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getLatitude() > max){
                max = arr.get(i).getLatitude();
            }
        }
        return max;
    }
    public double getMinLon(MyArrayList<Vertex> arr){
        double min = arr.get(0).getLongitude();
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getLatitude() < min){
                min = arr.get(i).getLatitude();
            }
        }
        return min;
    }
    public double getMaxLon(MyArrayList<Vertex> arr){
        double max = arr.get(0).getLongitude();
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getLatitude() > max){
                max = arr.get(i).getLatitude();
            }
        }
        return max;
    }
    private void drawEdge(Graphics2D g2d, Vertex v1, Vertex v2, double minX, double minY, double maxX, double maxY){

        double x1 = scale() - (v1.getLatitude());
        double y1 = scale() - (v1.getLongitude());
        double x2 = scale() - (v2.getLatitude());
        double y2 = scale() - (v2.getLongitude());

        Line2D.Double l = new Line2D.Double(x1 * scale(), y1* scale(), x2* scale(), y2* scale());
        g2d.draw(l);
    }

    private void drawVertex(Graphics2D g2d, Vertex v){
        g2d.setColor(Color.BLUE);

        double x = 700 - (v.getLatitude());
        double y = 700 - (v.getLongitude());


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

        try{
            Scanner s = new Scanner(new File("ur.txt"));
            while(s.hasNextLine()){
                String[] split = s.nextLine().split("\t");
                if(split[0].equals("i")){
                    vList.add(new Vertex(split[1], Double.parseDouble(split[2]), Double.parseDouble(split[3])));
                }
            }

        } catch (IOException e){
            e.getMessage();
        }

//        for(Vertex v : vList){
//            System.out.println(v.getData() + " " + v.getLatitude() + " " + v.getLongitude());
//        }


        vList.add(a);
        vList.add(b);
        vList.add(c);
        vList.add(d);
        SwingUtilities.invokeLater(() -> new Map(vList));


    }

}