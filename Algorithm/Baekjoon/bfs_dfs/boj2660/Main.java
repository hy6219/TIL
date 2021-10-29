package baekjoon.bfs_dfs.boj2660;

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

    static FastReader scan=new FastReader();
    static int N;
    static int[][] board;
    //친구점수목록
    static int[] friends;

    static void input(){
        N=scan.nextInt();
        board=new int[N+1][N+1];
        friends=new int[N+1];

        int first=0;
        int second=0;
        //초기화
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                board[i][j]=987654321;
            }
        }
        while(true){
            first=scan.nextInt();
            second=scan.nextInt();
            if(first==-1 && second==-1) break;
            board[first][second]=board[second][first]=1;
        }

    }

    static void preScore(){
        for(int k=1;k<=N;k++){
           // board[k][k]=1;
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    board[i][j]=Math.min(board[i][j],board[i][k]+board[k][j]);
                }
            }
        }
    }

    static void score(){
        //리더점수는 최소가 되어야 함
        int min=987654321;
        for(int i=1;i<=N;i++){
            int max=0;
            for(int j=1;j<=N;j++){
                if(board[i][j]!=987654321){
                    max=Math.max(max, board[i][j]);
                }
            }

            friends[i]=max;
            min=Math.min(min,max);
        }

        //후보
        ArrayList<Integer> hubo=new ArrayList<>();

        for(int i=1;i<=N;i++){
            if(friends[i]==min){
                hubo.add(i);
            }
        }
        System.out.println(min+" "+hubo.size());
        for(int i=0;i<hubo.size();i++){
            System.out.print(hubo.get(i)+" ");
        }

    }

    public static void main(String[] args) {
        input();
        preScore();
        score();
    }
}
    