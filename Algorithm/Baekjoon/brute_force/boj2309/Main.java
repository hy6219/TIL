package baekjoon.brute_force.boj2309;

import java.io.*;
import java.util.Arrays;
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
    //키배열
    static int[] arr=new int[9];
    //안되는 경우 2개 픽
    static int a,b;
    //9개 요소 합
    static int stand=0;

    static void input(){
        for(int i=0;i<9;i++){
            arr[i]=r.nextInt();
            stand+=arr[i];
        }
        Arrays.sort(arr);
    }

    static void pro(){
        for(int cand=0;cand<=7;cand++){
            for(int sub=cand+1;sub<=8;sub++){
                int sum=stand-arr[cand]-arr[sub];
                if(sum==100){
                   a=cand;
                   b=sub;
                    break;
                }
            }
        }

        for(int i=0;i<9;i++){
            if(i==a || i==b) continue;
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
