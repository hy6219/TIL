package baekjoon.boj16235;

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

    static class Tree{
        int r;
        int c;
        int age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "r=" + r +
                    ", c=" + c +
                    ", age=" + age +
                    '}';
        }


    }

    static FastReader scan=new FastReader();
    static int N,M,K;
    static int[][] yangbun;//초기화된 양분을 저장할 양분배열
    static int[][] board;//양분입력,계산저장기록
    //트리정보<-arraylist가 시간이 소요되는듯
    static LinkedList<Tree> info=new LinkedList<>();
    //죽은 나무 리스트
    static Queue<Tree> death=new LinkedList<>();
    static int[][] dir={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
            {-1,-1},
            {-1,1},
            {1,-1},
            {1,1}
    };

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
        K=scan.nextInt();
        //양분정보
        yangbun=new int[N+1][N+1];
        board=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                yangbun[i][j]=scan.nextInt();
                board[i][j]=5;
            }
        }

        for(int i=1;i<=M;i++){
            info.add(new Tree(scan.nextInt(), scan.nextInt(), scan.nextInt()));
        }
        //Collections.sort(info);//나이 순으로 정렬
    }

    static void myTree(){
        int yr=0;
        while(true){
            if(yr==K) return;

            //봄
            //나이만큼 섭취
            Iterator iterator=info.iterator();
            while(iterator.hasNext()){
                Tree tree=(Tree)iterator.next();
                int r=tree.r;
                int c=tree.c;
                int age=tree.age;
                if(age > board[r][c]){
                    //양분을 못먹고 죽음
                    iterator.remove();
                    death.add(tree);
                }else{
                    //양분을 먹을 수 있음
                    board[r][c]-=age;//나이만큼 줄어듦
                    //나이는 1증가
                    tree.age++;
                }
            }

            //여름
            while(!death.isEmpty()){
                Tree tree=death.poll();//봄에 죽은 나무를 양분으로 씀
                board[tree.r][tree.c]+=tree.age/2;
            }

            //가을
            //번식되는 나무들을 기록해두었다가 합치기(원본을 가지고 연산하기에는 원본훼손이될 수 있음)
            Queue<Tree> que=new LinkedList<>();

            for(Tree t:info){
                int r=t.r;
                int c=t.c;

                for(int i=0;i<8;i++){
                    int nr=r+dir[i][0];
                    int nc=c+dir[i][1];

                    if(nr<1 || nc<1 || nr>N || nc>N) continue;
                    if(t.age%5!=0) continue;//5배수로 되지 않는 나이를 가진 나무면, 번식할 수 없음

                    que.add(new Tree(nr,nc,1));
                }

            }
            //합치기
            info.addAll(0,que);

            //겨울
            for(int r=1;r<=N;r++){
                for(int c=1;c<=N;c++){
                    board[r][c]+=yangbun[r][c];
                }
            }
            yr++;
        }

    }

    static void pro(){
        input();
        myTree();
        System.out.println(info.size());
    }

    public static void main(String[] args) {
        pro();
    }
}
