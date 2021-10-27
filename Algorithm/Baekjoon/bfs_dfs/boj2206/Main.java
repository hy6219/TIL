package baekjoon.bfs_dfs.boj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    }

    static class Room{
        int x;
        int y;
        int wall;

        public Room(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

    static FastReader scan=new FastReader();
    static int N,M;
    static int[][] board;
    static boolean[][][] visit;//벽 부수는지에 따라 달라짐,
    static int[][] dir={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };
    static int[][] dist;

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
        board=new int[N+1][M+1];
        dist=new int[N+1][M+1];
        visit=new boolean[N+1][M+1][2];

        for(int i=1;i<=N;i++){
            String str=scan.nextLine();
            for(int j=1;j<=M;j++){
                board[i][j]=str.charAt(j-1)-'0';
            }
        }
    }

    static int bfs(int x,int y){
        Queue<Room> que=new LinkedList<>();
        que.add(new Room(x,y,0));
        visit[x][y][0]=true;
        dist[x][y]=1;//자기자신도 포함

        while(!que.isEmpty()){
            Room temp=que.poll();
            x=temp.x;
            y=temp.y;
            int wall=temp.wall;

            //목적지 도착시 종료
            if(x==N && y==M){
                return dist[N][M];
            }

            for(int i=0;i<4;i++){
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];


                if(nx<1 || ny<1 || nx>=N+1 || ny>=M+1) continue;
                //부술 벽이 있는지 확인<-wall==0이므로 wall+1은 벽이 있다는것인지 확인
                //즉, 벽이 있는곳을 아직 들르지 않았는지 확인
                if(board[nx][ny]==1 && wall==0 && !visit[nx][ny][wall+1]){
                    visit[nx][ny][wall+1]=true;//다음벽을 방문하기
                    que.add(new Room(nx,ny,wall+1));//벽무너뜨리기
                    dist[nx][ny]=dist[x][y]+1;
                }else if(board[nx][ny]==0 && !visit[nx][ny][wall]){
                    visit[nx][ny][wall]=true;
                    que.add(new Room(nx,ny,wall));
                    dist[nx][ny]=dist[x][y]+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        input();
        int res=bfs(1,1);

        System.out.println(res);
    }
}
