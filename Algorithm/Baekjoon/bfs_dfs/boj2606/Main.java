package baekjoon.bfs_dfs.boj2606;

import java.io.*;
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

        Double nextDouble(){
            return Double.valueOf(next());
        }

    }

    static FastReader r=new FastReader();
    static int computer,pair;//컴퓨터,연결 쌍 갯수
    //연결정보
    static int[][] connect;
    //방문체크
    static boolean[] visited;
    static int chk;

    static void input(){
        computer=r.nextInt();
        pair=r.nextInt();
        connect=new int[computer+1][computer+1];
        visited=new boolean[computer+1];

        for(int i=0;i<pair;i++){
            int f=r.nextInt();
            int s=r.nextInt();

            connect[f][s]=connect[s][f]=1;
        }

    }

    static void bfs(int x){
        Queue<Integer> que=new LinkedList<>();

        //시작노드 방문처리
        visited[x]=true;
        //방문할 곳으로 등록
        que.add(x);

        while(!que.isEmpty()){
            //방문할 곳이 남았다면 수행
            int temp=que.poll();

            //방문할 수 있는 곳 방문하기
            for(int i=1;i<=computer;i++){
                if(visited[i]) continue;//방문한적 있다면 방문x
                if(connect[temp][i]==0) continue;//연결되어 있지 않으면 스킵
                //방문처리
                visited[i]=true;
                //방문할 곳으로 등록
                que.add(i);
            }
        }

    }

    static void pro(){
        bfs(1);

  //      System.out.println("visited: "+ Arrays.toString(visited));
        for(int i=2;i< visited.length;i++){
            if(visited[i]==true){
                chk++;
            }
        }
        System.out.println(chk);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
