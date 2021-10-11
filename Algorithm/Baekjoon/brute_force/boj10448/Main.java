package baekjoon.brute_force.boj10448;

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
            while(st==null||!st.hasMoreTokens()){
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

        Double nextDouble(){
            return Double.valueOf(next());
        }

    }

    static FastReader r=new FastReader();
    static int T,K;
    static int[] dp=new int[1001];


    static void input(){
        K=r.nextInt();
    }

    //삼각수 미리 채워두기
    static void tri(){
        dp[1]=1;
        dp[2]=3;

        for(int k=3;k<=1000;k++){
            dp[k]=(k*(k+1))/2;
        }
    }

    static void pro(){
        int flag=0;//크기가 3이 되는 경우 확인하기
        Loop:
        for(int i=1;i<=K;i++){
            for(int j=1;j<=K;j++){
                for(int k=1;k<=K;k++){
                    int sum=0;
                    sum=dp[i]+dp[j]+dp[k];
                    if(sum==K){
                        flag=1;
                        break Loop;
                    }
                }
            }
        }
        System.out.println(flag);
    }

    public static void main(String[] args) {
        T=r.nextInt();
        tri();
        for(int i=0;i<T;i++){
            input();
            pro();
        }
    }
}
