package sorting.search.sequential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequentialSearch {
    int[] arr;

    public void makeRdn(int limit,int size){
        this.arr = new int[size];

        for(int i =0 ; i < size; i++){
            arr[i]=(int)(Math.random()*limit)+1;
        }
    }

   public int seqSearch(int finder){
       int size= arr.length;


       for(int i =0; i < size; i++){
           if(arr[i]==finder){
               return i;
           }
       }
       return -1;
   }
}
