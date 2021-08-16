package sorting.merge;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        MergeSort ms = new MergeSort();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(7);

        System.out.println("before : "+list);
        System.out.println("---");
        list = ms.mergeSplitFunc(list);
        System.out.println("---");
        System.out.println("after: "+list);
    }
}
