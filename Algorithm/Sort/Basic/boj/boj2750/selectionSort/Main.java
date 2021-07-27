package sorting.boj.boj2750.selectionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //선택정렬로 풀어볼 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());//테스트 케이스 수
        Integer[] arr = new Integer[T];
        //배열 입력
        for(int i = 0 ; i <T; i++){
            arr[i]=Integer.valueOf(br.readLine());
        }

        int minIdx = 0;

        for(int i = 0 ; i < T-1; i++){
            minIdx = i;

            for(int j = i+1;j <T ; j++){
                if(arr[minIdx]>arr[j]){
                    minIdx=j;
                }
            }

            int temp = 0;
            temp = arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=temp;

        }

        for(int i = 0; i < T; i++){
            System.out.println(arr[i]);
        }
    }
}
