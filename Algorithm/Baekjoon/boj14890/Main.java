package baekjoon.boj14890;

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
    static int N,L;
    static int[][] map;
    static int[] height;
    static boolean[] visit;
    static int cnt;

    static void input(){
        N=scan.nextInt();
        L=scan.nextInt();

        map=new int[N][N];


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=scan.nextInt();
            }
        }
    }

    //행 또는 열 방향에 따른 검사 진행해야함!
    static void doTest(){
        for(int i=0;i<N;i++){
            //행검사
            if(canGo(i,0,true)){
                cnt++;
            }
            if(canGo(0,i,false)){
                //열검사
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean canGo(int row,int col, boolean flag){
        height=new int[N];
        visit=new boolean[N];

        for(int i=0;i<N;i++){
            if(flag){
                //행검사
                height[i]=map[row][i];
            }else{
                //열검사
                height[i]=map[i][col];
            }
        }

        for(int i=0;i<N-1;i++){
            //높이가 같으면 패스
            if(height[i]==height[i+1]) continue;
            if(height[i+1]-height[i]==1){
                //그 외에 차이가 나는 경우
                //1.올라가는 경우->다음칸과 1차이
                //다음칸이 더 큼
                //그 이전~L번째 인덱스 이전도 모두 경사로 체크
                for(int j=i;j>i-L;j--){
                    //범위를 넘어가거나, 높이가 다르거나(지금은 올라가야 하기때문), 이미 경사로가 있는 경우는 경사로를 놓을 필요가 없음
                    if(j<0 || height[j]!=height[i] || visit[j]) return false;
                    visit[j]=true;
                }
            }else if(height[i]-height[i+1]==1){
                //2.내려가는 경우->다음칸이 더 작음
                for(int j=i+1;j<=i+L;j++){
                    //범위를 넘어가거나, 높이가 다르거나(지금은 내려가야 하기때문), 이미 경사로가 있는 경우는 경사로를 놓을 필요가 없음
                    //i+1이후로는 높이가 달라지면 안됨
                    if(j>=N || height[j]!=height[i+1] || visit[j]) return false;
                    visit[j]=true;
                }
            }else if(Math.abs(height[i]-height[i+1])>1){
                //높이 차이가 2이상이 될 경우
                 return false;
            }
        }
        return true;
    }

    static void pro(){
        input();
        doTest();
    }

    public static void main(String[] args) {
        pro();
    }
}
