package rhs_algo.binary_search.boj7795;

import java.io.*;
import java.util.ArrayList;
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

    static FastReader r=new FastReader();
    //테스트케이스 수
    static int T;
    //A,B배열 크기
    static int N,M;
    //A,B배열
    static int[] A,B;

    static void input(){
        N=r.nextInt();
        M=r.nextInt();
        A=new int[N+1];
        B=new int[M+1];

        for(int i=1;i<=N;i++){
            A[i]=r.nextInt();
        }

        for(int i=1;i<=M;i++){
            B[i]=r.nextInt();
        }
    }

    static int lower_bound(int[] A, int L, int R, int x){
        //A[L..R]에서 X미만의 수(X보다 작은 수 중 가장 오른쪽 수를 반환
//없다면 L-1을 반환
        int bound=L-1;

        while(L<=R){
            //가운데 위치 찍기
            int mid=(L+R)/2;
            if(A[mid]<x){
                //오른쪽보기
                bound=mid;//지금 위치 기록
                L=mid+1;
            }else if(A[mid]>=x){
                //왼쪽보기
                //그런데 bound에는 기록하지 않음<-미만만 상관쓸것이기 때문(그렇게 되면 최근까지 기록된 미만의 범위 중 상한값이 기록되거나 L-1이 기록되어있을것)
                R=mid-1;
            }
        }
        //다 돌아도 못찾았다면 L-1
        return bound;
    }

    static void pro(){
        //B배열에 대해 이분탐색을 하기 위해서 정렬
        Arrays.sort(B,1,M+1);
        int ans=0;

        for(int i=1;i<=N;i++){
            //A[i]를 선택했을 때 B에서는 A[i]보다 작은 것이 몇개가 있는지 카운트
            ans+=lower_bound(B,1,M,A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args){
        T=r.nextInt();
        for(int i=0;i<T;i++){
            input();
            pro();
        }
    }
}
