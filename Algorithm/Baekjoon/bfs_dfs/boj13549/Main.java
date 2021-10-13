package baekjoon.bfs_dfs.boj13549;

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
    static int N,K;
    //방문확인
    static boolean[] visited;
    static int[] dist;

    static void input(){
        N=r.nextInt(); K=r.nextInt();
        visited=new boolean[100005];
        dist=new int[100005];
    }

    static void bfs(){
        Queue<Integer> que=new LinkedList<>();
        //시작지점 마킹
        visited[N]=true;
        //방문할 곳으로 등록
        que.add(N);
        dist[N]=0;
        while(!que.isEmpty()){
            int temp=que.poll();

            //좌,우,두배 등 가능한 경우는 모두 움직여주기
            int next=temp*2;

            if(next>=0 && next<=100000 &&!visited[next]){
                visited[next]=true;
                que.add(next);
                dist[next]=dist[temp];//0초후
            }
            next=temp-1;

            if(next>=0 && next<=100000 &&!visited[next]){
                //방문처리
                visited[next]=true;
                que.add(next);
                dist[next]=dist[temp]+1;
            }

            next=temp+1;

            if(next>=0 && next<=100000 &&!visited[next]){
                visited[next]=true;
                que.add(next);
                dist[next]=dist[temp]+1;
            }


        }

    }

    static void pro(){
        bfs();
        System.out.println(dist[K]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
