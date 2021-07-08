package com.swea.swea2050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    //A: 65, a:97
    public static void main(String[] args) throws IOException {
        //System.out.println("A: "+(int)'a');
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char   c ='\u0000';
        int i = 0;
        while(i < line.length()){
            c = line.charAt(i);
            int temp = (int)c-64;//1부터시작해야하므로 -65+1
            sb.append(temp+" ");
            i++;
        }

        System.out.println(sb.toString());

    }
}
