package sorting.boj.boj2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //삽입정렬로 풀어볼 예정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());//테스트케이스 수
        Integer[] arr = new Integer[T];

        //입력
        for(int i = 0 ; i < T; i++){
            arr[i]= Integer.valueOf(br.readLine());
        }

        for(int i = 0 ; i < T-1; i++){

            for(int j = i+1; j >0 ;j--){
                int temp = 0;
                if(arr[j]<arr[j-1]){
                    temp =arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }else{
                    break;
                }
            }

        }
        for(int i = 0 ; i < T; i++){
            System.out.println(arr[i]);
        }
    }
}
