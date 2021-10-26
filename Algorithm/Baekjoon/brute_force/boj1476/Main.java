package baekjoon.brute_force.boj1476;

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
    static int E,S,M;
    static int[] earth,sun,moon;

    static void input(){
        E=scan.nextInt();
        S=scan.nextInt();
        M=scan.nextInt();

        earth=new int[10001];
        sun=new int[10001];
        moon=new int[10001];
    }

    static void dp(){
        //초기값잡아주기
        for(int i=1;i<=15;i++){
            earth[i]=i;
            sun[i]=i;
            moon[i]=i;
        }

        for(int i=16;i <=19;i++){
            sun[i]=i;
            moon[i]=i;
        }

        for(int i=20; i<=28;i++){
            sun[i]=i;
        }

        //earth
        for(int i=16;i< earth.length;i++){
            if(i%15==0){
                earth[i]=earth[15];
            }else{
                earth[i]=earth[i%15];
            }
        }

        //sun
        for(int i=29;i<sun.length;i++){
            if(i%28==0){
                sun[i]=sun[28];
            }else{
                sun[i]=sun[i%28];
            }
        }

        //moon
        for(int i=20;i<moon.length;i++){
            if(i%19==0){
                moon[i]=moon[19];
            }else{
                moon[i]=moon[i%19];
            }
        }
    }

    static void pro(){
        input();
        dp();

        int yr=0;
        for(int i=1;i < sun.length;i++){
            int e1=earth[i];
            int s1=sun[i];
            int m1=moon[i];

            if(e1==E && s1==S && m1==M){
                yr=i;
                break;
            }
        }
        System.out.println(yr);
    }

    public static void main(String[] args) {
        pro();
    }
}
