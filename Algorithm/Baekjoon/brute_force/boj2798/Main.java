package baekjoon.brute_force.boj2798;

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
    static int N,M;
    static int[] card;
    static int MAX=Integer.MIN_VALUE;

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
        card=new int[N];

        for(int i=0;i<N;i++){
            card[i]=scan.nextInt();
        }
    }

    static void pro(){
        for(int cand=0;cand<N-2;cand++){
            for(int i=cand+1;i<N-1;i++){
                for(int j=i+1;j<N;j++){
                    int sum=card[cand]+card[i]+card[j];
                    if(sum>M) continue;

                    MAX=Math.max(MAX,sum);
                }
            }
        }
        System.out.println(MAX);
    }


    public static void main(String[] args) {
        input();
        pro();
    }
}
