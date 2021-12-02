package baekjoon.brute_force.boj14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            }catch (IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

    }

    static FastReader scan=new FastReader();
    static int N,M;
    static int ans=0;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir={
            {-1,0},//상
            {0,1},//우
            {1,0},//하
            {0,-1}//좌
    };

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();

        map=new int[N][M];
        visit=new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=scan.nextInt();
            }
        }
    }

    static void tetris(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visit[i][j]=true;
                //ㅓ,ㅏ,ㅗ,ㅜ 외의 경우
                dfs(i,j,1,map[i][j]);
                visit[i][j]=false;
                //ㅓ,ㅏ,ㅗ,ㅜ 따로 생각
                moeum(i,j);
            }
        }
    }

    /**
     * @param row 행
     * @param col 열
     * @param exceptMoeum 모음(ㅓ,ㅏ,ㅜ,ㅗ)를 제외한 케이스로 진행한 영역합
     * @param ord 모음을 제외한 4개 케이스를 확인하기 위한 변수
     * */
    static void dfs(int row, int col,int ord,int exceptMoeum){
        if(ord>=4){
            ans=Math.max(ans,exceptMoeum);
            return;
        }else{
            //4방향
            for(int cand=0;cand<4;cand++){
                int nr=row+dir[cand][0];
                int nc=col+dir[cand][1];
                int temp=0;

                if(nr<0 || nc<0 || nr>=N || nc>=M || visit[nr][nc]) continue;

                //방문처리
                visit[nr][nc]=true;
                temp=exceptMoeum+map[nr][nc];
                //dfs
                dfs(nr,nc,ord+1,temp);
                //초기화
                visit[nr][nc]=false;
            }
        }
    }

    /**
     * ㅓ,ㅏ,ㅗ,ㅜ에 대한 계산 진행
     * @param row 행
     * @param col 열
     * */
    static void moeum(int row, int col){
        //ㅓ
        if(row>=1 &&row<N-1 && col>=1 && col<M){
            int eo=map[row][col]+map[row+1][col]+map[row-1][col]+map[row][col-1];
            ans=Math.max(ans,eo);
        }

        //ㅏ
        if(row>=1 && row<N-1 && col>=0 && col < M-1){
            int ah=map[row][col]+map[row+1][col]+map[row-1][col]+map[row][col+1];
            ans=Math.max(ans,ah);
        }

        //ㅗ
        if(row>0 &&row<N&& col>=1 && col<M-1){
            int oh=map[row][col]+map[row][col-1]+map[row][col+1]+map[row-1][col];
            ans=Math.max(ans,oh);
        }
        //ㅜ
        if(row>=0&& row < N-1 && col>=1 && col < M-1){
            int woo=map[row][col]+map[row][col-1]+map[row][col+1]+map[row+1][col];
            ans=Math.max(ans,woo);
        }
    }

    static void pro(){
        input();
        tetris();
        System.out.print(ans);
    }

    public static void main(String[] args) {
        pro();
    }
}
