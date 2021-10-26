package baekjoon.brute_force.boj1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReMain {
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
    static int E,S,M;

    static void input(){
        E=scan.nextInt();
        S=scan.nextInt();
        M=scan.nextInt();
    }

    static void pro(){
        int e1=1,s1=1,m1=1;
        for(int yr=1;;yr++){
            if(E==e1 && S==s1 && M==m1){
                System.out.println(yr);
                return;
            }
            e1++;s1++;m1++;
            if(e1==16){
                e1=1;
            }
            if(s1==29){
                s1=1;
            }
            if(m1==20){
                m1=1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
