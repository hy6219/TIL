package baekjoon.boj21922;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
        public FastReader(String s) throws FileNotFoundException{
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();;
            }
            return str;
        }
        String next(){
            while(st==null||!st.hasMoreTokens()){
                //string tokenizer 생성되지 않은 경우
                try{
                    st=new StringTokenizer(br.readLine());//여기서 만족하게 되면 이제 st는 비어있지 않게 되어서 결국 ""을 기준으로 splitted
                }catch (IOException e){
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
   /*
   * 핵심!!
   * 1. 에어컨이 여러대 존재할 수 있기 때문에 각 에어컨의 위치에서
   * 바람을 쏴야 한다!
   * ->바람의 현재 상태:(i,j,현재 바라보고 있는 방향)
   * ->이미 방문한적있는 위치 정보를 visited[i][j][visited]형태로 관리
   * ->simulation algo-->반복문 or dfs/bfs 이용
   * */

    //(x,y,방향) 데이터 처리 클래스->바람
    public static class Point{
        public int x,y,dir;
        public Point(int x,int y, int dir){
            this.x=x;
            this.y=y;
            this.dir=dir;
        }
    }
    //연구실 크기
    //세로(n<-x)가로(m<-y)
    public static int n,m;
    //전체 연구실 배열
    public static int[][] arr=new int[2001][2001];
    //방문여부 체크배열(bfs 목적)
    public static boolean[][][] visited=new boolean[2001][2001][4];
    //바람이 한 번이라도 지난 곳 체크
    public static boolean [][] checked=new boolean[2001][2001];
    //0:좌 1:우 2:상 3:하
    public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};


    public static void main(String[] args){
        FastReader sc=new FastReader();

        n=sc.nextInt();
        m=sc.nextInt();

        //에어컨 위치 모두 파악(구현의 편의를 위해서 큐를 사용. 꼭 큐일 필요는 없음)
        Queue<Point> starts=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==9){
                    //에어컨 위치
                    starts.add(new Point(i,j,-1));//루트는 방향이 없음
                }
            }
        }

        //바람의 위치를 담을 큐
        Queue<Point> queue=new LinkedList<>();
        //각 에어컨 위치에서 바람 쏘기
        while(!starts.isEmpty()){
            Point cur=starts.poll();
            int start_x=cur.x;//각 방향으로의 이동 전, 에어컨의 위치
            int stary_y=cur.y;
            //네가지 방향을 모두 순회하면서 마킹,방문처리
            for(int i=0;i<4;i++){
                int ax=start_x+dx[i];
                int ay=stary_y+dy[i];
                //구간을 벗어난 경우 무시
                if(ax<0 || ax>=n||ay<0||ay>=m){
                    continue;
                }
                //방문처리 된 경우도 무시
                if(visited[ax][ay][i]){
                    continue;
                }
                //방문처리
                visited[ax][ay][i]=true;
                //좌표값과 방향에 대한 바람 정보 추가
                queue.add(new Point(ax,ay,i));
                //해당 좌표를 방향상관없이 한번이라도 방문했는지 확인
                checked[ax][ay]=true;
            }
            //시작 루트도 방향상관없이 한번이라도 방문했는지 확인
            checked[start_x][stary_y]=true;
        }
        //각 바람들에 대해서 해당 바람의 방향대로 움직이도록 bfs를 이용해서 시뮬레이션 진행
        while(!queue.isEmpty()){
            Point cur=queue.poll();
            int x=cur.x;
            int y= cur.y;
            int dir=cur.dir;
            //물건에 의해 바람의 방향이 바뀌는지 체크
            dir=changeDir(arr[x][y],dir);
            //다음위치 계산
            int ax=x+dx[dir];
            int ay=y+dy[dir];
            //구간을 벗어난 경우 무시
            if(ax<0 || ax>n||ay<0||ay>m){
                continue;
            }
            //방문처리 된 경우도 무시
            if(visited[ax][ay][dir]){
                continue;
            }
            //방문처리
            visited[ax][ay][dir]=true;
            //다음위치에 대한 좌표값과 방향에 대한 바람 정보 추가
            queue.add(new Point(ax,ay,dir));
            //해당 좌표를 방향상관없이 한번이라도 방문했는지 확인
            checked[ax][ay]=true;
        }
        //한번이라도 방문한 위치의 갯수 출력
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(checked[i][j]) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
    public static int changeDir(int type,int dir){
        //물건 종류에 따른 방향 처리
        if(type==1){
            //좌우 방향만 바뀜
            if(dir==2) return 3;
            if(dir==3) return 2;
        }else if(type==2){
            //상하방향
            if(dir==0) return 1;
            if(dir==1) return 0;
        }else if(type==3){
            /*
            * 윗쪽2->오른쪽 1
            * 아랫쪽3->왼쪽 0
            * 오른쪽1->윗쪽 2
            * 왼쪽-0>아래쪽 3
            * */
            if(dir==0) return 3;
            if(dir==1) return 2;
            if(dir==2) return 1;
            if(dir==3) return 0;
        }else if(type==4){
            /*
             * 윗쪽2->왼쪽 0
             * 아랫쪽3->오른 1
             * 오른쪽1->아래쪽 3
             * 왼쪽-0>윗쪽 2
             * */
            if(dir==0) return 2;
            if(dir==1) return 3;
            if(dir==2) return 0;
            if(dir==3) return 1;
        }
        return dir;
    }
}
