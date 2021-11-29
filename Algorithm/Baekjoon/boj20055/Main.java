package baekjoon.boj20055;

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
    static int N,K;
    static int[] belts;
    static boolean[] robots;

    //몇번째 단계
    static int step=0;

    static void input(){
        N=scan.nextInt();
        K=scan.nextInt();

        belts=new int[2*N];
        robots=new boolean[N];

        for(int i=0;i<2*N;i++) belts[i]=scan.nextInt();
    }

    //컨베이어벨트 1칸씩 회전
    static void rotateBelt(){
        //1<-0,...,n-1<-n-2,...,
        //0<-belts.length-1
        //마치 하나의 circle같음
        int pastTemp=belts[belts.length-1];

        for(int i=belts.length-2;i>=0;i--){
            belts[i+1]=belts[i];
        }

        belts[0]=pastTemp;

        //로봇도 같이 움직임
        for(int i=N-2;i>=0;i--){
            robots[i+1]=robots[i];
        }

        robots[0]=false;//로봇 내리기
    }

    //내구도가 0인 곳이 총 몇 곳인지 확인
    static int naeGuDo(){
        int cnt=0;

        for(int i=0;i < belts.length;i++){
            if(belts[i]==0) cnt++;
        }

        return cnt;
    }
    //종료조건
    static boolean isEnd(){
        int checkNg=naeGuDo();//내구도가 0이된 곳 갯수 확인

        if(checkNg>=K) return true;//내구도가 0인 곳의 갯수가 K개 이상이면 종료
        return false;
    }

    static void robot(){
        //0,N에서 로봇 내리기(row==1에서는 로봇상차,하차가 불가능하므로 N크기배열로 정의하였음)
        if(robots[N-1]){
            robots[N-1]=false;
        }
        //중간:1~N-2
        for(int i=N-2;i>0;i--){
            //다음칸에 로봇을 놓을 수 있다면
            if(robots[i] && !robots[i+1] && belts[i+1]!=0){
                //다음칸마킹
                robots[i]=false;
                robots[i+1]=true;
                --belts[i+1];//내구도 감소
            }
        }
        //로봇 올리기(0,0)에
        if(belts[0]>0 && !robots[0]){
            robots[0]=true;
            --belts[0];//내구도 감소
        }
    }

    //종료조건 확인하면서 반복
    static void beltRepeat(){
        boolean flag;

        while(true){
            //회전하기
            rotateBelt();
            step++;
            //로봇움직이기
            robot();

            flag=isEnd();
            if(flag){
                System.out.println(step);
                break;
            }
        }
    }

    static void pro(){
        input();
        beltRepeat();
    }

    public static void main(String[] args) {
        pro();
    }
}
