package rhs_algo.dp.boj2579;

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

    static FastReader r= new FastReader();
    static int N;
    static int[] stair;
    static int[][] dy;

    static void input(){
        N=r.nextInt();
        stair=new int[N+1];
        dy=new int[N+1][2];

        for(int i=1;i<=N;i++){
            stair[i]=r.nextInt();
        }
    }


    static void pro(){
        //초기값 넣기

        dy[1][0]=0;//dy[0][0]을 밟지 않고 첫번째 계단에 도달한 경우
        dy[1][1]=stair[1];
        if(N>=2){
            dy[2][0]=stair[2];
            dy[2][1]=stair[1]+stair[2];
        }
        //점화식
        for(int i=3;i<=N;i++){
            dy[i][0]=Math.max(dy[i-2][0]+stair[i],dy[i-2][1]+stair[i]);//밟지 않을 경우와 밟을 경우로 나누어서 생각
            dy[i][1]=dy[i-1][0]+stair[i];
        }

        System.out.println(Math.max(dy[N][0],dy[N][1]));
    }


    public static void main(String[] args){
        input();
        pro();
    }
}
