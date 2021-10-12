package baekjoon.brute_force.boj3085;

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
    static int max=Integer.MIN_VALUE;//최대로 먹을수 있는 값 저장
    static char[][] arr;
    static void input(){
        N=r.nextInt();
        arr=new char[N][N];

        for(int i=0;i<N;i++){
            String str=r.nextLine();
           for(int j=0;j<N;j++){
               arr[i][j]=str.charAt(j);
           }
        }
    }

    static void pro(){
        //max비교를 위한 임시변수
        int cnt=1;
        //->(행 탐색)
        for(int i=0;i<N;i++){
            cnt=1;
            for(int j=0;j<N-1;j++){
                if(arr[i][j]==(arr[i][j+1])){
                    cnt++;
                }else{
                    cnt=1;
                }
                max=Math.max(max,cnt);
            }
        }
        //↓ (열)탐색
        //열고정
        for(int i=0;i<N;i++){
            cnt=1;
            //행이동
            for(int j=0;j<N-1;j++){
                if(arr[j][i]==(arr[j+1][i])){
                    cnt++;
                }else{
                    cnt=1;
                }
                max=Math.max(max,cnt);
            }
        }
    }



    public static void main(String[] args) {
        input();
        //교환(가로로 인접한 두개 교환)
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                char temp=arr[i][j];
                arr[i][j]=arr[i][j+1];
                arr[i][j+1]=temp;

                //행, 열방향으로 먹을수 있는 최대 사탕수 확인
                pro();

                //이전에 교환했던 이력 초기화
                temp=arr[i][j];
                arr[i][j]=arr[i][j+1];
                arr[i][j+1]=temp;
            }
        }
        //위아래로 인접한 교환
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                char temp=arr[j][i];
                arr[j][i]=arr[j+1][i];
                arr[j+1][i]=temp;

                pro();

                //초기화
                temp=arr[j][i];
                arr[j][i]=arr[j+1][i];
                arr[j+1][i]=temp;
            }
        }
        System.out.println(max);
    }
}
