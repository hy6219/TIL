package baekjoon.bfs_dfs.boj17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine(){
            String str="";
            try {
                str=br.readLine();
            } catch (IOException e) {
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

    static class Point{
        int x;
        int y;
        int type;

        public Point(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && type == point.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, type);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", type=" + type +
                    '}';
        }
    }

    static FastReader scan=new FastReader();
    static int N;
    static int[][] plot;
    static boolean[][] visit;
    static int[][] dir;
    static int[][] d={
            {1,0},//세로
            {0,1},//가로
            {1,1}//대각선
    };

    static void input(){
        N=scan.nextInt();
        plot=new int[N+1][N+1];
        visit=new boolean[N+1][N+1];
        dir=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                plot[i][j]=scan.nextInt();
            }
        }
    }

    static void bfs() {
        Queue<Point> points = new LinkedList<>();

        //(N,N)자리가 벽이면 이동할 수 없음
        if(plot[N][N]==1){
            System.out.println(0);
            return;
        }

        int cnt = 0;

        //가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로
        points.add(new Point(1, 2, 0));


        while (!points.isEmpty()) {
            Point p = points.poll();

            //(n,n)도달 확인
            if (p.x == N && p.y == N) {
                cnt++;
                continue;
            }

            //그 외에는 접근가능한 방향을 확인
            int dir = p.type;

            if (dir == 0) {
                //가로
                //->가로(0) 또는 대각선(2)로 이동 가능
                //01.가로 확인
                if(check(p,0)){
                    //벽이 없는 경우
                    //가로로 이동
                    points.add(new Point(p.x,p.y+1,0));
                }

                //대각선 방향으로 움직일 수 있는지 확인
                if(check(p,2)){
                    points.add(new Point(p.x+1,p.y+1,2));
                }
            }else if(dir==1){
                //세로
                //세로(1) 혹은 대각선(2)
                if(check(p,1)){
                    points.add(new Point(p.x+1,p.y,1));
                }

                //대각선
                if(check(p,2)){
                    points.add(new Point(p.x+1,p.y+1,2));
                }

            }else{
                //대각선
                //가로(0), 세로(1), 대각선(2)

                //가로
                if(check(p,0)){
                    //벽이 없는 경우
                    //가로로 이동
                    points.add(new Point(p.x,p.y+1,0));
                }
                //세로
                if(check(p,1)){
                    points.add(new Point(p.x+1,p.y,1));
                }
                //대각선
                if(check(p,2)){
                    points.add(new Point(p.x+1,p.y+1,2));
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean check(Point p, int type){
        switch (type){
            case 0:
                //가로<-가로에 벽이 있는지 확인 필요
                return p.y+1<=N && plot[p.x][p.y+1]!=1;
            case 1:
                //세로<-아래방향에 벽이 있는지 확인 필요
                return p.x+1<=N && plot[p.x+1][p.y]!=1;
            case 2:
                //대각선
                //꼭 빈 칸이어야 하는 곳은 색으로 표시
                //<-따라서 p.x+1 p.y+1만 보지 말고, p.x+1 , p.y+1도 봐야 함
                return p.x+1<=N && p.y+1<=N && plot[p.x][p.y+1]!=1 && plot[p.x+1][p.y]!=1 && plot[p.x+1][p.y+1]!=1;
        }
        return false;
    }

    public static void main(String[] args) {
        input();
        bfs();
    }
}
