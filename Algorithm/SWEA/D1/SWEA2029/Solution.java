package com.swea.swea2029;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.valueOf(s.nextLine());

        for(int i = 0 ; i <T; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            StringBuilder sb = new StringBuilder("#"+(i+1)+" "+(a/b)+" "+(a%b)+"\n");
            bw.write(sb.toString());
        }
        bw.close();

    }
}
