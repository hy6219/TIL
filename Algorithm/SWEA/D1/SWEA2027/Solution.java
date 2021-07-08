package com.swea.swea2027;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 5; i++){
            for(int j = 0 ; j < i; j++){
                sb.append("+");
            }
            sb.append("#");
            for(int j =(i+1); j < 5; j++){
                sb.append("+");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
