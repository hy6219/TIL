package baekjoon.boj21919;

import java.util.Scanner;

public class Boj21919 {
    //수열의 길이 n
    public static int n;

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        n=s.nextInt();

        long lcm=1;

        for(int i=0;i<n;i++){
            long input=s.nextInt();

            if(isSosu(input)){
                //소수이면
                lcm=lcm(lcm,input);
            }
        }

        if(lcm==1) {
            System.out.println(-1);
        }else{
            System.out.println(lcm);
        }

    }
    public static boolean isSosu(long n){

        if(n<=1) return false;

        for(long i=2; i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    //최대공약수
    public static long gcd(long a, long b){
        while(b!=0){
            long temp=a%b;
            a=b;
            b=temp;//gcd(a,b)=gcd(b,a%b)
        }
        return a;
    }
    public static long lcm(long a, long b){

        return a/gcd(a,b)*b;
    }
}
