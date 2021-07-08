package com.swea.swea2046;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(N-->0){
            sb.append("#");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();


    }
}
