package baekjoon.brute_force.boj14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * @author jisoo jeong
     * 연산자갯수:N-1개, 숫자 갯수 N개
     * 1. 연산자 기록 배열, 연산자 개수 배열, 숫자 배열을 활용
     * 2. 연산자 하나를 선택하면 연산자갯수가 1이상이면 연산자 갯수 1감소
     * 3. 기록하고, 다음 단계로 진입(중복 o<-연산자는 여러번 사용될 수 있음)
     * 4. 초기화
     * 5. N-1(숫자가 n개일 때 연산자는 n-1개)번 진행하고 난 후, 계산하고, 최솟값, 최댓값 갱신
     * */
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
            }catch (IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try{
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
    //연산자 갯수 배열
    static int[] op;//0:더하기, 1:빼기, 2: 곱하기, 3: 나누기
    //연산자 기록 배열
    static int[] recordOp;
    //숫자 배열
    static int[] numeric;
    //최댓값
    static int MAX=Integer.MIN_VALUE;
    //최솟값
    static int MIN=Integer.MAX_VALUE;

    static void input(){
        N=scan.nextInt();

        op=new int[4];
        numeric=new int[N];
        recordOp=new int[N];

        for(int i=0;i<N;i++){
            numeric[i]=scan.nextInt();
        }

        for(int i=0;i<4;i++){
            op[i]=scan.nextInt();
        }
    }

    static int calculate(){
        int first=numeric[0];

        for(int i=0;i<N-1;i++){
            if(recordOp[i]==0){
                //더하기
                first+=numeric[i+1];
            }else if(recordOp[i]==1){
                //빼기
                first-=numeric[i+1];
            }else if(recordOp[i]==2){
                //곱하기
                first*=numeric[i+1];
            }else{
                //나누기
                first/=numeric[i+1];
            }
        }
        return first;
    }

    //완전탐색, 기록
    static void selectOperators(int ord){
        if(ord==N-1){
            //연산자를 다 뽑은 것
            //계산
            int calRes=calculate();
            MAX=Math.max(MAX,calRes);
            MIN=Math.min(MIN,calRes);
            return;
        }else{
            //연산자 뽑기, 단 갯수가 1이상일 때 진행
            for(int cand=0;cand<4;cand++){
                //연산자: 0~3
                if(op[cand]>=1){
                    //연산자 갯수가 1 이상일 때 진행
                    //연산자 갯수 1 감소
                    op[cand]--;
                    //연산자 기록
                    recordOp[ord]=cand;
                    //다음단계
                    selectOperators(ord+1);
                    //초기화
                    op[cand]++;
                    //연산자 기록 초기화
                    recordOp[ord]=0;
                }
            }
        }
    }

    static void pro(){
        input();
        selectOperators(0);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void main(String[] args) {
        pro();
    }
}
