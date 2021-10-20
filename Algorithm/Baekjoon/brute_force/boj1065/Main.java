package baekjoon.brute_force.boj1065;

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
    static int N;
    //갯수세기
    static int cnt=0;
    //기록용 배열
    static int[] selected;

    static void input(){
        N=r.nextInt();
        selected=new int[N+1];
    }

    //한수 판별
    static int isHansu(int val){
        String value=String.valueOf(val);
        int flag=0;
        //한자리수 or 두자리수 인경우
        if(val>=1 && val<100) {
            return flag;
        }

        for(int i=0;i<value.length()-2;i++){
            int cur=value.charAt(i)-'0';
            int next=value.charAt(i+1)-'0';
            int next2=value.charAt(i+2)-'0';
            int diff1=cur-next;
            int diff2=next-next2;

            if(diff1!=diff2){
                flag=-1;
                break;
            }
        }

        return flag;
    }

    static void check(int k){
       int flag=0;
       if(k<100){
           System.out.println(k);
           System.exit(0);
       }
       cnt=99;
       for(int i=100;i<=k;i++){
           flag=isHansu(i);
           if(flag==-1)continue;
           else cnt++;

       }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        input();
        check(N);
    }
}
