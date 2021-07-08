package com.swea.swea2043;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        //증가시키면서 카운트할 필요없이 빼고 +1하면 될것
        Scanner s = new Scanner(System.in);
        int     p = s.nextInt();
        int     k = s.nextInt();
        int   cnt = (int)Math.abs(p-k)+1;

        System.out.println(cnt);

    }
}
