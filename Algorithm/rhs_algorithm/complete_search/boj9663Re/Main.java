package rhs_algo.complete_search.boj9663Re;

import java.io.*;
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
            while(st==null|| !st.hasMoreTokens()){
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

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }
    }

    static int N;//N*N
    static int ans;//가능한 모든 경우의 수를 세는 변수
    static int[] col;//지금까지 어떤 열들이 나오는지 기록하는 배열
//col[i]: i번 행의 퀸은 col[i]번 열에 퀸을 놓았다는 기록

    //입력
    static void input(){
        FastReader r=new FastReader();
        N=r.nextInt();
        col=new int[N+1];//기록
    }
    //서로가 공격을 할 수 있는지 확인
    static boolean attackable(int r1,int c1,int r2,int c2){
        //상,하,대각선방향(우측상향, 좌측상향)으로 겹치면 안됨

        //열이 같은 경우==상하로 같은 경우
        if(c1==c2) return true;
        //좌측 상향 대각선에 있는 경우
        //행-열값이 같음
        if(r1-c1==r2-c2) return true;//공격가능
        //우측상향 대각선에 있는 경우
        //행+열 값이 같음
        if(r1+c1==r2+c2) return true;

        //위의 모든 케이스를 다 만족하지 않으면 공격할 수 없음
        return false;
    }
    //맞게 잘 놓였는지 확인
    static boolean validity_check(){
        //모든 핀이 공격할 수 없으면 true
        //공격할 수 있으면 false
        //i번째 행에 놓인 퀸의 위치==즉 그 행의 열값을 이용
        //i번째 행보다 높이 있는 퀸들 중 공격할수 있는 경우를 살핌
        for(int i=1;i<=N;i++){
            //(i,col[i])
            for(int j=1;j<i;j++){
                //(j,col[j])
                if(attackable(i,col[i],j,col[j])){
                    //만약 이 둘이 공격할 수 있다면
                    return false;
                }
            }
        }
        return true;//공격할 수 없는 경우
    }
    //row번~N번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
    static void rec_func(int row){
        //각 행마다 하나씩 잘 놓아서 퀸을 놓을 수 있는 모든 자리에 놓은 경우
        if(row==N+1){
            //서로 공격하는 퀸들이 없는 경우
            //성공적인 경우에 대해서만 호출이 되면 그 경우수만 카운트
            ans++;
        }else{
            //모든 열에 놓아야할 경우
            //==각 행에 대해서 퀸을 놓아야 할 경우
            for(int cand=1;cand<=N;cand++){
                //valid check
                //이 자리에 놓을 수 있는지 확인(row,cand)
                //이전에 놓였던 퀸들을 하나씩 살핌
                boolean possible=true;//불가능 or 가능 체크(놓을수 있는 자리인지)
                for(int i=1;i<=row-1;i++){
                    //(i,col[i])
                    if(attackable(row,cand,i,col[i])){
                        //공격가능한 위치
                        possible=false;
                        break;//더이상 그 이후는 볼 필요도 없음
                    }
                }
                //해당 열의 퀸이 놓일 열에 후보열값을 넣기
                //단, 공격당하지 않을 위치에만!
                if(possible){
                    col[row]=cand;
                    //완전탐색
                    rec_func(row+1);
                    //맞지 않은 경우에 다시 놓을 수 있도록 초기화
                    col[row]=0;
                }
            }
        }
    }
    public static void main(String[] args){
        input();
        rec_func(1);
        //가능한 모든 경우의 수 출력
        System.out.println(ans);
    }
}
