package daikstra;

import java.util.*;

public class Daijkstra {

    public static void main(String[] args){
        HashMap<String, ArrayList<Edge>> map= new HashMap<>();

        map.put("A",new ArrayList<Edge>(Arrays.asList(new Edge(8,"B"),new Edge(1,"C"),new Edge(2,"D"))));
        map.put("B",new ArrayList<Edge>());
        map.put("C",new ArrayList<Edge>(Arrays.asList(new Edge(5,"B"),new Edge(2,"D"))));
        map.put("D",new ArrayList<Edge>(Arrays.asList(new Edge(3,"E"),new Edge(5,"F"))));
        map.put("E",new ArrayList<Edge>(Arrays.asList(new Edge(1,"F"))));
        map.put("F",new ArrayList<Edge>(Arrays.asList(new Edge(2,"A"))));

        ShortenTemplate st=new ShortenTemplate();
        System.out.println(st.dijkstraFunc(map,"A"));

        }



}
