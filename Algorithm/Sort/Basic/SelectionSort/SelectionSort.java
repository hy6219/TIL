package sorting.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public Integer[] selectionSort(Integer[] arr){
        Integer[] res = arr.clone();
        int min = 0;
        int size = res.length;
        //n-1번 반복
        for(int i = 0 ; i < size-1; i++){
            int temp = 0;

            min = i;

            for(int j = i+1; j < size;j++){
                //min 인덱스값 찾기
                if(res[min]>res[j]){
                    min = j;
                }
            }

            //arr[min]<->arr[i]
            temp = res[i];
            res[i]=res[min];
            res[min]=temp;

            System.out.println("min: "+min);
            String format = String.format("#%d :%s",i,Arrays.toString(res));
            System.out.println(format);
        }

        return res;
    }

}
