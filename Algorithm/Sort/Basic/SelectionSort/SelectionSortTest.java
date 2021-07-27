package sorting.selectionSort;

public class SelectionSortTest {
    public static void main(String[] args){
        SelectionSort selectionSort = new SelectionSort();
        Integer[] arr = new Integer[10];

        for(int i = 0 ; i < 10; i++){
            arr[i]=(int)(Math.random()*100)+1;
        }

        Integer[] sorted = selectionSort.selectionSort(arr);


    }
}
