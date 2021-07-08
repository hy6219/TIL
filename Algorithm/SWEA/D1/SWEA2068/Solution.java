package com.swea.swea2068;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트케이스 수
        int T = Integer.valueOf(br.readLine());

        int[] arr = new int[10];

        for(int i = 0; i < T; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int j = 0;
            int max = 0;
            //배열입력받기
            while(st.hasMoreTokens()){
                arr[j] = Integer.valueOf(st.nextToken());
                j++;
            }
            j = 0;

            for(j = 0; j < 9; j++){
                for(int k = j+1; k < 10; k++){
                    if(arr[k] > max){
                        max = arr[k];
                    }
                }
            }

            bw.write("#"+(i+1)+" "+max+"\n");

        }
        bw.close();
        br.close();
    }

}
