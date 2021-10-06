package rhs_algo.dfs_bfs.boj1260;

import java.io.*;
import java.util.*;

public class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException{
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
    static int N,M;//정점, 간선갯수
    static int V;//탐색을 시작할 정점 번호
    static ArrayList<Integer>[] adj;//인접리스트
    static boolean[] visit;//방문 처리<-방문은 간선에 따라 좌지우지되기에 간선갯수만큼!

    static void input(){
        N=r.nextInt();
        M=r.nextInt();
        V=r.nextInt();
        visit=new boolean[N+1];

        adj=new ArrayList[N+1];

        for(int i=1;i<=N;i++){
           adj[i]=new ArrayList<>();//정점들마다 arrayList생성
        }
        for(int i=1;i<=M;i++){
            int f=r.nextInt();
            int s=r.nextInt();

            adj[f].add(s);
            adj[s].add(f);
        }
        //각 헤드노드별로 정렬
        for(int i=1;i<=N;i++){
            Collections.sort(adj[i]);
        }

   //     System.out.println("인접리스트: "+adj);
    }

    //dfs
    static void dfs(int x){
        //처음 노드 방문처리
        visit[x]=true;
        //시작정점 출력
        System.out.print(x+" ");
        //x에서 방문할 수 있는 모든 곳을 방문
        ArrayList<Integer> cand=adj[x];
        for(int i:cand){
            //이미 방문한적 있다면 다시 갈 필요가 없음
            if(visit[i]) continue;
            //그렇지 않다면 탐색
            dfs(i);
        }
    }

    //초기화(visit배열)
    static void reset(){
        for(int i=1;i<=N;i++){
            visit[i]=false;
        }
    }

    //bfs
    static void bfs(int start){
        //방문해야할 곳
        Queue<Integer> que=new LinkedList<>();
        //방문해야할 곳에 넣기
        que.add(start);
        //방문처리
        visit[start]=true;

        while(!que.isEmpty()){
            //아직 방문할 곳이 남았다면

            //먼저 첫 노드 빼내주기
            int x=que.poll();
            System.out.print(x+" ");
            //x에서 방문할 수 있는 모든 노드들 연결정보
            ArrayList<Integer> list=adj[x];
            for(int y:list){
                //만약 방문한적 없다면 지나갈 필요는 없음
                if(visit[y]) continue;
                //그렇지 않으면 방문해야할 곳에 추가하고 방문처리
                que.add(y);
                visit[y]=true;
            }
        }
    }

    public static void main(String[] args){
        input();
        dfs(V);
        reset();
        System.out.println();
        bfs(V);
    }
}
