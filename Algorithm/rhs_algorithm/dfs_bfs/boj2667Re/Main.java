package rhs_algo.dfs_bfs.boj2667Re;

import java.io.*;
import java.util.*;

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
    static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    static String[] a;
    static ArrayList<Integer> group;
    static boolean[][] visit;
    //단지 내 집 갯수
    static int group_cnt=0;

    static void input(){
        N=r.nextInt();
        a=new String[N];
        visit=new boolean[N][N];

        for(int i=0;i<N;i++){
            a[i]=r.nextLine();
        }

    }


    static void dfs(int x, int y){
        //단지에 속한 집의 갯수 증가, visit 체크
        group_cnt++;
        visit[x][y]=true;
        //인접한 집으로 새로운 방문하기
        for(int k=0;k<4;k++){
            int nextX=x+dir[k][0];
            int nextY=y+dir[k][1];

            if(nextX<0||nextX>=N||nextY<0||nextY>=N) continue;
            if(a[nextX].charAt(nextY)=='0') continue;
            if(visit[nextX][nextY]) continue;

            dfs(nextX,nextY);
        }
    }
    static void pro(){
        group=new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j] && a[i].charAt(j)=='1'){
                    //dfs
                    group_cnt=0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }
        Collections.sort(group);
//찾은 단지 정보 출력
        System.out.println(group.size());
        for(int i=0;i<group.size();i++){
            System.out.println(group.get(i));
        }
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
