package tech.algo.sort.insert;

import java.util.Arrays;

public class Solution {

    /**
     *해당 인덱스의 앞에 있는 데이터를 비교해서 그 인덱스의 값이 더 작으면 앞의 데이터의 앞자리에 위치시키는 정렬
     *
     * 시간복잡도:O(n^2)
     * */

    static int[] insertionSort(int[] arr){

        //두 번째 인덱스, 즉 인덱스1부터 시작
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                int temp=0;
                //arr[j]: 현재 해당 인덱스, arr[j-1]: 해당 인덱스의 앞 인덱스
                if(arr[j] < arr[j-1]){
                    temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr1={3,4,2,1,5};
        int[] res1=insertionSort(arr1);

        System.out.println(Arrays.toString(res1));
    }
}
