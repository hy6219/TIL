package rhs_algo.dp.boj9095;

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

    static void input(){
        N=scan.nextInt();
    }

    static int hap(int n){
        if(n==0) return 1;//0일때 초기값 1
        if(n<=2) return n;
        //그 외의 케이스
        return hap(n-3)+hap(n-2)+hap(n-1);
    }
    static StringBuilder sb=new StringBuilder();

    static void pro(){
        for(int i=0;i<T;i++){
            input();
            int res=hap(N);
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        T=scan.nextInt();
        pro();
    }
}
