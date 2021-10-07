package rhs_algo.dp.boj11057;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br=new BufferedReader(new FileReader(new File(s)));
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

        long nextLong(){
            return Long.valueOf(next());
        }

        double nextDouble(){
            return Double.valueOf(next());
        }

    }

    static FastReader r=new FastReader();
    static int N;
    static int[][] dy;

    static void input(){
        N=r.nextInt();
        dy=new int[N+1][10];
    }

    static void dp(){
        //초기값
        for(int i=0;i<=9;i++){
            dy[1][i]=1;
        }

        //dp table
        for(int i=2;i<=N;i++){
            for(int j=0;j<=9;j++){
                for(int k=0;k<=j;k++){
                    dy[i][j]+=dy[i-1][k];
                    dy[i][j]%=10007;
                }
            }
        }

        int ans=0;//정답
        for(int i=0;i<=9;i++){
            ans+=dy[N][i];
            ans%=10007;
        }
        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        dp();
    }
}
