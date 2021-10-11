package baekjoon.brute_force.boj2501;

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
    static int N,K;
    static int ans;

    static void input(){
        N=r.nextInt();
        K=r.nextInt();
    }

    static void pro(){
        int res=0;
        for(int i=1;i<=N;i++){
            //제곱근까지만 확인
            if(N%i==0) ++ans;
            if(ans==K){
                //K번째 수가 발견된것!
                res=i;
                break;
            }
        }
        //K번째 약수가 발견되지 못하면 0이 들어있을것
        System.out.println(res);

    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
