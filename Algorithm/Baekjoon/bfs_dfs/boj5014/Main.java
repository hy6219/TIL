package baekjoon.bfs_dfs.boj5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static class Floor{
        int floor;
        boolean moveUp;
        boolean moveDown;

        public Floor(int floor, boolean moveUp, boolean moveDown) {
            this.floor = floor;
            this.moveUp = moveUp;
            this.moveDown = moveDown;
        }

        public void setMoveUp(int upUnit,int limit){
            if(floor+upUnit>limit){
                this.moveUp=false;
            }else{
                this.moveUp=true;
            }
        }

        public void setMoveDown(int downUnit,int limit){
            if(floor-downUnit<limit){
                this.moveDown=false;
            }else{
                this.moveDown=true;
            }
        }
    }

    static FastReader scan=new FastReader();
    static int F,S,G,U,D;
    static Floor[] floors;
    static boolean[] visit;
    static int[] dir;
    static final String wrong="use the stairs";
    //위 혹은 아래
    static int[] ud={
      1,-1
    };

    static void input(){
        F=scan.nextInt();
        S=scan.nextInt();
        G=scan.nextInt();
        U=scan.nextInt();
        D=scan.nextInt();

        floors=new Floor[F+1];
        visit=new boolean[F+1];
        dir=new int[F+1];

        for(int i=1;i<=F;i++){
            floors[i]=new Floor(i,false,false);
            floors[i].setMoveUp(U,F);
            floors[i].setMoveDown(D,1);
        }
    }

    static void bfs(){
        Queue<Floor> que=new LinkedList<>();
        que.add(floors[S]);
        visit[S]=true;
        //시작점과 목적지가 같은 경우는 0을 출력해야함
        if(S==G){
            System.out.println(0);
            System.exit(0);
        }
        if(D==0 && U==0){
            System.out.println(wrong);
            System.exit(0);
        }
        if(S>G && D==0){
            System.out.println(wrong);
            System.exit(0);
        }
        if(S<G && U==0){
            System.out.println(wrong);
            System.exit(0);
        }

        while(!que.isEmpty()){
            Floor f=que.poll();
            int cur=f.floor;
            for(int i=0;i<2;i++){
                int nf=0;
                //위
                if(i==0) nf=cur+ud[i]*U;
                else if(i==1) nf=cur+ud[i]*D;
                //위 아래로 움직일 수 없는 범위 확인
                if(nf<1 || nf>F) continue;
                if(visit[nf]) continue;
                que.add(floors[nf]);
                visit[nf]=true;
                dir[nf]=dir[cur]+1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
        int ans=dir[G];
        if(ans<=0){
            System.out.println(wrong);
        }else{
            System.out.println(ans);
        }
    }
}
