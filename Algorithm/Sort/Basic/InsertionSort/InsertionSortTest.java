package sorting.insertionSort;

import java.util.Arrays;

public class InsertionSortTest {

    public static void main(String[] args){
        InsertionSort insertionSort = new InsertionSort();
        Integer[] arr = new Integer[10];

        for(int i = 0 ; i < 10; i++){
            arr[i]=(int)(Math.random()*100)+1;
        }

        arr= insertionSort.insertionSort(arr);
        System.out.println("[FIN]arr: "+ Arrays.toString(arr));
        /*
        * original: [71, 5, 35, 46, 52, 43, 86, 76, 39, 21]
swap#i: 0, j: 1
#0 : [5, 71, 35, 46, 52, 43, 86, 76, 39, 21]
swap#i: 1, j: 2
#1 : [5, 35, 71, 46, 52, 43, 86, 76, 39, 21]
swap#i: 2, j: 3
#2 : [5, 35, 46, 71, 52, 43, 86, 76, 39, 21]
swap#i: 3, j: 4
#3 : [5, 35, 46, 52, 71, 43, 86, 76, 39, 21]
swap#i: 4, j: 5
swap#i: 4, j: 4
swap#i: 4, j: 3
#4 : [5, 35, 43, 46, 52, 71, 86, 76, 39, 21]
#5 : [5, 35, 43, 46, 52, 71, 86, 76, 39, 21]
swap#i: 6, j: 7
#6 : [5, 35, 43, 46, 52, 71, 76, 86, 39, 21]
swap#i: 7, j: 8
swap#i: 7, j: 7
swap#i: 7, j: 6
swap#i: 7, j: 5
swap#i: 7, j: 4
swap#i: 7, j: 3
#7 : [5, 35, 39, 43, 46, 52, 71, 76, 86, 21]
swap#i: 8, j: 9
swap#i: 8, j: 8
swap#i: 8, j: 7
swap#i: 8, j: 6
swap#i: 8, j: 5
swap#i: 8, j: 4
swap#i: 8, j: 3
swap#i: 8, j: 2
#8 : [5, 21, 35, 39, 43, 46, 52, 71, 76, 86]
[FIN]arr: [5, 21, 35, 39, 43, 46, 52, 71, 76, 86]
        *
        * */

    }

}
