package baekjoon.brute_force.boj15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            }catch(IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
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

    }

    static class Plot{
        int x;
        int y;

        public Plot(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    static FastReader scan=new FastReader();
    static int N,M;
    static int[][] room;
    static ArrayList<Plot> chicken=new ArrayList<>();
    static ArrayList<Plot> home=new ArrayList<>();
    static int d=Integer.MAX_VALUE;
    //고른 치킨집 기록
    static Stack<Plot> selected=new Stack<>();//가장 늦게 넣은 것을 빼내야 하므로

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();

        room=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                int type=scan.nextInt();
                room[i][j]=type;
                if(type==1) home.add(new Plot(i,j));
                else if(type==2) chicken.add(new Plot(i,j));
            }
        }
    }

    //최소거리
    static void calcDistance(){
        int sum=0;
        //집하나 기준으로 삼기
        for(int i=0;i<home.size();i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<selected.size();j++){
                //목적지를 변경해가면서 재보기
                int distance=Math.abs(home.get(i).x-selected.get(j).x)+
                        Math.abs(home.get(i).y-selected.get(j).y);
                //최소가 되는 목적지를 찾기
                min=Math.min(min,distance);
            }
            sum+=min;
            //최소거리가 아니라면 종료
            if(sum > d){
                return;
            }
        }
        d=Math.min(d,sum);
    }

    //M개 고르기
    static void rec_func(int start,int k){
        if(k==M){
            //최소 거리 계산하기
            calcDistance();
            return;
        }else{
           for(int i=start;i<chicken.size();i++){
               selected.push(chicken.get(i));
               rec_func(i+1,k+1);
               selected.pop();
           }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0,0);
        System.out.println(d);
    }
}
