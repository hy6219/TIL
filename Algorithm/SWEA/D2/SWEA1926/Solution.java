package com.swea.swea1926;

import java.util.Scanner;

public class Solution {
    public static String clap(int val){
        String temp= String.valueOf(val);
        int cnt = 0;
        String res ="";
        for(int i = 0 ; i < temp.length(); i++){
            char c = temp.charAt(i);
            if(c=='3'||c=='6'||c=='9'){
                cnt++;
            }
        }

        if(cnt==0){
            res = String.valueOf(val);
        }else{
            for(int i = 0 ; i < cnt; i++){
                res+="-";
            }
        }

        return res;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        StringBuilder sb =new StringBuilder();

        for(int i = 1; i <= n ;i++){
            sb.append(clap(i));
            if(i!=n){
                sb.append(" ");
            }
        }
        System.out.println(sb);

    }
}
