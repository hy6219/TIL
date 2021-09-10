package baekjoon.boj2960;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] arr=new int[n+1];
        //2부터 n까지 채우기
        for(int i=2;i<arr.length;i++){
            arr[i]=1;
        }

        //배수 지우기(자기자신 제외)
        int res=0;
        int flag=0;

        for(int i=2;i<=n;i++){
            for(int j=i;j<=n;j+=i){
                if(arr[j]==0) continue ;

                arr[j]=0;//제외시키기
                flag++;

                if(flag==k){
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }



    }
}
