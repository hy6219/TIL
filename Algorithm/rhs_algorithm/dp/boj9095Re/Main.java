package rhs_algo.dp.boj9095Re;

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

        double nextDouble(){
            return Double.valueOf(next());
        }

    }
    static FastReader scan=new FastReader();
    static int T;//테스트 케이스
    static int N;//N
    static int[] dy;

    static void input(){
        N=scan.nextInt();
    }

    static void preprocess(){
        dy=new int[11];
        //초기값 구하기
        dy[1]=1;
        dy[2]=2;
        dy[3]=4;
        //점화식을 토대로 dy배열 채우기
        //n은 양수이며 11보다 작다.
        for(int i=4;i<11;i++){
            dy[i]=dy[i-3]+dy[i-2]+dy[i-1];
        }
    }

    static StringBuilder sb=new StringBuilder();
    static void pro(){
        T=scan.nextInt();
        for(int i=1;i<=T;i++){
            N=scan.nextInt();
            sb.append(dy[N]).append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String[] args){
        preprocess();
        pro();

    }
}
