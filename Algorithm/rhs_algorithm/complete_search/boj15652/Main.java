package rhs_algo.complete_search.boj15652;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class FastReader{
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
            while(st==null ||!st.hasMoreTokens()){
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
    static int N,M;
    static int[] selected;
    //초기화
    public static void input(){
        FastReader sc=new FastReader();
        N=sc.nextInt();
        M=sc.nextInt();
        selected=new int[M+1];
    }
    static StringBuilder sb=new StringBuilder();
    //재귀
    static void rec_func(int k){
        if(k==M+1){
            //다 탐색한 경우
            for(int i=1;i<=M;i++)sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            //탐색이 남은경우
            //비내림차순으로 적용될 필요가 있고
            //1 2==2 1 로 처리가 되므로 이부분을 주의! 즉 순서가 없음
            int start=selected[k-1];//이전에 사용된 값
            if(start==0) start=1;

            for(int cand=start;cand<=N;cand++){
                //start~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
                selected[k]=cand;
//매번 k+1번부터 M번 원소로 재취 호출해주기
                rec_func(k+1);
//더이상 방문할 필요가 없다면 방문이 필요없음을 명시해주기
                selected[k]=0;
            }
        }
    }

    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb);
    }
}
