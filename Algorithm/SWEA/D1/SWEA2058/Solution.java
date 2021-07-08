package com.swea.swea2058;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int sum = 0;
        int len = line.length();
//반드시 자릿수로 접근한다기보다 문자열로 받아서 하나씩 쪼개면 되지 않을까 하여 접근
        for(int i = 0 ; i < len; i++){
            sum +=(int)(line.charAt(i)-'0');
        }
        System.out.println(sum);

    }
}
