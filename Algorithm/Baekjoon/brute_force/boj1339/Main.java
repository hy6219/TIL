package baekjoon.brute_force.boj1339;

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

    static FastReader scan=new FastReader();
    static int N;
    //입력된 문자열 저장해두기
    static String[] str;
   //각 알파벳별 자릿수합(->계수) 더해두기
    static Integer[] alpha=new Integer[26];

    static void input(){
        N=scan.nextInt();
        str=new String[N];

        for(int i=0;i<N;i++){
            str[i]=scan.nextLine();
        }
        Arrays.fill(alpha,0);//null pointer exception 예방
    }

    static void pro(){
        for(int i=0;i<str.length;i++){
            int pos=1;
            for(int j=str[i].length()-1;j>=0;j--){
                alpha[str[i].charAt(j)-'A']+=pos;
                pos*=10;
            }
        }
        //계수가 큰 순서대로, 즉 내림차순 정렬
        Arrays.sort(alpha,Collections.reverseOrder());
        int val=9;
        int ans=0;
        for(int i=0;i<alpha.length;i++){
            if(alpha[i]==0) break;//등장한적 없는 알파벳
            ans+=alpha[i]*val--;
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        input();
        pro();
    }
}
