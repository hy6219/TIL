package com.swea.swea2072;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());//테스트케이스
        int i = 0;//iterator
        int sum = 0;

        while(i<T){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            StringBuilder sb = new StringBuilder();
            sum = 0;

            sb.append("#"+(i+1)+" ");
            while(st.hasMoreTokens()){
                int temp = Integer.valueOf(st.nextToken());
                //홀수인 경우(0은 홀수가 아니지만 영향은 없음)
                if(temp%2==1){
                    sum+=temp;
                }
            }

            sb.append(sum+"\n");
            bw.write(sb.toString());
            i++;
        }
        bw.close();
        br.close();
    }
}
