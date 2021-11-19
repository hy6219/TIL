package tech.algo.sort.selection;

import java.util.Arrays;

public class Solution {

    /**
     * 선택정렬은 배열 범위에서 최솟값을 찾고
     * 그 최솟값을 범위에서 맨 앞으로 위치하게 한 후
     * 맨 앞을 제외한 범위에서 동일한 과정을 수행하는 정렬!
     * -시간복잡도: O(N^2)
     * */

    static int[] selectionSort(int[] arr){

        int min=0;//인덱스로 저장할 것
        //i는 변동될 수 있는 변수이기 때문에
        //기록을 하기 위해서 min 변수를 이용

        for(int i=0;i<arr.length-1;i++){
            int temp=0;
            min=i;
            //최솟값 찾기
            for(int j=i+1;j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min=j;
                }
            }
            //위치 바꿔주기
            temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr1={3,4,2,1,5};
        int[] res1=selectionSort(arr1);

        System.out.println(Arrays.toString(res1));
    }
}
