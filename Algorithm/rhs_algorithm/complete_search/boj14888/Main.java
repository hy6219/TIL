package rhs_algo.complete_search.boj14888;

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

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }
    }

    //배열 크기
    static int N;
    //배열 입력
    static int[] arr;
    //연산자 배열
    static int[] op=new int[5];
    //최대,최소
    static int max,min;
    //결과를 string으로 묶어줄것
    static StringBuilder sb=new StringBuilder();
    //기록을 위한 배열
    static int[] record;
    //입력
    public static void input(){
        FastReader r=new FastReader();
        //N입력받기
        N=r.nextInt();
        //배열 초기화
        arr=new int[N+1];
        //기록배열
        record=new int[N+1];
        //배열 입력받기
        for(int i=1;i<=N;i++){
            arr[i]=r.nextInt();
        }
        //연산자 배열 입력받기
        for(int i=1;i<5;i++){
            op[i]=r.nextInt();
        }
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
    }
    //완성된 식에 맞게 계산해서 정답에 갱신하기
    //입력으로 들어온 수열에 대한 배열인 arr과 연산자배열인 op를 이용해서 계산하기
    public static int calculator(){
        //계산된 값을 담을 변수인 value의 초기값은 첫번째 값으로 해주기
        int value=arr[1];

        for(int i=1;i<=N-1;i++){
            if(record[i]==1){
                //덧셈
                value=value+arr[i+1];//다음값요소 더하기
            }else if(record[i]==2){
                //뺄셈
                value=value-arr[i+1];
            }else if(record[i]==3){
                //곱셈
                value=value*arr[i+1];
            }else{
                value=value/arr[i+1];
            }
        }

        return value;
    }
    //완전탐색
    public static void rec_func(int k){
        if(k==N){
            //N번째 연산자라면, 완성된 식에 맞게 계산해서 정답에 갱신하기
            //정한 순서대로 계산
            int value=calculator();
            //최소, 최댓값 비교
            max=Math.max(max,value);
            min=Math.min(min,value);
        }else{
            //k번째 연산자로 어떤 것이 올지 고르는데,
            //후보가 총 네가지(+,-,*,/)
            for(int cand=1;cand<=4;cand++){
                //먼저 연산자가 있는지 확인
                if(op[cand]>=1){
                    //남은 갯수를 감소시킴
                    op[cand]--;
                    //연산자 기록 남기기
                    record[k]=cand;
                    //완전탐색
                    rec_func(k+1);
                    //탐색 후 초기화
                    op[cand]++;
                    record[k]=0;
                }
            }
        }
    }
    public static void main(String[] args){
        input();
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }
}
