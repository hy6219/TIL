package com.swea.swea1936;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a= s.nextInt();
        int b=s.nextInt();
        //비기는 경우는 없음
        System.out.println((a>b)?"A":"B");
    }
}
