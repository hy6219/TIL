package sorting.bubbleSort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {5,2,4,6,1,7,8,3};
        int size = arr.length;
        //전체 반복 횟수를 의미
        for(int i = 0 ; i < size-1; i++){
            boolean swap = false;//한번이라도 교환되면 true

            //2개씩 비교-비교가 끝난(뒷부분) 부분은 제외하기 위해서 size-1-i전가지!
            for(int j=0; j < size-1-i;j++){
                int temp=0;
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swap = true;
                }
            }
            //swap이 되지 않아서 한번이라도 false가 걸리면 반복문 탈출
            if(swap==false){
                break;
            }
            String format = String.format("#%d: %s\n",i, Arrays.toString(arr));
            System.out.print(format);
            /*
            * #0: [2, 4, 5, 1, 6, 7, 3, 8]
#1: [2, 4, 1, 5, 6, 3, 7, 8]
#2: [2, 1, 4, 5, 3, 6, 7, 8]
#3: [1, 2, 4, 3, 5, 6, 7, 8]
#4: [1, 2, 3, 4, 5, 6, 7, 8]
            *
            * */
        }


    }
}
