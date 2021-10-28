package baekjoon.brute_force.boj10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
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
    static int N;
    static int[] numeric;
    //기록용
    static int[] selected;
    static int[] used;
    static int max=Integer.MIN_VALUE;

    static void input(){
        N=scan.nextInt();
        numeric=new int[N];
        selected=new int[N];
        used=new int[N];

        for(int i=0;i<N;i++){
            numeric[i]=scan.nextInt();
        }
    }

    static void rec_func(int k){
        if(k==N){
            int sum=0;
            for(int i=0;i<=N-2;i++){
                sum+=Math.abs(selected[i]-selected[i+1]);
            }
            max=Math.max(max,sum);
            return;
        }else{
            for(int cand=0;cand<N;cand++){
                if(used[cand]==1) continue;
                selected[k]=numeric[cand]; used[cand]=1;
                rec_func(k+1);
                selected[k]=0; used[cand]=0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(max);
    }
}
