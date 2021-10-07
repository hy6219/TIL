package rhs_algo.dfs_bfs.boj2178;

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

    static FastReader scan=new FastReader();
    static int N,M;
    static String[] a;
    static boolean[][] visit;
    static int[][] dist;//갈수 없으면 -1, 갈수 있으면 어떤 값이 써져있어야 함
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};

    static void input(){
        N=scan.nextInt();
        M= scan.nextInt();

        a=new String[N];
        visit=new boolean[N][M];
        dist=new int[N][M];

        for(int i=0;i<N;i++){
            a[i]=scan.nextLine();
        }

    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) {
        // dist 배열 초기화
        /* TODO */
        //dist 배열을 모두 -1로 초기화
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dist[i][j]=-1;
            }
        }
        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        /* TODO */
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{x,y});
        visit[x][y]=true;
        dist[x][y]=1;//시작부터 한칸은 밟는다
        // BFS 과정 시작
        /* TODO */
        while(!que.isEmpty()){
            int[] pick=que.poll();
            x=pick[0];
            y=pick[1];

            for(int i=0;i<4;i++){
                int nextX=x+dir[i][0];
                int nextY=y+dir[i][1];

                if(nextX<0||nextX>=N||nextY<0||nextY>=M) continue;
                //0은 이동할 수 없음
                if(a[nextX].charAt(nextY)=='0') continue;
                if(visit[nextX][nextY]) continue;

                que.add(new int[]{nextX,nextY});
                visit[nextX][nextY]=true;
                //이전값에다가 거리가 1씩 증가됨
                dist[nextX][nextY]=dist[x][y]+1;
            }

        }
    }

    static void pro() {
        // 시작점이 (0, 0)인 탐색 시작
        /* TODO */
        bfs(0,0);
        // (N-1, M-1)까지 필요한 최소 이동 횟수 출력
        /* TODO */
        System.out.println(dist[N-1][M-1]);
    }
    public static void main(String[] args){
        input();
        pro();
    }
}
