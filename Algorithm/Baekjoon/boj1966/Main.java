package baekjoon.boj1966;

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

    //원래 인덱스, 중요도순
    static class Document implements Comparable<Document>{
        int idx;
        int priority;

        public Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "idx=" + idx +
                    ", priority=" + priority +
                    '}';
        }

        @Override
        public int compareTo(Document o) {
            if(priority > o.priority){
                return -1;
            }
            return 0;
        }
    }

    //전체테케수
    static int T;
    //문서수
    static int N;
    //궁금한 문서 위치
    static int loc;
    //문서 중요도순서
    static Queue<Document> documents;
    static PriorityQueue<Integer> priorites;
    static FastReader scan=new FastReader();

    static void input(){
        N=scan.nextInt();
        loc=scan.nextInt();

        documents=new LinkedList<>();
        //우선순위 숫자 큰것부터
        priorites=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++){
            int temp=scan.nextInt();
            documents.add(new Document(i,temp));
            priorites.add(temp);
        }

    }

    static int pro() {
        //loc==document.idx비교
        int i=1;

        while(!documents.isEmpty()){
            Document print=documents.poll();

            //우선순위가 갖지 않은 경우
            //뒤에 추가
            if(priorites.peek()!=print.priority){
                documents.add(print);
                continue;
            }

            if(print.idx==loc){
                return i;
            }

            //문서 한개 뽑았기 때문에 제거
            priorites.poll();
            i++;
        }

        return i;
    }


    public static void main(String[] args) {
        T=scan.nextInt();

        for(int i=0;i<T;i++){
            input();
            int res=pro();
            System.out.println(res);
        }
    }
}
