package rhs_algo.dfs_bfs.boj2251;

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

        double nextDouble(){
            return Double.valueOf(next());
        }

    }

    static class State{
        int[] X;
        State(int[] _X){
            X = new int[3];
            for (int i=0;i<3;i++) X[i] = _X[i];
        }

        State move(int from,int to,int[] Limit){
            // from 물통에서 to 물통으로 물을 옮긴다.
            int[] nX = new int[]{X[0], X[1], X[2]};
            /* TODO */
            //to가 먼저 찰수도 or from이 먼저 비게 될 수도
            //지금 처음에 C가 채워져 있는 상태가 전체 합 한계이므로
            //to용량한계 <= from+to 이면<=> to 용량이 먼저 찬 경우
            if(X[from]+X[to]>=Limit[to]){
                //from을 조정
                //to 용량 한계와 그 전 용량 차이값만큼이 from이 되어야 함
                nX[from]-=Limit[to]-X[to];
                //to를 가득 채운 경우이므로 limit만큼 채우면 됨
                nX[to]=Limit[to];
            }else{
                //from이 먼저 바닥난 경우
                nX[to]+=nX[from];
                nX[from]=0;
            }
            return new State(nX);
        }
    }

    static FastReader r= new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] Limit;//각 물통의 한계
    static boolean[] possible;//정답으로 가능한 C물통의 경우
    static boolean[][][] visit;//상태마다 탐색한적 있는지 확인

    static void input(){
        Limit=new int[3];
        for(int i=0;i<3;i++) Limit[i]=r.nextInt();
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }

    // 물통 탐색 시작~
    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        //visit check
        visit[x1][x2][x3]=true;
        //need to visit
        Q.add(new State(new int[]{x1,x2,x3}));
        // BFS 과정 시작
        /* TODO */
        while(!Q.isEmpty()){
            //한개 빼내기
            State s=Q.poll();
            //A물통이 비어있는 경우가 문제에서 원하는 경우
            if(s.X[0]==0){
                possible[s.X[2]]=true;
            }
            for(int from=0;from<3;from++){
                for(int to=0;to<3;to++){
                    //3물통이므로 from도 3가지 to도 3가지(0,1,2) 중 1 ->(0,1,2)중 1

                    //같은 물통끼리는 옮길 수 없음
                    if(from==to) continue;
                    State next=s.move(from,to,Limit);//from->to로 옮긴 후의 상태를 저장

                    //방문한적 없을때 방문과정 수행
                    if(!visit[next.X[0]][next.X[1]][next.X[2]]){
                        //방문할 곳으로 등록
                        Q.add(next);
                        //방문처리
                        visit[next.X[0]][next.X[1]][next.X[2]]=true;
                    }
                }
            }
        }
    }

    static void pro() {
        bfs(0, 0, Limit[2]);//처음에는 C만 가득 채웠음
        // 정답 계산하기
        /* TODO */
        for(int i=0;i<=Limit[2];i++){
            //0부터 C를 가득 채워지는 용량 범위까지 살펴보면서
            //가능했던 양인지 확인(A는 비어있는 상황)
            if(possible[i]){
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
