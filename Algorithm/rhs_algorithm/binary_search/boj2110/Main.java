package rhs_algo.binary_search.boj2110;

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
    static FastReader r= new FastReader();
    static int N,C;
    static int[] A;//좌표

    static void input(){
        N=r.nextInt();
        C=r.nextInt();
        A=new int[N+1];
        for(int i=1; i<=N;i++){
            A[i]=Integer.valueOf(r.nextLine());
        }
    }

    static boolean determination(int D) {
        // D 만큼의 거리 차이를 둔다면 C 개 만큼의 공유기를 설치할 수 있는가?

        // 제일 왼쪽 집부터 가능한 많이 설치해보자!
        // D 만큼의 거리를 두면서 최대로 설치한 개수와 C 를 비교하자.
        //먼저 첫번째집은 설치했다고 하고 cnt=1로 해주고
        //last는 마지막에 설치한 집
        //처음에는 첫번째 집이 마지막집
        int cnt = 1, last = A[1];
        for(int i=2;i<=N;i++){
            if(A[i]-last>=D){
                //왼쪽으로 D이상인지 확인
                cnt++;
                last=A[i];//마지막 집
            }
        }

        return cnt >= C;//공유기 설치를 C개 이상 할 수 있는지 확인
    }

    static void pro() {
        // determination을 빠르게 하기 위해서 정렬해주자.
        Arrays.sort(A,1,N+1);
        //xi<= 10억
        int L = 1, R = 1000000000, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L<=R){
            int mid=(L+R)/2;

            if(determination(mid)){
                //설치 가능한 경우
                //오른쪽에 설치 가능한지 확인해야 함
                ans=mid;
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
