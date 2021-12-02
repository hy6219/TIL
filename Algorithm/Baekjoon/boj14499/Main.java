package baekjoon.boj14499;

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

            try {
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
    static int N,M,K;
    static int curR,curC;
    static int[][] map;
    static int[] dices=new int[7];
    static int[][] dir={
            {0,1},//동
            {0,-1},//서
            {-1,0},//북
            {1,0}//남
    };

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();

        curR= scan.nextInt();
        curC=scan.nextInt();

        K=scan.nextInt();

        map=new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=scan.nextInt();
            }
        }
    }

    //지도 위를 돌아다니기
    static void moveOnMap(){
        for(int i=0;i<K;i++){
            //굴릴 방향
            int direction=scan.nextInt();
            //지도상 위치
            int nr=curR+dir[direction-1][0];
            int nc=curC+dir[direction-1][1];

            if(nr>=0 && nc>=0 && nr<N && nc<M){
                //주사위 굴리기
                rotateDice(direction);
                //다음 이동칸에 쓰인 수가 0인 경우
                if(map[nr][nc]==0){
                    //주사위 바닥면의 수가 지도에 기록됨
                    map[nr][nc]=dices[6];
                }else{
                    //다음 이동칸에 쓰인 수가 0이 아닌 경우
                    //지도값이 주사위에 복제됨
                    dices[6]=map[nr][nc];
                    //그 칸은 0으로 대체됨
                    map[nr][nc]=0;
                }
                //윗면 값
                System.out.println(dices[1]);
                //위치 갱신
                curR=nr;
                curC=nc;
            }else{
                nr-=dir[direction-1][0];
                nc-=dir[direction-1][1];
            }

        }
    }
    //주사위 굴리기
    static void rotateDice(int dir){
        int[] buffer=dices.clone();
        /**
         * 주어진 예시를 갖고서 이해해보면,
         * 전개도에서 위에서부터 생각해보았을 때 인덱스를
         *   2
         * 4 1 3
         *  5
         *  6
         *  로 두어
         *  윗면:1
         *  밑면:6
         *  왼쪽면:4
         *  오른쪽면:3
         *  앞면:5
         *  뒷면:2
         *  이 됨으로 정리해볼 수 있다
         * */
        if(dir==1){
            //동쪽
            //윗면<-왼쪽
            dices[1]=buffer[4];
            //우측면<-윗면
            dices[3]=buffer[1];
            //왼쪽면<-밑면
            dices[4]=buffer[6];
            //밑면<-우측면
            dices[6]=buffer[3];
            //동쪽, 서쪽으로 굴리면 앞/뒷면은 변동이 없음
        }else if(dir==2){
            //서쪽
            //윗면<-우측면
            dices[1]=buffer[3];
            //우측면<-바닥면
            dices[3]=buffer[6];
            //왼쪽면<-윗면
            dices[4]=buffer[1];
            //밑면<-왼쪽면
            dices[6]=buffer[4];
        }else if(dir==3){
            //북쪽
            //위쪽, 아래쪽으로 굴리면 좌/우면은 변동없음
            //윗면<-앞면
            dices[1]=buffer[5];
            //뒷면<-윗면
            dices[2]=buffer[1];
            //앞면<-바닥면
            dices[5]=buffer[6];
            //밑면<-뒷면
            dices[6]=buffer[2];
        }else{
            //남쪽
            //윗면<-뒷면
            dices[1]=buffer[2];
            //뒷면<-밑면
            dices[2]=buffer[6];
            //앞면<-윗면
            dices[5]=buffer[1];
            //밑면<-앞면
            dices[6]=buffer[5];
        }
    }

    static void pro(){
        input();
        moveOnMap();
    }

    public static void main(String[] args) {
        pro();
    }
}
