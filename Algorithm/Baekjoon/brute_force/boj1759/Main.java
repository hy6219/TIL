package baekjoon.brute_force.boj1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    static int L,C;
    static int[] codes;
    static int[] selected;
    static int[] used;

    static void input(){
        L=scan.nextInt();
        C=scan.nextInt();

        codes=new int[C];
        selected=new int[C];
        used=new int[500];
        for(int i=0;i<C;i++){
            char c=scan.next().charAt(0);
            codes[i]=c;
        }

        Arrays.sort(codes);
    }

    static void rec_func(int start,int k){
        //L개 골라서 조건 만족 확인
        if(k==L){
            int moeum=0;int jaeum=0;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<C;i++){
                char c=(char)selected[i];

                if(c<'a' || c>'z') continue;
                if(c=='a' || c=='e' || c=='i'|| c=='o'||c=='u'){
                    moeum++;
                }else{
                    jaeum++;
                }

                sb.append(c);
            }

            if(moeum>=1 && jaeum>=2){
                String res=sb.toString();
                boolean flag=true;
                for(int i=0;i<res.length()-1;i++){
                    if(res.charAt(i) > res.charAt(i+1)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    System.out.println(res);
                }
            }

        }else{
            for(int cand=start;cand<C;cand++){
                if(used[cand]==1) continue;
                selected[k]=codes[cand]; used[cand]=1;
                rec_func(start+1,k+1);
                selected[k]=0; used[cand]=0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0,0);
    }
}
