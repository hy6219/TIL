package rhs_algo.complete_search.boj1182;

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

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }
    }

    static int N;//N개 정수
    static int S;//목표값
    static int ans;//모든 경우의 수를 기록

    static int[] nums;//n개 수 입력 기록
    //입력
    static void input(){
        FastReader r= new FastReader();
        N=r.nextInt();
        S=r.nextInt();
        nums=new int[N+1];

        for(int i=1;i<=N;i++){
            nums[i]=r.nextInt();
        }
    }
    //k번째 원소를 포함시킬지 정하는 함수
//value=k-1번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value){
        if(k==N+1){
            //부분수열을 하나 완성시킨 경우
            //value가 S랑 같으면 경우의 수로 기록
            if(value==S){
                ans++;//하나의 부분수열 발견
            }
        }else{
            //k번째 원소를 포함시킬지 결정하고, 재귀호출
            //포함시키고 싶은 경우
            rec_func(k+1,value+nums[k]);
            //포함시키고 싶지 않은 경우
            rec_func(k+1,value);//지금까지 골랐던 원소들을 더하지 않고 넘겨주기만 하면 됨
        }
    }
    public static void main(String[] args){
        input();
        //맨처음에는 아무런 원소를 고르지 않았기에 value=0으로 제공
        rec_func(1,0);
        //ans가 정말 "진부분집합==비어있지 않은 부분집합"만 다루는지 확인하기
        //S==0인 경우, 전부다 불포함시킨 상황에서 비교하기 때문에 이 경우에 대한 처리가 필요
        if(S==0){
            ans--;//공집합 경우를 제외시키기
        }
        System.out.println(ans);
    }
}
