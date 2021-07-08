package com.swea.swea2047;

import java.util.Scanner;

public class Solution {
    //A: 65, a:97
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
       // System.out.println(line);
        for(int i = 0 ; i < line.length(); i++){
            char temp = line.charAt(i);
            int  code = (int)temp;//ascii code value
            if(temp>='a' && temp<='z'){
                code -=32;
                temp = (char)code;
            }
            System.out.print(temp);
        }
        System.out.println();
    }
}
