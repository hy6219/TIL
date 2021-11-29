package baekjoon.brute_force.boj14501;

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

            try {
                str=br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

    }

    static FastReader scan=new FastReader();
    static int N;
    static int[] T,P,dp;

    static void input(){
        N=scan.nextInt();
        T=new int[N+2];//상담일을 벗어나게 될 경우 i+1까지 고려
        P=new int[N+2];
        dp=new int[N+2];

        for(int i=1;i<=N;i++){
            T[i]=scan.nextInt();
            P[i]=scan.nextInt();
        }
    }

    static void table(){
        for(int i=N;i>0;i--){
            //i번째 날의 상담완료날짜
            int day=i+T[i];

            if(day > N+1){
                //상담일 초과
                dp[i]=dp[i+1];
            }else{
                //상담일 초과x
                dp[i]=Math.max(P[i]+dp[day],dp[i+1]);
            }
        }
    }

    public static void main(String[] args) {
        input();
        table();
        System.out.println(dp[1]);//1일부터고려
    }
}
