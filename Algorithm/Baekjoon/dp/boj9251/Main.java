package baekjoon.dp.boj9251;

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
    static String s1="",s2="";
    static int[][] dp;

    static  void input(){
        s1=scan.nextLine();
        s2=scan.nextLine();
        dp=new int[s2.length()+1][s1.length()+1];
    }

    static void dynamic(){
        //b를 기준으로 비교
        for(int i=1;i<=s2.length();i++){
            for(int j=1;j<=s1.length();j++){
                if(s1.charAt(j-1)==s2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        dynamic();
        System.out.println(dp[s2.length()][s1.length()]);
    }
}
