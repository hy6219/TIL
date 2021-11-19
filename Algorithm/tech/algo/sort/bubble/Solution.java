package tech.algo.sort.bubble;

import java.util.Arrays;

public class Solution {
    /*
    * 인접한 두 원소를 비교하는데
    * 총 n-1회 비교가 필요하고
    * 내부에서는 2개씩 비교하는 과정이 필요
    * -시간복잡도: O(N^2)
    * */
    static int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            //2개씩 비교하다보면, 각 회를 종료하면
            //각 회에서의 맨 끝 원소는 비교할 필요가 없어짐
            boolean swap=false;//swap이 계속 false를 유지했다면 정렬이 다된 상태이므로 정렬을 더이상 할 필요가 없음
            for(int j=0;j<arr.length-1-i;j++){
                int temp=0;
                if(arr[j] > arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swap=true;
                }
            }
            if(!swap) break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1={3,4,2,1,5};
        int[] res1=bubbleSort(arr1);

        System.out.println(Arrays.toString(res1));
    }
}
