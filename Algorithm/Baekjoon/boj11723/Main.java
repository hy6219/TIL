package baekjoon.boj11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

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

    static class JibHap{
        Set<Integer> list=new HashSet<>();

        public JibHap() {
        }


        void add(int x){
            list.add(x);
        }

        void remove(int x){
            boolean flag=check(x);
            if(flag) list.remove(x);
        }

        boolean check(int x){
            boolean flag=list.contains(x);
            return flag;
        }

        void toggle(int x){
            boolean flag=check(x);

            if(flag){
                //존재
                remove(x);
            }else{
                //존재x
                add(x);
            }
        }

        void all(){
            IntStream.range(1,21).forEach(i->add(i));
        }

        void empty(){
            list.clear();//공집합으로 만들기
        }

        @Override
        public String toString() {
            return "JibHap{" +
                    "list=" + list +
                    '}';
        }
    }

    static FastReader scan=new FastReader();
    //연산수
    static int M;
    //집합
    static JibHap jibHap=new JibHap();
    static StringBuilder sb=new StringBuilder();
    static void pro(){
        M=scan.nextInt();

        for(int i=0;i<M;i++){
            String str=scan.nextLine();
            int numeric=0;

            if(str.contains("add")){
                numeric=Integer.parseInt(str.substring(4));
                jibHap.add(numeric);
            }else if(str.contains("remove")){
                numeric=Integer.parseInt(str.substring(7));
                jibHap.remove(numeric);
            }else if(str.contains("check")){
                numeric=Integer.parseInt(str.substring(6));
                boolean flag=jibHap.check(numeric);
                sb.append(flag==true?1:0).append('\n');
            }else if(str.contains("toggle")){
                numeric=Integer.parseInt(str.substring(7));
                jibHap.toggle(numeric);
            }else if(str.equals("all")){
                jibHap.all();
            }else if(str.equals("empty")){
                jibHap.empty();
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) {
        pro();
    }
}
