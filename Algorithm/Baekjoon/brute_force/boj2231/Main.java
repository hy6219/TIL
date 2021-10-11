package baekjoon.brute_force.boj2231;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

        long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }

    }

    static FastReader r=new FastReader();
    static int N;
    //탐색기록
    static ArrayList<Integer> selected=new ArrayList<>();

    static void input(){
        N=r.nextInt();
    }

    static int partial(int k){
        String s=String.valueOf(k);
        int res=k;

        for(int i=0; i<s.length();i++){
            res+=(s.charAt(i)-'0');
        }

        return res;
    }

    static void pro(){
        for(int cand=1;cand<=N;cand++){
            int test=partial(cand);
            if(test==N){
                selected.add(cand);
            }
        }
        if(selected.size()==0){
            System.out.println(0);
        }else{
            Collections.sort(selected);
            System.out.println(selected.get(0));
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
