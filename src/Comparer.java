import java.util.Objects;

public class Comparer implements Comparable<Comparer> {

    public Vertex v;
    public Double p;

    public Comparer(Vertex v, Double p){
        this.v = v;
        this.p = p;
    }
    @Override
    public int compareTo(Comparer o) {
        if (Objects.equals(this.p, o.p)){
            return 0;
        }
        else if (this.p > o.p){
            return 1;
        }
        else {
            return -1;
        }
    }
}
