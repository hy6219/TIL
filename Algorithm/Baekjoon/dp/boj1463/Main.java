package baekjoon.dp.boj1463;

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
    static Integer[] dp;

    static void pro(){
        N=scan.nextInt();
        dp=new Integer[N+1];

        dp[0]=dp[1]=0;
        int res=rec_func(N);
        System.out.println(res);
    }

    static int rec_func(int val){
        if(dp[val]==null){
            if(val%6==0){
                dp[val]=Math.min(rec_func(val-1),Math.min(rec_func(val/3),rec_func(val/2)))+1;
            }else if(val%3==0){
                dp[val]=Math.min(rec_func(val/3),rec_func(val-1))+1;
            }else if(val%2==0){
                dp[val]=Math.min(rec_func(val/2),rec_func(val-1))+1;
            }else{
                dp[val]=rec_func(val-1)+1;
            }
        }
        return dp[val];
    }

    public static void main(String[] args) {
        pro();
    }
}
