package baekjoon.brute_force.boj17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
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

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static FastReader scan=new FastReader();
    static int N,M,D;
    //궁수는 항상 N행에 존재
    //따라서 x좌표만 기록하면 됨
    static int[] archers;
    //원복좌표, 복사본 좌표
    static int[][] map,copy;
    //방향: 남향,왼쪽, 오른쪾
    static int[][] dir={
            {0,-1},
            {-1,0},
            {0,1}
    };
    //처치가능한 최대 적수
    static int MAX=Integer.MIN_VALUE;

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
        D=scan.nextInt();

        map=new int[N][M];
        copy=new int[N][M];
        archers=new int[3];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=copy[i][j]=scan.nextInt();
            }
        }
    }

    static void init(){
        for(int i=0;i<N;i++){
            map[i]=copy[i].clone();
        }
    }

    //중복되지 않도록 뽑아야 하기 때문에 시작점을 전달해주어야 함:start
    //뽑은 기사수를 위함 : k
    static void simulation(int start, int k){
        if(k==3){
            //다 뽑은 경우
            //공격
            //최댓값 갱신
            MAX=Math.max(MAX,attack());
            return;
        }
        //끝까지 간 경우 종료
        if(start==M) return;
        //한명 뽑기
        archers[k]=start;
        //한명 뽑은 경우를 포함해서 시뮬레이션
        simulation(start+1,k+1);
        //한명을 뽑지 않은 경우를 시뮬레이션
        simulation(start+1,k);
    }

    static int attack(){
        //적이 이동하는 영역 부분에 대해서 점수를 높여놓을것
        int sum=0;//공격에 당한 적들 수를 세기
        //배열 원상복구
        init();
        //성벽측 위측부터 생각
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<3;j++){
                //뽑은 궁수의 x좌표
                int archerX=archers[j];
                //적이 있는 위치라면 무찌를 수 있기 때문에 점수 올려두기
                if(map[i][archerX]!=0) map[i][archerX]++;
                else bfs(i,archerX);//위치가 같지 않다면 순회하면서 거리를 따지기
            }
            //각 행의 적을 공격을 한 후, 각행에 대해 무찌른 적 수를 더하기
            int res=countAttacked(i);
            sum+=res;
        }

        return sum;
    }

    static void bfs(int y,int x){
        Queue<Point> points=new LinkedList<>();
        boolean[][] visited=new boolean[N][M];
        visited[y][x]=true;
        points.add(new Point(x,y));

        int dist=1;
        while(!points.isEmpty()){
            int size= points.size();
            if(dist>D) return;
            for(int j=0;j< size;j++){
                 Point point= points.poll();
                 int curX=point.x;
                 int curY=point.y;

            //적군 위치 점수 올리고 종료<-현재 위치가 적 위치라면 다른 거리를 볼 필요가 없기 때문
                if(map[curY][curX]!=0){
                    map[curY][curX]++;
                    return;
                }

            //연결된 곳 순회
                for(int i=0;i<3;i++){
                    int nx=curX+dir[i][1];
                    int ny=curY+dir[i][0];

                    if(nx<0 || ny<0 || nx>=M) continue;
                    if(visited[ny][nx]) continue;

                    visited[ny][nx]=true;
                    points.add(new Point(nx,ny));
                }
            }
            dist++;//반경 확장하면서 확인해보기
        }
    }

    static int countAttacked(int y){
        //해당 행에 공격당한 적군 수를 점수로 확인
        //1보다 큰 값들을 세면 됨
        int cnt=0;

        for(int i=y;i>=0;i--){
            for(int j=0;j<M;j++){
                if(map[i][j]>1){
                    cnt++;
                    //공격당한 수를 센 후 그 자리는 비워주기
                    map[i][j]=0;
                }
            }
        }

        return cnt;
    }

    static void pro(){
        input();
        simulation(0,0);
        System.out.println(MAX);
    }

    public static void main(String[] args) {
        pro();
    }
}
