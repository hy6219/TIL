package rhs_algo.sort.boj11652Re;

import java.io.*;
import java.util.*;

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

    static FastReader r= new FastReader();
    static int N;
    //카드값 배열
    static long[] cards;

    public static void input(){
        N=r.nextInt();
      cards=new long[N];

      for(int i=0;i<N;i++){
          cards[i]=r.nextLong();
      }
    }

    public static void pro(){
        //정렬하기
        Arrays.sort(cards);
    //    System.out.println(Arrays.toString(cards));
        //current count: 현재 보고 있는 값의 등장횟수
        //mode count: 최빈값 등장횟수
        //mode: 최빈값
        long mode=cards[0];
        int modeCnt=1;int curCnt=1;

    //2번원소부터 차례대로 보면서
    //같은 숫자가 이어져서 나오고 있는지, 새로운 숫자가 나왔는지에 따라서
    //curCnt 갱신해주고, 최빈값을 갱신
        for(int i=1;i<N;i++){
            if(cards[i]==cards[i-1]){
                //이전값과 같은 값이라면
                //curCnt 증가시켜주고
                //mode는 변경해줄 필요는 없음
                curCnt++;
            }else{
                //이전값과 다른값이면
                //처음보는 것이므로 curCnt=1
                curCnt=1;
            }
            //만약 지금 보고있는 값에 대한 카운트 결과> 최빈값 카운트
            //-> 최빈값 교체시기가 온것!
            if(curCnt>modeCnt){
                mode=cards[i];
                modeCnt=curCnt;
            }

        }
        //정답출력
        System.out.println(mode);
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
