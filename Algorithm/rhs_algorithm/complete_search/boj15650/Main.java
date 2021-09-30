package rhs_algo.complete_search.boj15650;

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
            //이후 값: 이전값 다음값부터 선택할 수 있음
            for(int cand=selected[k-1]+1;cand<=N;cand++){
                //selected[k-1]+1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
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
