package sorting.search.binary;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        BinarySearch b= new BinarySearch();
        int[] arr=new int[10];
        for(int i =0 ; i< 10; i++){
            arr[i]=(int)(Math.random()*100)+1;
        }

        System.out.println("before sorted: "+ Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("after sorted: "+Arrays.toString(arr));

        System.out.println("find 13: "+b.binarySearch(arr,13));
        System.out.println("find 6: "+b.binarySearch(arr,6));
    }
}
