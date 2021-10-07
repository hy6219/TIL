package rhs_algo.dfs_bfs.boj1697;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
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

        double nextDouble(){
            return Double.valueOf(next());
        }

    }

    static FastReader r=new FastReader();
    static int N,K;
    static int[] dist;
    static boolean[] visit;

    static void input(){
        N=r.nextInt();
        K=r.nextInt();

        dist=new int[100005];
        visit=new boolean[100005];
    }

    // 숨바꼭질 시작~
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        /* TODO */
        //시작점 체크
        Q.add(N);
        visit[N]=true;
        dist[N]=0;//시작점 카운트x
        // BFS 과정 시작
        /* TODO */
        while(!Q.isEmpty()){
            int x=Q.poll();
            int y=x-1;//좌측으로 이동

            //y가 0이상 10만 이하 범위에 있으면서 아직 방문하지 않았을 때 유효
            if(y>=0 && y<=100000 && !visit[y]){
                visit[y]=true;//방문처리
                dist[y]=dist[x]+1;
                //방문할 곳 등록
                Q.add(y);
            }

            //우측으로 이동
            y=x+1;
            if(y>=0 && y<=100000 && !visit[y]){
                visit[y]=true;
                dist[y]=dist[x]+1;
                Q.add(y);
            }
            //건너뛰기
            y=2*x;
            if(y>=0 && y<=100000 && !visit[y]){
                visit[y]=true;
                dist[y]=dist[x]+1;
                Q.add(y);
            }
        }
    }

    static void pro() {
        bfs();
        System.out.println(dist[K]);
    }
    public static void main(String[] args){
        input();
        pro();
    }
}
