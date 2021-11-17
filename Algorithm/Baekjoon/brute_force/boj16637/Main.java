package baekjoon.brute_force.boj16637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
            } catch (IOException e) {
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

    //최댓값 초기값, 갱신
    static int max=Integer.MIN_VALUE;
    static FastReader scan=new FastReader();
    //수식길이
    static int len;
    //수식
    static String exp;


    static void input(){
        len=scan.nextInt();
        exp=scan.nextLine();
    }
    //계산
    static int calculate(int x, int y, char c){
        int res=0;

        switch (c){
            case '+':
                res=x+y;
                break;
            case '-':
                res=x-y;
                break;
            case '*':
                res=x*y;
                break;

        }

        return res;
    }


    /**
     * 괄호가 없다면 인덱스를 2씩 건너뛰어주어야 하고,
     * 괄호가 있다면 다음 char는 인덱스가 4차이가 나게 됨!
     * */
    //완전탐색
    static void rec_func(int idx,int total){
        //인덱스가 문자열 길이를 벗어나면 종료
        if(idx>=len){
            max=Math.max(max,total);
            return;
        }
        //괄호가 없는 경우
        //연산자, 숫자가 반복되는 형태
        rec_func(idx+2,calculate(total,exp.charAt(idx)-'0',exp.charAt(idx-1)));

        //괄호가 있는 경우
        //연산자,덩어리 형태
        if(idx+2<len){
            //괄호 내부 합
            int sum=calculate(exp.charAt(idx)-'0',exp.charAt(idx+2)-'0',exp.charAt(idx+1));
            //괄호 내부합+ 이전까지의 합
            int sub=calculate(total,sum,exp.charAt(idx-1));
            rec_func(idx+4,sub);
        }
    }

    static void pro(){
        rec_func(2,exp.charAt(0)-'0');
        System.out.println(max);
    }



    public static void main(String[] args) {
        input();
        pro();
    }
}
