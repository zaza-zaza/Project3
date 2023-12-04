import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        Graph g = new Graph(true, false);
        MyArrayList<Vertex> storeVertex1 = new MyArrayList<>();
        MyArrayList<Vertex> storeVertex2 = new MyArrayList<>();
        MyArrayList<String> ID = new MyArrayList<>();
        MyArrayList<String> name1 = new MyArrayList<>();
        MyArrayList<String> name2 = new MyArrayList<>();
        MyArrayList<String> x = new MyArrayList<>();
        MyArrayList<String> x1 = new MyArrayList<>();
        MyArrayList<String> x2 = new MyArrayList<>();
        MyArrayList<String> y = new MyArrayList<>();
        MyArrayList<String> y1 = new MyArrayList<>();
        MyArrayList<String> y2 = new MyArrayList<>();

        try{
            Scanner s = new Scanner(new File("src/ur.txt"));
            while(s.hasNextLine()){
                String[] split = s.nextLine().split("\t");
                if(split[0].equals("i")){
                    ID.add(split[1]);
                    x.add(split[2]);
                    y.add(split[3]);
                }
            }
        } catch(IOException e){
            e.getCause();
        }

        for(int i = 0; i < ID.size() / 2; i++){
            name1.add(ID.get(i));
        }
        for(int i = ID.size() - ID.size() / 2; i < ID.size(); i++){
            name2.add(ID.get(i));
        }
        for(int i = 0; i < x.size() / 2; i++){
            x1.add(x.get(i));
        }
        for(int i = x.size() - x.size() / 2; i < x.size(); i++){
            x2.add(x.get(i));
        }
        for(int i = 0; i < y.size() / 2; i++){
            y1.add(y.get(i));
        }
        for(int i = y.size() - y.size() / 2; i < y.size(); i++){
            y2.add(y.get(i));
        }

        for(int i = 0; i < name1.size(); i++){
            storeVertex1.add(new Vertex(name1.get(i)));
            storeVertex2.add(new Vertex(name2.get(i)));
            g.addVertex(name1.get(i));
            g.addVertex(name2.get(i));
            g.addEdge(storeVertex1.get(i),
                    storeVertex2.get(i),
                    storeVertex1.get(i).getDistance(Double.parseDouble(x1.get(i)),
                            Double.parseDouble(x2.get(i)), Double.parseDouble(y1.get(i)), Double.parseDouble(y2.get(i))));
        }


        g.print();


//        Dijkstra.shortestPath(g, vertexStore.get(1), vertexStore.get(55));

    }
}
