package com.swea.swea2019;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {
    //거듭제곱
    public static int  gudeup(int val, int base){
        if(base==0){
            return 1;
        }else{
            return val*gudeup(val,base-1);
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(System.in);
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        int n = s.nextInt();

        for(int i = 0 ; i <= n; i++){
            sb.append(gudeup(2,i));
            if(i!=n){
                sb.append(" ");
            }
        }

        bw.write(sb.toString());
        bw.close();


    }
}
