package baekjoon.brute_force.boj3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine(){
            String str="";

            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.valueOf(next());
        }

    }

    static FastReader scan=new FastReader();
    static int[] small=new int[9];
    static int[] selected=new int[7];

    static void input(){
        for(int i=0;i<9;i++){
            small[i]=scan.nextInt();
        }
    }

    static void rec_func(int start,int k){
        if(k==7){
            //7명 다 고른경우
            //합이 100인지 확인
            int sum=0;
            for(int i:selected){
                sum+=i;
            }

            if(sum==100){
                for(int i=0;i<7;i++){
                    System.out.println(selected[i]);
                }
            }

        }else{
            //중복x, 순서x
            for(int cand=start;cand<9;cand++){
                selected[k]=small[cand];
                rec_func(cand+1,k+1);
                selected[k]=0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0,0);

    }
}
