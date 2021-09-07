package baekjoon.boj1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    //간선 연결상태
    public static int[][] edges;
    //방문확인여부
    public static boolean[] visited;

    public static void main(String[] args){
        int v=0;//vertex
        int e=0;//edge
        int s=0;//search

        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();
        s=sc.nextInt();

        edges=new int[1001][1001];
        visited=new boolean[1001];

        //e만큼 반복해서 입력받고 그래프 구조 확립시키기
        for(int i=0; i<e;i++){
            int first=sc.nextInt();
            int second=sc.nextInt();

            //간선연결상태 저장
            edges[first][second]=edges[second][first]=1;
        }

        dfs(v,s);//dfs호출
        //bfs를 위해서 방문확인 배열 초기화
        visited=new boolean[1001];
        System.out.println();

        bfs(v,s);

        //dfs 결과 출력 후 bfs출력

    }

    private static void dfs(int n, int idx) {
        //방문확인
        visited[idx]=true;
        System.out.print(idx+" ");

        //정점갯수만큼 반복
        for(int i=1; i<=n;i++){
            //해당 정점에 연결된 정점들의 간선연결상태가 확인되고, 방문되지 않은 경우에 한해서 dfs반복
            if(edges[idx][i]==1 && visited[i]==false){
                dfs(n,i);
            }
        }
    }
    //n:정점 갯수, idx:현재 정점

    //start:시작정점
    private static void bfs(int n,int start){
        Queue<Integer> queue=new LinkedList<>();
        //시작점을 넣고 방문처리
        queue.add(start);
        visited[start]=true;

        System.out.print(start+" ");

        while(!queue.isEmpty()){

            //시작노드 빼내기
            int temp=queue.poll();
    //        System.out.print(temp+" ");

            for(int i=1; i<=n;i++){
                //시작노드와 연결된 노드들의 방문이 안되어 있다면
                //연결노드들을 넣고
                //방문처리
                if(edges[temp][i]==1 && visited[i]==false){
                    queue.add(i);
                    visited[i]=true;
                    System.out.print(i+" ");
                }
            }
        }
    }
}
