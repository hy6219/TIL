package greedy;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        int x1=o1.distance;
        int x2=o2.distance;

        if(x1>x2){
            return 1;
        }
        return -1;
    }
}
