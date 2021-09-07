package baekjoon.boj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    //행수
    static int row;
    //열수
    static int col;

    //연결상태
    static int[][] edges;
    //방문상태
    static boolean[][] visited;
    /*상: 0,1 하:0,-1,좌:-1,0 우 : 1,0
    *
    * */
    //좌우하상
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        row=Integer.valueOf(st.nextToken());
        col=Integer.valueOf(st.nextToken());

        edges=new int[row][col];
        visited=new boolean[row][col];

        for(int i=0; i<row;i++){
            String s=br.readLine();
            for(int j=0; j<col;j++){
                edges[i][j]=s.charAt(j)-'0';
            }
        }

        //처음 시작은 방문처리
        visited[0][0]=true;
        //(0,0)부터 시작
        bfs(0,0);
        System.out.println(edges[row-1][col-1]);
    }

    private static void bfs(int x, int y){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});//방문할 곳을 큐에 넣기

        while(!queue.isEmpty()){
            int[] temp=queue.poll();//각 연결부분의 첫부분 꺼내기
            int nowX=temp[0];
            int nowY=temp[1];

            for(int i=0; i<4;i++){
                int nextX=nowX+dx[i];
                int nextY=nowY+dy[i];

                if(nextX<0 || nextY<0|| nextX >=row ||nextY >=col){
                    //사각형같은 틀범위를 벗어나면 다시 for loop
                    continue;
                }
                //방문한적이 있거나, 0으로 채워진 경우는 for로
                if(visited[nextX][nextY] || edges[nextX][nextY]==0){
                    continue;
                }

                //이렇게 되면 방문한적이 없었거나 영역범주를 만족하거나 연결관계가 있는 적절한 정보만 남음
                //큐에 (nextX,nextY)를 넣고
                queue.add(new int[]{nextX,nextY});
                //그래프에는 지금 지나온 것으로 표기하기 위해서 now(이전)값 +1처리-->대각선 맨 마지막에서 더해진 값이
                //최단거리 합이 구해짐
                edges[nextX][nextY]=edges[nowX][nowY]+1;
                visited[nextX][nextY]=true;//방문처리
            }
        }

    }
}
