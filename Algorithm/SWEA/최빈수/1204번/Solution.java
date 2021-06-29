package com.mode.freq;

import java.util.*;

public class Solution {
    public static void main(String[] main) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        //입력받기
        for(int j = 1 ; j <= T ;j++){
            //테스트케이스 번호가 주어짐
            int order= sc.nextInt();
            int score[] = new int[101];
            int max = 0;
            int result=0;
            for(int i = 0 ; i < 1000; i++){
                int temp = sc.nextInt();
                score[temp]++;
            }

            for(int i = 0; i < 101; i++){
                if(max <=score[i]){
                    max = score[i];
                    result = i;//i는 점수
                }
            }
            System.out.printf("#%d %d\n",order,result);
        }


    }
}
