package rhs_algo.dfs_bfs.boj2667;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
    static int N;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    //방문처리
    static boolean[][] visit;
    //인접행렬
    static int[][] adj;
    //단지 내 집수
    static PriorityQueue<Integer> pq=new PriorityQueue<>();

    static void input(){
        N=r.nextInt();
        adj=new int[N][N];
        visit=new boolean[N][N];
        for(int i=0;i<N;i++){
            String[] str=r.nextLine().split("");
            for(int j=0;j<str.length;j++){
                adj[i][j]=Integer.valueOf(str[j]);
            }
        }

    }
    static void bfs(int curX,int curY){
        //영역
        int cnt=0;
        Queue<int[]> que=new LinkedList<>();
        //방문할 곳으로 등록
        que.add(new int[]{curX,curY});
        //방문처리
        visit[curX][curY]=true;
        while(!que.isEmpty()){
            //일단 한개 꺼내기
            int[] pick=que.poll();
            int x=pick[0];
            int y=pick[1];
            cnt++;
            for(int i=0;i<4;i++){
                int nextX=x+dx[i];
                int nextY=y+dy[i];

                if(nextX<0 || nextX>=N ||nextY<0||nextY>=N) continue;
                if(visit[nextX][nextY]) continue;
                if(adj[nextX][nextY]==0) continue;
                //방문할 곳으로 등록
                que.add(new int[]{nextX,nextY});
                //방문처리
                visit[nextX][nextY]=true;
            }

        }

        pq.add(cnt);
    }



    static void pro(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(adj[i][j]==1 && !visit[i][j]){
                    bfs(i,j);
                }
            }
        }

        System.out.println(pq.size());
       while(!pq.isEmpty()){
           System.out.println(pq.poll());
       }
    }
    public static void main(String[] args){
        input();
        pro();
    }
}
