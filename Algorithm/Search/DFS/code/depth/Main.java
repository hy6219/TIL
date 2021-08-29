package search.depth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){
        HashMap<String, ArrayList<String>> mapData1=new HashMap<>();
        mapData1.put("A",new ArrayList<String>(Arrays.asList("B","C")));
        mapData1.put("B",new ArrayList<String>(Arrays.asList("A","D")));
        mapData1.put("C",new ArrayList<String>(Arrays.asList("A","G","H","I")));
        mapData1.put("D",new ArrayList<String>(Arrays.asList("B","E","F")));
        mapData1.put("E",new ArrayList<String>(Arrays.asList("D")));
        mapData1.put("F",new ArrayList<String>(Arrays.asList("D")));
        mapData1.put("G",new ArrayList<String>(Arrays.asList("C")));
        mapData1.put("H",new ArrayList<String>(Arrays.asList("C")));
        mapData1.put("I",new ArrayList<String>(Arrays.asList("C","J")));
        mapData1.put("J",new ArrayList<String>(Arrays.asList("I")));

        System.out.println("before: "+mapData1);

        DFSSearch dfs=new DFSSearch();
        ArrayList<String> list=dfs.dfsFunc(mapData1,"A");
        System.out.println("after: "+list);
    }

}
