package rhs_algo.dfs_bfs.boj1260Re;

import java.io.*;
import java.util.Arrays;
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
    static int N,M;//정점갯수, 간선갯수
    static int V;//시작 정점
    //방문처리
    static boolean[] visit;
    //인접행렬
    static int[][] adj;
    static StringBuilder sb=new StringBuilder();


    static void input(){
        N=r.nextInt();
        M=r.nextInt();
        V=r.nextInt();


        adj=new int[N+1][N+1];

        for(int i=1;i<=M;i++){
            int f=r.nextInt();
            int s=r.nextInt();

            adj[f][s]=adj[s][f]=1;//연결되어 있다!~
        }

    }

    static void dfs(int start){
        //재귀처리 부분 외에 공통부분
        //방문처리
        visit[start]=true;
        sb.append(start).append(' ');
        //연결된 곳은 다 들르기
        for(int i=1;i<=N;i++){
            //연결되지 않았다면 지나기
            if(adj[start][i]==0) continue;
            //만약 방문한적이 있다면 그냥 스킵~~
            if(visit[i]) continue;
            //탐색
            dfs(i);
        }
    }


    //bfs
    static void bfs(int start){
        //방문해야할 곳들
        Queue<Integer> que=new LinkedList<>();
        //방문해야할 곳으로 등록
        que.add(start);
        //방문처리
        visit[start]=true;
        //탐색이 남았다면
        while(!que.isEmpty()){
            //하나 꺼내고
            start=que.poll();
            sb.append(start).append(' ');
            //방문할 수 있는 곳들을 둘러보기
            for(int i=1;i<=N;i++){
                //연결되지 않았으면 스킵
                if(adj[start][i]==0) continue;
                //방문한적있다면 스킵
                if(visit[i]) continue;
                //방문해야할 곳으로 등록
                que.add(i);
                //방문처리
                visit[i]=true;
            }
        }
    }

    static void pro(){
        visit=new boolean[N+1];
        dfs(V);
        sb.append('\n');
        for(int i=1;i<=N;i++){
            visit[i]=false;
        }
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
