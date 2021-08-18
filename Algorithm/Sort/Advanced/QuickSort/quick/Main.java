package sorting.quick;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        QuickSort qs=new QuickSort();
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(3,2,5,1,6,4,8,10,9,7));
        System.out.println("Before: "+arr);
        arr=qs.sort(arr);
        System.out.println("After: "+arr);
    }
}
