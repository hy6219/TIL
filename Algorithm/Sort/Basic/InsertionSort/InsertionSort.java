package sorting.insertionSort;

import java.util.Arrays;

public class InsertionSort {
    public Integer[] insertionSort(Integer[] arr){
        int size= arr.length;

        System.out.println("original: "+Arrays.toString(arr));
        for(int i = 0 ; i < size-1; i++){

            for(int j = i+1; j>0; j--){
                int temp = 0;

                if(arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                    System.out.printf("swap#i: %d, j: %d\n",i,j);
                }else{
                    break;//순서가 알맞은 경우
                }
            }
            String format= String.format("#%d : %s",i, Arrays.toString(arr));
            System.out.println(format);
        }

        return arr;
    }
}
