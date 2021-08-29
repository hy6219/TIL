package daikstra;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args){
        Queue<Edge> pq=new PriorityQueue<>();

        pq.add(new Edge(2,"A"));
        pq.add(new Edge(5,"B"));
        pq.add(new Edge(1,"C"));
        pq.add(new Edge(7,"D"));

        System.out.println(pq);

        Edge edge=pq.poll();
        System.out.println(edge);
        System.out.println("after poll one: "+pq);
        System.out.println("size of priority queue: "+pq.size());
    }
}
