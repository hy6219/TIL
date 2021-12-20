package baekjoon.brute_force.boj1747;

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

    static void pro(){

        N=scan.nextInt();

        //N부터 백만까지 보면서, 소수이면서 팰린드롬인지 확인
        while(true){
            boolean sosu=isSosu(N);
            boolean pelin=checkPelinDrome(N);
            if(sosu && pelin){
                System.out.println(N);
                break;
            }
            N++;
        }

    }

    static boolean isSosu(int value){
        if(value<=1) return false;

        for(int i=2;i<=Math.sqrt(value);i++){
            if(value%i==0) return false;
        }
        return true;
    }

    static boolean checkPelinDrome(int value){
        String val=String.valueOf(value);
        String rev=new StringBuilder(val).reverse().toString();

        return val.equals(rev);
    }

    public static void main(String[] args) {
        pro();
    }
}