package rhs_algo.dfs_bfs.boj3055;

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

    static FastReader scan=new FastReader();
    static int N,M;//R,C
    static String[] a;
    static boolean[][] visit;
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    //각 위치별 물이 차오르는 시간 기록
    static int[][] dist_water;
    //물위치를 피해 지나가는 시간 기록
    static int[][] dist_hedgehog;

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();

        a=new String[N];
        visit=new boolean[N][M];
        dist_water=new int[N][M];
        dist_hedgehog=new int[N][M];

        for(int i=0; i<N;i++){
            a[i]=scan.nextLine();
        }
    }

    // 모든 물들을 시작으로 동시에 BFS 시작!
    static void bfs_water() {
        Queue<int[]> Q = new LinkedList<>();
        // 모든 물의 위치를 Q에 전부 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                /* TODO */
                //dist_water,visit배열 초기화
                dist_water[i][j]=-1;
                visit[i][j]=false;
                //물을 찾았다!
                if (a[i].charAt(j) == '*') {
                    /* TODO */
                    //위치를 기록
                    Q.add(new int[]{i,j});
                    //방문처리
                    visit[i][j]=true;
                    //시작점은 0분에 차오른 것이므로 0으로 채우기
                    dist_water[i][j]=0;
                }
            }
        }

        // BFS 과정 시작
        /* TODO */
        while(!Q.isEmpty()){
            //한개 꺼내기
            int[] p=Q.poll();
            int x= p[0];
            int y=p[1];

            //살펴볼 수 있는 모든 방향을 살피기
            for(int i=0;i<4;i++){
                int nextX=x+dir[i][0];
                int nextY=y+dir[i][1];

                if(nextX<0 || nextX>=N|| nextY<0 || nextY>=M) continue;
                //비버가 있는 위치로는 불가
                if(a[nextX].charAt(nextY)=='D') continue;
                //비어있지 않은 곳은 탐색 불가
                if(a[nextX].charAt(nextY)!='.') continue;
                if(visit[nextX][nextY]) continue;

                Q.add(new int[]{nextX,nextY});
                visit[nextX][nextY]=true;
                dist_water[nextX][nextY]=dist_water[x][y]+1;
            }
        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static void bfs_hedgehog() {
        Queue<int[]> Q = new LinkedList<>();
        // 고슴도치 위치를 Q에 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_hedgehog 와 visit 배열 초기화
                /* TODO */
                dist_hedgehog[i][j]=-1;
                visit[i][j]=false;
                if (a[i].charAt(j) == 'S') {
                    /* TODO */
                    //고슴도치 위치를 넣기
                    Q.add(new int[]{i,j});
                    //방문처리
                    visit[i][j]=true;
                    dist_hedgehog[i][j]=0;//자기자신 0
                }
            }
        }

        // BFS 과정 시작
        /* TODO */
        while(!Q.isEmpty()){
            //1개 꺼내기
            int[] start=Q.poll();
            int x=start[0];
            int y=start[1];

            //모든 연결된 부분 탐색
            for(int i=0;i<4;i++){
                int nextX=x+dir[i][0];
                int nextY=y+dir[i][1];

                if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue;
                //수달 위치로 못오거나 비어있지 않은 공간이면 접근 안해도 됨 못함!
                if(a[nextX].charAt(nextY)!='.'&&a[nextX].charAt(nextY)!='D') continue;
                //water 배열에서 -1이 아니면 물에 잠겼거나, 잠길 예정이라는 것
                //물이 잠기지 않았는지 확인 Th+1(=dist_hedgehog[x][y]+1)>=Tw -> 물 잠김
                if(dist_water[nextX][nextY]!=-1 && dist_water[nextX][nextY]<=dist_hedgehog[x][y]+1) continue;
                if(visit[nextX][nextY]) continue;

                Q.add(new int[]{nextX,nextY});
                visit[nextX][nextY]=true;
                dist_hedgehog[nextX][nextY]=dist_hedgehog[x][y]+1;

            }

        }
    }

    static void pro() {
        // 각 칸마다 물에 닿는 시간 계산하기
        bfs_water();

        // 고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        bfs_hedgehog();

        // 탈출구 'D' 에 대한 결과를 통해 정답 출력하기
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){

                if (a[i].charAt(j) == 'D'){
                    /* TODO */
                    if(dist_hedgehog[i][j]==-1){
                        //방법이 없는 경우
                        System.out.println("KAKTUS");
                    }else{
                        System.out.println(dist_hedgehog[i][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
