package baekjoon.boj21920;

import java.util.*;

public class Main {
    static long n,x;
    static long[] arr=new long[500000];//수열
    public static long gcd(long a, long b){

        while(b!=0){
           long r=a%b;
           a=b;
           b=r;
        }
        return a;
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        n=s.nextLong();

        for(int i=0; i< n;i++){
            arr[i]=s.nextLong();
        }

        x=s.nextLong();
        long sum=0;
        long cnt=0;
        for(int i=0;i<n;i++){
            long gcd=gcd(x,arr[i]);
            if(gcd==1){
                sum+=arr[i];
                cnt++;
            }
        }

        double mean=(double)sum/cnt;

        System.out.printf("%.6f",mean);

    }
}
