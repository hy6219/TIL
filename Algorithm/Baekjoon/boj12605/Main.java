package baekjoon.stack.boj12605;

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
    static Stack<String> stack;

    static void pro(){
        N=scan.nextInt();


        for(int i=0;i<N;i++){
            String str=scan.nextLine();
            //문자열 뒤집기
            System.out.printf("Case #%d: %s\n",i+1,reverseString(str));
        }
    }

    static String reverseString(String input){
        String res="";

        stack=new Stack<>();

        StringTokenizer st=new StringTokenizer(input," ");

        while(st.hasMoreTokens()){
            stack.push(st.nextToken());
        }

        while(!stack.isEmpty()){
            res+=stack.pop()+" ";
        }
        return res;
    }

    public static void main(String[] args) {
        pro();
    }
}
