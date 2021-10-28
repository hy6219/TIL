package baekjoon.brute_force.boj1107;

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
    static int channel=0;//현재채널
    static boolean[] check=new boolean[10];
    static int N,M;

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
        for(int i=0;i<M;i++){
            int except=scan.nextInt();
            //숫자제외시키기
            check[except]=true;
        }
    }

    static void pro(){
        //1.100부터 +,-를 이용하는 경우
        int standard=Math.abs(N-100);
        if(standard==0){
            System.out.println(0);
            System.exit(0);
        }
        //2.숫자버튼 누르는 경우
        for(int i=0;i<=1000000;i++){
            String s=String.valueOf(i);
            int len=s.length();

            boolean flag=false;
            for(int j=0;j<len;j++){
                if(check[s.charAt(j)-'0']){
                    flag=true;//고장난 경우 확인
                    break;
                }
            }
            if(!flag){
                int temp=Math.abs(N-i)+len;
                standard=Math.min(standard,temp);
            }
        }
        System.out.println(standard);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
