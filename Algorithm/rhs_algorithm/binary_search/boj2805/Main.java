package rhs_algo.binary_search.boj2805;

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

    static FastReader r= new FastReader();
    //나무의 수
    static int N;
    //필요한 나무 높이
    static int M;
    //나무 높이들
    static int[] heights;

    static void input(){
        N=r.nextInt();
        M=r.nextInt();
        heights=new int[N+1];
        for(int i=1;i<=N;i++){
            heights[i]=r.nextInt();
        }
    }
    static boolean determination(int H){
        //H높이로 나무들을 잘랐을 때 M만큼을 얻을 수 있으면 true
//그 외에는 false반환
        long sum=0;
        for(int i=1;i<=N;i++){
            if(heights[i]>=H){
                sum+=(heights[i]-H);
            }
        }
       return sum>=M;//M이상으로 얻을 수 있는지
    }
    static void pro(){
//1 ≤ M ≤ 2,000,000,000
        long L=0, R=2000000000, ans=0;
//[L..R]범위 안에 정답 존재
//이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하기
        while(L<=R){
            long mid=(L+R)/2;
            if(determination((int) mid)){
                //M이상, 즉 자를 수 있는 경우
                ans=mid;//지금의 길이를 저장
                //최대를 봐야 하므로 오른쪽을 봐야 함
                L=mid+1;
            }else{
                R=mid-1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
