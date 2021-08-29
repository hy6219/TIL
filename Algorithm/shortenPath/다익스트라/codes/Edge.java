package daikstra;

public class Edge implements Comparable<Edge>{

    public int dist;
    public String vertex;

    public Edge(int dist,String vertex){
        this.dist=dist;
        this.vertex=vertex;
    }

    @Override
    public String toString(){
        return "Edge{vertex="+this.vertex+", dist="+dist+"}";
    }

    @Override
    public int compareTo(Edge o) {
        return this.dist-o.dist;
    }
}
