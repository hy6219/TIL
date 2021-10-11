package rhs_algo.two_pointer.boj1806;

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

        long nextLong(){
            return Long.valueOf(next());
        }

        double nextDouble(){
            return Double.valueOf(next());
        }
    }

    static FastReader r=new FastReader();
    static int n,s;
    static int[] a;

    static void input(){
        n=r.nextInt();
        s=r.nextInt();
        a=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=r.nextInt();
        }
    }

    static void pro(){
        int R=0,sum=0,ans=n+1;

        for(int L=1;L<=n;L++){
            //L-1을 구간에서 제외
            sum-=a[L-1];
//R을 옮길수 있을 때 까지 옮기기
            while(R+1<=n && sum<s){
                //R을 옮겨주고
                R++;
                sum+=a[R];
            }
//[L...R]의 합,즉 sum이 만족하면 정답 갱신하기
            if(sum>=s){
                ans=Math.min(ans,R-L+1);
            }
        }
//ans값을 보고 불가능 판단하기
        //ans가 초기값이었던 n+1이면<=>한번도 만족된 경우가 없었다는 것
        if(ans==n+1){
            ans=0;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
