package rhs_algo.dp.boj11726;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException{
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
    static int[] dy;


    static void input(){
        N=r.nextInt();
        dy=new int[1001];
    }

    static void pro(){
        //초기값 구하기
        dy[1]=1;
        dy[2]=2;
    //점화식을 토대로 dy 배열 체우기
        for(int i=3;i<=N;i++){
            dy[i]=(dy[i-1]+dy[i-2])%10007;
        }
    //dy[N] 즉, 찾은 경우의 수 출력
        System.out.println(dy[N]);
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
