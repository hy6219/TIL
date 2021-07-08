package com.swea.swea2070;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트케이스 수
        int T = Integer.valueOf(br.readLine());

        for(int i = 0 ; i < T; i++){
            String line = br.readLine();
            StringTokenizer st= new StringTokenizer(line);
            int first = Integer.valueOf(st.nextToken());
            int second=0;
            String res = "";
            while(st.hasMoreTokens()){
                second=Integer.valueOf(st.nextToken());
            }

            res =(first==second)?"=":((first>second)?">":"<");
            bw.write("#"+(i+1)+" "+res+"\n");
        }
        bw.close();
        br.close();

    }
}
