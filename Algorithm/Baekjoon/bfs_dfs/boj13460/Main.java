package baekjoon.boj13460;

import java.io.BufferedReader;
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

    static class Ball{
        int redR;
        int redC;
        int blueR;
        int blueC;
        int moveCnt;//이동횟수는 10회 이하여야 함

        public Ball(int redR, int redC, int blueR, int blueC, int moveCnt) {
            this.redR = redR;
            this.redC = redC;
            this.blueR = blueR;
            this.blueC = blueC;
            this.moveCnt = moveCnt;
        }

        @Override
        public String toString() {
            return "Ball{" +
                    "redR=" + redR +
                    ", redC=" + redC +
                    ", blueR=" + blueR +
                    ", blueC=" + blueC +
                    ", moveCnt=" + moveCnt +
                    '}';
        }
    }

    static FastReader scan=new FastReader();
    static int N,M;
    static char[][] map;
    //빨간구슬, 파란구슬 위치에 대해서 마킹
    static boolean[][][][] visit;
    //구멍위치
    static int holeR, holeC;
    static int[][] dir={
            {-1,0},//위쪽
            {0,1},//오른쪽
            {1,0},//아래쪽
            {0,-1}//왼쪽
    };
    //빨간구슬 정보
    static Ball redBall;
    //파란구슬 정보
    static Ball blueBall;

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();

        map=new char[N][M];
        visit=new boolean[N][M][N][M];

        for(int i=0;i<N;i++){
            String str=scan.nextLine();
            for(int j=0;j<M;j++){
                char c=str.charAt(j);
                map[i][j]=c;

                if(c=='O'){
                    //구멍
                    holeR=i; holeC=j;
                }else if(c=='R'){
                    //빨간구슬
                    redBall=new Ball(i,j,0,0,0);
                }else if(c=='B'){
                    //파란구슬
                    blueBall=new Ball(0,0,i,j,0);
                }
            }
        }
    }


    //왼쪽으로 기울이기
    //오른쪽으로 기울이기
    //위쪽으로 기울이기
    //아래쪽으로 기울이기
    //상,우,하,좌 순으로 생각&& 빨간구슬 이동시키고 파란구슬 이동시키기(구슬은 딱 2개뿐)
    static int bfs(){
        Queue<Ball> queue=new LinkedList<>();
        queue.add(new Ball(redBall.redR, redBall.redC, blueBall.blueR,blueBall.blueC,1));//1번 이동함!
        visit[redBall.redR][redBall.redC][blueBall.blueR][blueBall.blueC]=true;


        while(!queue.isEmpty()){
            //하나 꺼내기
            Ball ball=queue.poll();
            int redR=ball.redR;
            int redC=ball.redC;
            int blueR=ball.blueR;
            int blueC=ball.blueC;
            int moveCnt=ball.moveCnt;//이동 횟수

            //10회 이상은 움직일 수 없음
            if(moveCnt>10) return -1;

            //연결된 곳을 이동
            //다음 방향으로 기울여서 이동
            for(int i=0;i<4;i++){
                int nRedR=redR,nRedC=redC,nBlueR=blueR,nBlueC=blueC;
                //구멍위치에 어떤 구슬이 있는지 확인
                boolean redFlag=false;
                boolean blueFlag=false;
                //빨간 구슬 이동
                //벽위치면 종료
                while(true){
                  //  System.out.println(nRedR+" "+nRedC+" "+nBlueR+" "+nBlueC+" "+dir[i][0]+" "+dir[i][1]);
                    nRedR+=dir[i][0];
                    nRedC+=dir[i][1];
                    if(map[nRedR][nRedC]=='#') break;
                   // System.out.println(nRedR+" "+nRedC+" "+nBlueR+" "+nBlueC+" "+dir[i][0]+" "+dir[i][1]);
                    //구멍위치면 기록하고 종료
                    if(nRedR==holeR && nRedC==holeC){
                        redFlag=true;
                        break;
                    }
                }
                if(map[nRedR][nRedC]=='#'){
                    nRedR-=dir[i][0];
                    nRedC-=dir[i][1];
                }
                //파란 구슬 이동
                //벽위치면 종료
                while(true){
                    nBlueR+=dir[i][0];
                    nBlueC+=dir[i][1];

                    if(map[nBlueR][nBlueC]=='#') break;
                    //구멍위치면 기록하고 종료
                    if(nBlueR==holeR && nBlueC==holeC){
                        blueFlag=true;
                        break;
                    }
                }

                if(map[nBlueR][nBlueC]=='#'){
                    nBlueR-=dir[i][0];
                    nBlueC-=dir[i][1];
                }
                //파란구슬 플래그가 true면 한번 더 움직여야 함
                if(blueFlag) continue;
                if(redFlag && !blueFlag) return moveCnt;

                //둘다 구멍에 빠지지 않았는데 위치가 같아진 경우
                //기울이기
                if(nRedR==nBlueR && nRedC == nBlueC && map[nRedR][nRedC]!='O'){
                        //위쪽으로 기울이기
                        //먼저 움직인 사람이 그 위치를 갖게 됨!
                        //따라서 row가 더 위==row가 더 작은 값이었던 사람이 그 자리를 갖게됨
                        //<=>row가 큰값인 구슬의 n~R값을 감소시켜야 함

                        //오른쪽으로 기울이기
                        //col값이 더 큰 구슬이 먼저 움직여서 자리를 선점하게 되므로
                        //col값이 작은 구슬의 n~C값을 -1시켜주면 됨

                        //아래쪽으로 기울이기
                        //row값이 더 큰 값이었던 구슬이 먼저 벽에 도달함
                        //<=>row값이 더 작은 값인 구슬의 n~R값을 뒤로(==즉, 위쪽으로 보내야 함)

                        //왼쪽으로 기울이기
                        //col값이 더 작은 구슬이 먼저 벽에 도달함
                        //<=>col값이 큰 구슬의 col값을 1증가시켜주기<=>-1이므로 빼줘야 함


                    //<=>빨간공과 파란공이 시작점에서 이동한 거리를 계산해서
                    //적게 움직인 공이 먼저 움직인 것으로 할 수 있음
                    //<=>더 많이 움직인 공이 뒤로 가기
                    int redDist=Math.abs(nRedR-redR)+Math.abs(nRedC-redC);
                    int blueDist=Math.abs(nBlueR-blueR)+Math.abs(nBlueC-blueC);

                    if(redDist<blueDist){
                        nBlueR-=dir[i][0];
                        nBlueC-=dir[i][1];
                    }else{
                        nRedR-=dir[i][0];
                        nRedC-=dir[i][1];
                    }
                }
                //방문안한 곳만 방문처리
                if(!visit[nRedR][nRedC][nBlueR][nBlueC]){
                    visit[nRedR][nRedC][nBlueR][nBlueC]=true;
                    queue.add(new Ball(nRedR,nRedC,nBlueR,nBlueC,moveCnt+1));
                }
            }
        }
        // 다 돌아도 내부에서 해결되지 못한, 즉 두 구슬이 모두 나온 경우는 -1 반환
        return -1;
    }

    static void pro(){
        input();
        int ans=bfs();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        pro();
    }
}
