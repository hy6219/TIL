package baekjoon.stack.boj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
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
    static Stack<Character> opener;
    static StringBuilder sb;

    static void pro(){
        N=scan.nextInt();
        sb=new StringBuilder();

        for(int i=0;i<N;i++){
            String str=scan.nextLine();
            sb.append(checkPair(str)).append('\n');
        }
        System.out.print(sb);
    }

    static String checkPair(String input){
        opener=new Stack<Character>();

        for(int i=0;i<input.length();i++){
            //'('는 스택에 넣기
            if(input.charAt(i)=='('){
                opener.push(input.charAt(i));
            }else if(opener.isEmpty()){
                //')'를 만나면 스택에서 ( 하나 빼내기
                //그런데 스택이 비어있다면 더이상 빼낼수 없기도 하고
                //이 경우 ) 갯수가 더 많았을 수 있음
                return "NO";
            }else{
                //그 외에는 짝이 맞음
                opener.pop();
            }
        }
        //스택크기가 0이면 yes
        if(opener.isEmpty()) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        pro();
    }
}
