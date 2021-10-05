package rhs_algo.binary_search.boj2470;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
   //용액
    static int[] A;
    static StringBuilder sb=new StringBuilder();
    static void input(){
        N=r.nextInt();
       A=new int[N+1];
       for(int i=1;i<=N;i++){
           A[i]=r.nextInt();
       }
    }

    static int lower_bound(int[] A,int L,int R, int x){
//A[L..R]에서 X이상의 수 중 가장 왼쪽 인덱스를 찾기
//그런것이 없다면 R+1을 반환
        int bound=R+1;

        while(L<=R){
            int mid=(L+R)/2;

            if(A[mid]>=x){
                //왼쪽봐야 함!
                bound=mid;
                R=mid-1;
            }else if(A[mid]<x){
            //오른쪽 봐야 함
                L=mid+1;
            }
        }

        return bound;
    }
    static void pro(){
        //A에 대해서 정렬
        Arrays.sort(A,1,N+1);
//최솟값
        int best_sum=Integer.MAX_VALUE;
        int v1=0,v2=0;
        for(int left=1;left<=N-1;left++){
            //-A[left]와 가까운값을 left+1...N에서 찾기
            int cand=lower_bound(A,left+1,N,-A[left]);
//A[cand-1],A[cand] 중 A[left]와 섞었을 때 정보를 정답에 갱신
            //단, cand(res) 혹은 cand(res)-1가 left+1...N 사이에 들어오는 값인지 확인해주어야 함
            if(left+1<=cand-1 && cand-1<=N && Math.abs(A[left]+A[cand-1])<best_sum){
                best_sum=Math.abs(A[left]+A[cand-1]);
                v1=A[left];
                v2=A[cand-1];
            }
            if(left+1<=cand && cand<=N && Math.abs(A[left]+A[cand])<best_sum){
                best_sum=Math.abs(A[left]+A[cand]);
                v1=A[left];
                v2=A[cand];
            }
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }
    public static void main(String[] args){
        input();
        pro();
    }
}
