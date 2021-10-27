package baekjoon.boj7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    static class Human{
        int idx;
        int weight;
        int height;
        int rank;

        public Human(int idx, int weight, int height, int rank) {
            this.idx = idx;
            this.weight = weight;
            this.height = height;
            this.rank = rank;

        }

        @Override
        public String toString() {
            return "Human{" +
                    "idx=" + idx +
                    ", weight=" + weight +
                    ", height=" + height +
                    ", rank=" + rank +
                    '}';
        }
    }


    static FastReader scan=new FastReader();
    static ArrayList<Human> human=new ArrayList<>();
    static int N;

    static void input(){
        N=scan.nextInt();
        for(int i=0;i<N;i++){
            int w=scan.nextInt();
            int h=scan.nextInt();
            human.add(new Human(i,w,h,0));
        }

    }

    static void ranking(){
        for(int i=0;i<human.size();i++){
            int rank=1;
            for(int j=0;j<human.size();j++){
                if(i==j) continue;//같은사람은 비교하지 않음
                if(human.get(i).weight<human.get(j).weight &&
                human.get(i).height<human.get(j).height){
                    rank++;
                }
            }
            human.get(i).rank=rank;
        }
        StringBuilder sb=new StringBuilder();

        for(Human h:human){
            sb.append(h.rank).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        ranking();
    }
}
