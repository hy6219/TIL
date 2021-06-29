package com.recursive.swea1217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static int getResult(int base, int digit){

        if(digit>0){
            return base*getResult(base, digit-1);
        }else{
            return 1;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int order = 0;
        int res =0;
        for(int i = 0; i < 10; i++){
            order = Integer.valueOf(br.readLine());
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            StringBuilder sb = new StringBuilder();
            int base = Integer.valueOf(st.nextToken());
            int digit =0;
            while(st.hasMoreTokens()){
                digit= Integer.valueOf(st.nextToken());
            }
       //     System.out.println("base: "+base+", digit: "+digit);
            res = getResult(base,digit);
            sb.append("#"+order+" ").append(res+"\n");
            bw.write(sb.toString());
        }

        bw.close();
        br.close();
    }
}
