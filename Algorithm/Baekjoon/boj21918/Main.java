package baekjoon.boj21918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        //전구갯수
        int n=Integer.valueOf(st.nextToken());
        //명령어 갯수
        int m=Integer.valueOf(st.nextToken());
        //전구 초기상태
        st=new StringTokenizer(br.readLine());
        int[] bulbs=new int[n];

        for(int i=0;i< bulbs.length;i++){
            bulbs[i]=Integer.valueOf(st.nextToken());
        }

        for(int i=0; i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.valueOf(st.nextToken());
            int b=Integer.valueOf(st.nextToken());
            int c=Integer.valueOf(st.nextToken());

            if(a==1){
                //i->x
                bulbs[b-1]=c;
            }else if(a==2){
                //[l,r]토글
                for(int j=b;j<=c;j++){
                    bulbs[j-1]=1-bulbs[j-1];
                }
            }else if(a==3){
                //off
                for(int j=b;j<=c;j++){
                    bulbs[j-1]=0;
                }
            }else{
                //on
                for(int j=b;j<=c;j++){
                    bulbs[j-1]=1;
                }
            }

        }
        for(int i=0;i< bulbs.length;i++){
            System.out.print(bulbs[i]+" ");
        }
    }
}
