package baekjoon.brute_force.boj17779;

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
    static int N;
    static int[][] map;
    static int one,two,three,four,five;//각 구역 합
    static int MIN=Integer.MAX_VALUE;
    static int MAX=Integer.MIN_VALUE;
    static int ans=Integer.MAX_VALUE;

    static void input(){
        N=scan.nextInt();

        map=new int[N+1][N+1];//x,y>=1


        for(int i=1; i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j]=scan.nextInt();
            }
        }
    }

    //5구역 등 구역 찾아서 경계선과 내부 마킹
    static void markingForAreas(){

        for(int x=1;x<=N;x++){
            for(int y=1;y<=N;y++){
                //d1,d2
                //d2>=1이므로 x+d1+d2대신 x+d1+1
                for(int d1=1;x+d1+1<=N && y-d1>=1; d1++){
                    for(int d2=1;x+d1+d2<=N && y+d2<=N; d2++){
                        boolean[][] visit=new boolean[N+1][N+1];
                        one=0;two=0;three=0;four=0;five=0;
                        //경계선 확인
                        for(int i=0;i<=d1;i++){
                            visit[x+i][y-i]=true;//5구역 1번조건
                            visit[x+d2+i][y+d2-i]=true;//같은 반복구간으로 볼때 4번조건도 이 반복문에서 해결 가능
                        }
                        for(int i=0;i<=d2;i++){
                            visit[x+i][y+i]=true;//2번조건
                            visit[x+d1+i][y-d1+i]=true;//3번조건
                        }

                        //내부[x+1,x+d1+d2-1]에 대해서 마킹
                        for(int i=x+1;i<x+d1+d2;i++){
                            //해당행마다 모든 열 체크
                            for(int j=1;j<=N;j++){
                                //경계선을 찾고
                                if(visit[i][j]){
                                    //영역 마킹
                                    while(++j<=N && !visit[i][j]) visit[i][j]=true;
                                }
                            }
                        }

                        //5영역 값 구하기
                        for(int i=1;i<=N;i++){
                            for(int j=1;j<=N;j++){
                                if(visit[i][j]){
                                    five+=map[i][j];
                                }
                            }
                        }
                        //최댓값 갱신
                        MAX=five;
                        //최솟값 갱신
                        MIN=five;

                        //1구역
                        for(int r=1;r<x+d1;r++){
                            for(int c=1;c<=y;c++){
                                if(!visit[r][c]){
                                    one+=map[r][c];
                                }
                            }
                        }
                        //최댓값 ,최솟값 갱신
                        MAX=Math.max(MAX,one);
                        MIN=Math.min(MIN,one);

                        //2구역
                        for(int r=1;r<=x+d2;r++){
                            for(int c=y+1;c<=N;c++){
                                if(!visit[r][c]){
                                    two+=map[r][c];
                                }
                            }
                        }

                        //최댓값 ,최솟값 갱신
                        MAX=Math.max(MAX,two);
                        MIN=Math.min(MIN,two);

                        //3구역
                        for(int r=x+d1;r<=N;r++){
                            for(int c=1;c<y-d1+d2;c++){
                                if(!visit[r][c]){
                                    three+=map[r][c];
                                }
                            }
                        }

                        //최댓값 ,최솟값 갱신
                        MAX=Math.max(MAX,three);
                        MIN=Math.min(MIN,three);

                        //4구역
                        for(int r=x+d2+1;r<=N;r++){
                            for(int c=y-d1+d2;c<=N;c++){
                                if(!visit[r][c]){
                                    four+=map[r][c];
                                }
                            }
                        }
                        //최댓값 ,최솟값 갱신
                        MAX=Math.max(MAX,four);
                        MIN=Math.min(MIN,four);
                        ans=Math.min(ans,MAX-MIN);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static void pro(){
        input();
        markingForAreas();
    }

    public static void main(String[] args) {
        pro();
    }
}
