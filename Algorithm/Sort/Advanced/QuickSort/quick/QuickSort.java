package sorting.quick;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list){
        ArrayList<Integer> merged=new ArrayList<>();
        int size= list.size();

        if(size<=1){
            return list;
        }
        int pivot =list.get(0);

        ArrayList<Integer> left= new ArrayList<>();
        ArrayList<Integer> right= new ArrayList<>();

        for(int i = 1; i < size; i++){
            if(list.get(i)>pivot){
                right.add(list.get(i));
            }else{
                left.add(list.get(i));
            }
        }

        merged.addAll(sort(left));
        merged.addAll(Arrays.asList(pivot));
        merged.addAll(sort(right));

        return merged;

    }

}
