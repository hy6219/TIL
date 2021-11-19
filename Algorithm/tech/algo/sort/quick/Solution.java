package tech.algo.sort.quick;

import java.util.Arrays;

public class Solution {
    /**
     * 기준점을 기준으로 작은 값은 왼쪽에, 큰값은 오른쪽에 위치시키는 정렬
     *
     * 크기가 1이하인 경우는 코너케이스로 존재하기 때문에 시간복잡도는
     * O(NlogN)
     * */
    static void quickSort(int[] arr){
      pivotSort(arr,0,arr.length-1);
    }

    /**
     * @param arr:정렬할 배열
     * @param low: 현재 부분 배열의 가장 왼쪽
     * @param high:현재 부분 배열의 가장 오른쪽
     * */
    static void pivotSort(int[] arr,int low,int high){
        //low>=high 이면, 즉, 엇갈릴 때
        //정렬할 원소는 1개밖에 없기 때문에 바로 종료
        if(low>=high) return;

        //pivot은 왼쪽과 오른쪽으로 나누어졌을 때, 파티셔닝의 기준값
        int pivot=partition(arr,low,high);

        //왼쪽에 대해서 재귀적으로 수행
        pivotSort(arr,low,pivot-1);
        //오른쪽에 대해서 재귀적으로 수행
        pivotSort(arr,pivot+1,high);
    }


    /**
     * @param arr:정렬할 배열
     * @param left: 현재 부분 배열의 가장 왼쪽
     * @param right:현재 부분 배열의 가장 오른쪽
     * @return 최종적으로 위치한 피벗의 위치
     * */
    static int partition(int[] arr, int left,int right){
        int low=left;
        int high=right;
        int pivot=arr[left];//부분 리스트의 왼쪽을 피벗으로 설정
        //low<high일때까지 반복
        while(low<high){
            //low<high는 지키면서
            //가장 오른쪽 인덱스에서의 값이 기존 피벗보다 큰 경우, 가장 오른쪽 인덱스를 감소
            //<-기존 피벗보다 작은 값 찾기
            while(arr[high] > pivot && low<high){
                high--;
            }
            /**
             * low<high는 당연히 지키면서
             * 기존 피벗값보다 가장 왼쪽 인덱스에서의 값이 작은 경우 , 가장 왼쪽 인덱스를 증가
             * <- 기존 피벗보다 큰 값을 찾기
             * */
            while(arr[low] <= pivot && low<high){
                low++;
            }

            //기존 가장 왼쪽 인덱스와 현재 과정에 의해 처리된 인덱스 low를 교환
            swap(arr,left,low);
        }
        //가장 왼쪽에 위치하고 있는 피벗에 대한 인덱스 low를 반환
        return low;
    }

    static void swap(int[] arr, int a, int b){
        int temp=arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }

    public static void main(String[] args) {
        int[] arr1={3,4,2,1,5};
        System.out.println("before: "+Arrays.toString(arr1));
        quickSort(arr1);
        System.out.println("after: "+Arrays.toString(arr1));

    }
}
