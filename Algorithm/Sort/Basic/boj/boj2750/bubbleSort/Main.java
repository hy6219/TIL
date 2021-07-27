package sorting.boj.boj2750.bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //버블정렬로 접근해볼 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());//테스트 케이스 수
        Integer[] arr = new Integer[T];
        //값 입력받을 것
        for(int i = 0 ; i < T; i++){
            arr[i]= Integer.valueOf(br.readLine());
        }

        for(int i = 0 ; i < T-1; i++){
            boolean swap = false;
            for(int j = 0; j < T-1-i; j++){
                int temp = 0;
                if(arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swap=true;
                }
            }

            if(swap==false){
                break;
            }
        }

        for(int i = 0 ; i < T; i++){
            System.out.println(arr[i]);
        }
    }
}
