package baekjoon.brute_force.boj17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
    static int N,M,K;
    static int[][] A;
    static int r,c,s;
    static int min=Integer.MAX_VALUE;
    static int[][] record;

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
        K=scan.nextInt();

        A=new int[N][M];
        record=new int[K][3];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=scan.nextInt();
            }
        }
    }

    static void pro(){
        //K번
        for(int i=0;i<K;i++){
            int r=scan.nextInt()-1;//cause : index
            int c=scan.nextInt()-1;
            int s=scan.nextInt();

            record[i]=new int[]{r,c,s};
        }

        //연산의 순열(<-순서) 구하기
        permutation(new boolean[K],new LinkedList<Integer>());
        System.out.println(min);
    }

    static void permutation(boolean[] visited, LinkedList<Integer> perm){
        //K번 뽑았는지 확인
        //perm에는 k번 순열에 따른 왼쪽 끝, 오른쪽 끝 좌표 정보를 담고 있음
        if(perm.size()==K){
            //배열 복사
            int[][] cp=copyMap();
            //뽑은 순열 대로 배열 돌리기
            for(Integer idx:perm){
                int r=record[idx][0];
                int c=record[idx][1];
                int s=record[idx][2];

                calcPoint(r,c,s,cp);
            }

            min=Math.min(min,calcArr(cp));//배열의 값 구하기
            return;
        }else{
            //perm채우기
            for(int i=0;i<K;i++){
                if(visited[i]) continue;

                perm.add(i);
                visited[i]=true;

                permutation(visited,perm);

                perm.removeLast();
                visited[i]=false;
            }
        }
    }

    static void calcPoint(int r, int c, int s, int[][] map){
        for(int i=0;i<s;i++){
            //총 s 번의 정사각형을 부딪히게 됨

            //가장 위쪽 왼쪽
            int upperX=r-s+i;
            int upperY=c-s+i;

            //가장 아래쪽 오른쪽
            int lowerX=r+s-i;
            int lowerY=c+s-i;

            //회전
            rotate(map,upperX,upperY,lowerX,lowerY);
        }
    }

    static void rotate(int[][] map, int upperX, int upperY,
                       int lowerX, int lowerY){
        int temp=0;
        int pastTemp=0;//구 시작점을 담기

        //1.윗변
        //꺾이는 포인트값 저장
        temp=map[upperX][lowerY];

        //열방향기준으로 움직이면서 바꾸어주기
        // 0 1 2 3 4 5 이렇게 되어있었다면(열)
        //1~5에 대해서 바꿔주기
        //그렇게 되면 0이 바뀌지 않았기 때문에 이부분을
        //오른쪽변을 진행하면서 관리해주어야 함
        for(int y=lowerY; y>upperY;y--){
            map[upperX][y]=map[upperX][y-1];
        }

        //2. 오른쪽 변
        pastTemp=temp;
        //시작점 넣기
        temp=map[lowerX][lowerY];//아래에서 위로 올라간다고 생각
        for(int x=lowerX;x>upperX;x--){
            if(x-1==upperX){
                map[x][lowerY]=pastTemp;
                continue;
            }
            map[x][lowerY]=map[x-1][lowerY];
        }//6 by 6을 생각한다면 오른쪽 윗부분에 이전에 옮겨지지 못한 값이 저장됨<-어디든 구 시작점을 한 군데에 넣어
        //놓아야 함(그 행/열 내에)

        //3. 아랫변
        pastTemp=temp;
        temp=map[lowerX][upperY];//왼쪽 하단 끝에 구 시작점을 저장해둘 것
        for(int y=upperY; y<lowerY; y++){
            if(y+1==lowerY){
                map[lowerX][y]=pastTemp;
                continue;
            }
            map[lowerX][y]=map[lowerX][y+1];//<- 즉 오른쪽 값이 왼쪽으로 옮겨짐
        }

        //4. 왼쪽
        pastTemp=temp;
        //(upperX,upperY)에 이전 끝점을 넣어줄 것
        for(int x=upperX;x<lowerX;x++){
            if(x+1==lowerX){
                map[x][upperY]=pastTemp;
                continue;
            }
            map[x][upperY]=map[x+1][upperY];//아래 있던 값이 윗쪽으로 옮겨짐
        }
        return;
    }

    static int[][] copyMap(){
        int[][] map=new int[N][M];

        for(int i=0;i<N;i++){
            System.arraycopy(A[i],0,map[i],0,M);
        }
        return map;
    }

    static int calcArr(int[][] arr){
        int low=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr[i].length;j++){
                sum+=arr[i][j];
            }
            low=Math.min(low,sum);
        }
        return low;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
