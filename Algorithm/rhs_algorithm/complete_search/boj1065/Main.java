package rhs_algo.complete_search.boj1065;

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
    //한수 체크
    static boolean[] hansu;
    //한수 갯수 카운트
    static int cnt=0;

    static void input(){
        N=r.nextInt();
        hansu=new boolean[N+1];
    }

    //한수인지 확인
    static void hansu(int k){
        if(k<10){
            hansu[k]=true;//한자리수
            cnt++;
            return;
        }else{
            //한자리 수가 아닌 경우 각 자리간 차이를 살펴보아야 함
            String temp=String.valueOf(k);
            boolean flag=true;//한번이라도 차이가 다르면 한수가 될 수 없음
            for(int i=0;i<temp.length()-2;i++){
                int a=temp.charAt(i)-'0';
                int b=temp.charAt(i+1)-'0';
                int c=temp.charAt(i+2)-'0';

                int diff1=a-b;
                int diff2=b-c;

                if(diff1!=diff2){
                    flag=false;
                    return;//한수가 될 수 없음
                }

            }
            if(flag){
                //한수인 경우
                hansu[k]=true;
                cnt++;
            }
        }
    }

    static void pro(){
        for(int cand=1;cand<=N;cand++){
            hansu(cand);
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
