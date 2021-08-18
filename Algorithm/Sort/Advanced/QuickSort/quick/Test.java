package sorting.quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void splitFunc(List<Integer> list){
        List<Integer> temp=new ArrayList<>();
        int size=list.size();
        int pivot=list.get(0);
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();

        if(size<=1){
            return;
        }

        for(int idx=1; idx < size; idx++){
            if(pivot<list.get(idx)){
                right.add(list.get(idx));
            }else{
                left.add(list.get(idx));
            }
        }
        System.out.println("left: "+left);
        System.out.println("right: "+right);
        System.out.println("pivot: "+pivot);

        //2단계, 합치기
        temp.addAll(left);
        temp.addAll(Arrays.asList(pivot));
        temp.addAll(right);

        System.out.println("step2: merge left, pivot, right: "+temp);

    }

    public static void main(String[] args){
        List<Integer> list= new ArrayList<>(Arrays.asList(3,4,2));
        System.out.println("before: "+list);
        splitFunc(list);

    }
}
