package com.swea.swea2063;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);//스캐너로 숫자한개씩 받는게 stringtokenizer를 부르는 것보다
        //나을수 있음
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(s.nextLine());//몇개 입력이 들어오게 될지
        //N은 홀수니까
        int midIdx = ((N+1)/2)-1;
        int[] arr = new int[N];
        int mid = 0;
        //배열에 값 넣기
        for(int i = 0 ; i < N; i++){
            arr[i] = s.nextInt();
        }

        //정렬
        Arrays.sort(arr);
        mid = arr[midIdx];

        bw.write(mid+"\n");
        bw.close();
    }
}
