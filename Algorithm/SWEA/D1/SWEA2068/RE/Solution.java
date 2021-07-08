package com.swea.swea2068.re;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = Integer.valueOf(s.nextLine());//테스트케이스 수

        for(int i = 0 ; i  <T ;i++){
            int max = 0;
            for(int j = 0; j < 10; j++){
                int temp = s.nextInt();
                if(temp>max){
                    max = temp;
                }
            }
            System.out.println("#"+(i+1)+" "+max);

        }
    }
}
