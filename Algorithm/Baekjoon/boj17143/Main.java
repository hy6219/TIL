package baekjoon.boj17143;

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

    static class Shark{
        int r;
        int c;
        int speed;
        int size;
        int direction;

        public Shark(int r, int c, int speed, int size, int direction) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.size = size;
            this.direction = direction;
        }

        void move(){
            //상어의 속도%((열(좌,우)/행(상,하)크기-1) *2) 만큼 이동
            int move=this.speed;
            if(direction<2){
                move%=((Main.r-1)*2);

                while(move>0){
                    if(this.r==1){
                        direction=1;
                    }else if(this.r==Main.r){
                        direction=0;
                    }
                    r+=dir[direction][0];
                    move--;
                }
            }else{
                //좌우
                move%=((Main.c-1)*2);

                while(move>0){
                    if(this.c==1){
                        direction=2;
                    }else if(this.c==Main.c){
                        direction=3;
                    }
                    c+=dir[direction][1];
                    move--;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shark shark = (Shark) o;
            return r == shark.r && c == shark.c && speed == shark.speed && size == shark.size && direction == shark.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c, speed, size, direction);
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", speed=" + speed +
                    ", size=" + size +
                    ", direction=" + direction +
                    '}';
        }
    }

    static FastReader scan=new FastReader();
    static int r,c,m;
    static int fisherMan=0;//처음 낚시왕 자리는 원래 0
    static int[][] dir={
            {-1,0},//상
            {1,0},//하
            {0,1},//우
            {0,-1}//좌
    };
    static ArrayList<Shark> sharks;
    static int total=0;
    static Shark[][] map;
    static void input(){
        r=scan.nextInt();
        c=scan.nextInt();
        m=scan.nextInt();

        sharks=new ArrayList<>();
        map=new Shark[r+1][c+1];

        for(int i=0;i<m;i++){
            int r=scan.nextInt();
            int c=scan.nextInt();
            int s=scan.nextInt();
            int d=scan.nextInt();
            int z=scan.nextInt();
            Shark shark=new Shark(r,c,s,z,d-1);
            sharks.add(shark);
            map[r][c]=shark;
        }
    }

    //열이 같다면 행에 대해서 오름차순정렬
    static void arrayByColumn(){
        Collections.sort(sharks, new Comparator<Shark>() {
            @Override
            public int compare(Shark o1, Shark o2) {
                int col1=o1.c;
                int col2=o2.c;

                int row1=o1.r;
                int row2=o2.r;

                if(col1==col2){
                    //열이 같다면 행에 대해서 오름차순 정렬
                    if(row1 < row2) return -1;
                    return 0;
                }else if(col1 < col2) return -1;//열이 다르면 열은 오름차순 정렬해주기

                return 0;
            }
        });
    }

    //낚시왕 이동
    static void fisherMove(){
        if(fisherMan+1<c){
            fisherMan++;
        }else{
            fisherMan=c;
        }
    }

    //땅과 가장 가까운 상어 잡기
    static void catchShark(int col){
        for(int i=1;i<=r;i++){
            //상어가 존재할 때 한마리만 잡기
            if(map[i][col]!=null){
                Shark cur=map[i][col];

                map[i][col]=null;//map에서 상어제거
                //누적
                total+=cur.size;
                //제거
                sharks.remove(cur);
                break;
            }
        }
    }

    //상어 이동
    static void sharkMove(){
        for(int i=0;i<sharks.size();i++){
            sharks.get(i).move();
        }
    }
    //상어 이동 후, 한 칸에 상어가 2마리 이상일 경우
    static void sharkInSameRoom(){
        //1.삭제가 잘 되지 않기 때문에 역방향으로 진행할 것
        //2.삭제가 되지 않아야 할 상어를 특정시키기 위해서 상어를 map 배열에 기록해둘 것

        //이동후 상어기록 초기화
        map=new Shark[r+1][c+1];
        int size=sharks.size();
       for(int i=size-1;i>=0;i--){
           Shark shark1=sharks.get(i);
            //map위치가 비어져 있는 경우
           if(map[shark1.r][shark1.c]==null){
               map[shark1.r][shark1.c]=shark1;
           }else{
               //상어가 존재하는 경우
               if(map[shark1.r][shark1.c].size > shark1.size){
                   sharks.remove(shark1);
                   //map(r,c)가 살아남았기 때문에 별도의 행위는 필요치 않음
               }else{
                   sharks.remove(map[shark1.r][shark1.c]);
                   //shark1이 살아남음
                   map[shark1.r][shark1.c]=shark1;
               }
           }
       }
    }

    static void pro(){
        input();

        for(int i=0;i<c;i++){
            //낚시왕 이동
            fisherMove();
            //열,행별 정렬
            arrayByColumn();
            //땅과 제일 가까운 상어 잡기
            catchShark(fisherMan);
            //상어이동
            sharkMove();
            //같은 칸에 2마리 이상이면 잡아먹기
            sharkInSameRoom();
        }
        System.out.println(total);
    }


    public static void main(String[] args) {
        pro();
    }
}
