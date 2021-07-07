package com.swea.swea2071;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());//테스트케이스 수
        int i = 0;//iterator
        int sum = 0;
        int avg = 0;

        while(i < T){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            sum = 0;
            avg = 0;
            while(st.hasMoreTokens()){
                sum+=Integer.valueOf(st.nextToken());
            }

            avg = (int)(Math.round((double)sum/10));
            sb.append("#"+(i+1)+" ").append(avg+"\n");
            bw.write(sb.toString());
            i++;
        }
        bw.close();
        br.close();
    }
}
