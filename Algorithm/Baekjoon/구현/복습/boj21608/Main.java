package baekjoon.boj21608;

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
    //학생
    static class Student{
        int r;
        int c;
        int[] friends;//좋아하는 학생들

        public Student(int r, int c, int[] friends) {
            this.r = r;
            this.c = c;
            this.friends = friends;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "r=" + r +
                    ", c=" + c +
                    ", friends=" + Arrays.toString(friends) +
                    '}';
        }
    }

    static FastReader r= new FastReader();
    static int N;
    static int LIMIT;//N^2까지 제한
    //학생번호별 좋아하는 학생수
    static Map<Integer,Student> list=new HashMap<>();
    //점수화하여 자리배치
    static int[][] classroom;
    //빈자리점수
    static int[][] empty;
    static int[][] dir={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };

    //입력받기
    static void input(){
        N=r.nextInt();
        LIMIT=N*N;

        classroom=new int[N+1][N+1];//1~N+1

        emptySeat();

        for(int i=1;i<=LIMIT;i++){
            int num=r.nextInt();
            int[] friends=new int[4];
            for(int j=0;j<4;j++){
                friends[j]=r.nextInt();
            }
            fillSeat(num,friends);
        }
    }

    //점수화해서 자리배치시키기(번호-좋아하는 학생들)
    static void fillSeat(int num,int[] friends){
        int[][] nearScore=new int[N+1][N+1];//매번호마다 수행해줄 필요가 있어서 지역 변수로 선언
        //친한친구 자리 점수 올리기
        for(int friend:friends){
            //먼저 map구조에 친한친구가 저장(등록)되었는지 확인
            boolean flag=list.containsKey(friend);

            if(flag){
                Student student=list.get(friend);
                int r=student.r;
                int c= student.c;

                for(int i=0;i<4;i++){
                    int nr=r+dir[i][0];
                    int nc=c+dir[i][1];

                    //영역을 벗어난 경우 제외
                    if(nr<1 || nc<1 || nr>=N+1 || nc>=N+1) continue;
                    //빈칸이 아닌 경우는 이미 자리가 있다는 것이므로 제외시키기
                    if(classroom[nr][nc]!=0) continue;
                    nearScore[nr][nc]++;
                }
            }
        }
       //최대 점수나 빈 점수에 따라 자리 선점하기
        int nearScoreMax=-1;
        int emptyScoreMax=-1;
        int choiceR=-1;
        int choiceC=-1;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                //이미 자리가 채워져 있다면 스킵
                if(classroom[i][j]!=0) continue;
                //저장된 인접점수보다 높다면 인접점수와 빈 점수를 교체해주고,
                //자리 선점해주기
                //빈점수도 교체해주어야, 이후 진행에서 갱신되어 연산가능
                if(nearScoreMax<nearScore[i][j]){
                    nearScoreMax=nearScore[i][j];
                    choiceR=i; choiceC=j;
                    emptyScoreMax=empty[i][j];
                }else if(nearScoreMax==nearScore[i][j] && empty[i][j]>emptyScoreMax){
                    //인접점수가 높다면, 빈 점수로 점수화
                    //이경우는 빈점수만 갱신해주기
                    //행번호가 적거나 열번호가 적은 경우는 유사한 상황처리가 이루어지므로
                    //더 수행해줄 필요는 없음
                    emptyScoreMax=empty[i][j];
                    choiceR=i;choiceC=j;
                }
            }
        }
        //좋아하는 친구들이 있는 자리를 기준으로 점수가 높은 기준에 따라
        //선택된 r,c값에 num학생 앉히기
        classroom[choiceR][choiceC]=num;
        list.put(num,new Student(choiceR,choiceC,friends));//map구조 완성시키기
        //배치된 자리 기준 빈 자리 점수를 낮춰주기
        for(int i=0;i<4;i++){
            int nr=choiceR+dir[i][0];
            int nc=choiceC+dir[i][1];

            //영역을 벗어난 경우 제외
            if(nr<1 || nc<1 || nr>=N+1 || nc>=N+1) continue;
            //빈칸이 아닌 경우는 이미 자리가 있다는 것이므로 제외시키기
            if(classroom[nr][nc]!=0) continue;

            empty[nr][nc]--;
        }
    }

    //빈 자리 초기화
    static void emptySeat(){
        empty=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                int cnt=4;
                if(i==1 ||i==N) cnt--;
                if(j==1 || j==N) cnt--;
                empty[i][j]=cnt;
            }
        }
    }

    static int satisfiy(){
        int ans=0;//만족도 점수 합계
        for(int i=1;i<=LIMIT;i++){
            Student student=list.get(i);//학생번호를 기준으로 찾아와서 만족도 조사
            int cnt=0;
            int r= student.r;
            int c= student.c;

            for(int friend: student.friends){
                //인접한지 확인
                int r1=list.get(friend).r;
                int c1=list.get(friend).c;
                int dist=(int)(Math.abs(r-r1)+Math.abs(c-c1));
                if(dist==1) cnt++;
            }

            if(cnt>0) ans+=Math.pow(10,cnt-1);
        }
        return ans;
    }

    static void pro(){
        input();//입력+빈자리 초기화+자리배치
        //만족도조사
        int res=satisfiy();
        System.out.println(res);
    }

    public static void main(String[] args) {
        pro();
    }
}
