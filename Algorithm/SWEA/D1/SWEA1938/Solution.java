package com.swea.swea1938;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int    a =s.nextInt();
        int    b= s.nextInt();
        StringBuilder sb = new StringBuilder((a+b)+"\n"+(a-b)+"\n"+(a*b)+"\n"+(a/b));
        System.out.println(sb);
    }
}
