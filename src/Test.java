import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        Graph g = new Graph(true, false);

        try{
            Scanner s = new Scanner(new File("src/ur.txt"));
            while(s.hasNextLine()){
                String[] split = s.nextLine().split("\t");
                if(split[0].equals("i")){
                    Vertex v1 = g.addVertex(split[1]);
                    s.nextLine();
                    Vertex v2 = g.getVertexByValue(split[1]);
                    g.addEdge(v1, v2, v1.getDistance(Double.parseDouble(split[2]),Double.parseDouble(split[3])));
                }
            }
        } catch(IOException e){
            e.getCause();
        }
        g.print();
    }
}
