package rhs_algo.dfs_bfs.boj14502;

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
    static int N, M, B, ans;
    static int[][] A, blank;//blank:사용 가능한 벽의 위치를 기록
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1][M + 1];
        //안전영역 개수=N*M-M
        blank = new int[N * M + 1][2];//x,y
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                A[i][j] = scan.nextInt();
    }

    // 바이러스 퍼뜨리기!!
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능하니까, 전부 큐에 넣어준다.
        /* TODO */
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                visit[i][j]=false;
                if(A[i][j]==2){
                    Q.add(i);
                    Q.add(j);
                    visit[i][j]=true;
                }
            }
        }
        // BFS 과정
        /* TODO */
        while(!Q.isEmpty()){
            //두개 빼기
            int x=Q.poll();
            int y=Q.poll();

            //4개 방향으로 살피기
            for(int i=0;i<4;i++){
                int nX=x+dir[i][0];
                int nY=y+dir[i][1];

                if(nX<1||nX>N ||nY<1||nY>M) continue;
                if(A[nX][nY]!=0) continue;
                if(visit[nX][nY]) continue;

                Q.add(nX);
                Q.add(nY);

                visit[nX][nY]=true;
            }
        }
        // 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        /* TODO */
        int cnt=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(A[i][j]==0 && !visit[i][j]){
                    //visit되지 않은, 즉 바이러스가 퍼지지 않은 빈 공간
                    cnt++;
                }
            }
        }
        ans=Math.max(ans,cnt);
    }

    // idx 번째 빈 칸에 벽을 세울 지 말 지 결정해야 하고, 이 전까지 selected_cnt 개의 벽을 세웠다.
    static void dfs(int idx, int selected_cnt) {
        if (selected_cnt == 3) {  // 3 개의 벽을 모두 세운 상태
            /* TODO */
            bfs();
            return;
        }
        if (idx > B) return;  // 더 이상 세울 수 있는 벽이 없는 상태

        /* TODO */
        A[blank[idx][0]][blank[idx][1]]=1;//벽을 세워보기
        dfs(idx+1,selected_cnt+1);

        //벽을 안세워본 경우도 다 해보기
        A[blank[idx][0]][blank[idx][1]]=0;
        dfs(idx+1,selected_cnt);
    }

    static void pro() {
        // 모든 벽의 위치를 먼저 모아놓자.
        /* TODO */
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(A[i][j]==0){
                    //공기
                    B++;//조합으로 생각해볼 수 있는 전체 공기 개수
                    blank[B][0]=i;
                    blank[B][1]=j;
                }
            }
        }
        // 벽을 3개 세우는 모든 방법을 확인해보자!
        /* TODO */
        dfs(1,0);//B개 중 전체 다 탐색해봐~
        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
