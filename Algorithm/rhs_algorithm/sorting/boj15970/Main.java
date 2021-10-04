package rhs_algo.sort.boj15970;

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
    //색깔별 arrayList
    static ArrayList<Integer>[] a;

    static void input(){
        N=r.nextInt();
        a=new ArrayList[N+1];
        //점들의 위치 x와 색깔 y는 각각 0 ≤ x ≤ 105, 1 ≤ y ≤ N를 만족
        for(int color=1;color<=N;color++){
            a[color]=new ArrayList<>();
        }
        for(int i=1;i<=N;i++){
            int coord=r.nextInt();
            int color=r.nextInt();
            a[color].add(coord);
        }
    }

    static void pro(){
        //색깔별 정렬(오름차순)
        for(int color=1;color<=N;color++){
            Collections.sort(a[color]);
        }
        //거리계산
        int ans=0;

        for(int color=1;color<=N;color++){
            //색깔별로 가까운 점 찾기
            for(int j=0;j<a[color].size();j++){
                //왼쪽점까지의 거리
                int distL=toLeft(color,j);
                //오른쪽점까지의 거리
                int distR=toRight(color,j);
                //둘 중 가까운 값이 인접한 점!!
                //그 점을 거리에 합산!
                ans+=Math.min(distL,distR);
            }
        }
        //정답 출력
        System.out.println(ans);
    }
    //왼쪽점까지의 거리
    static int toLeft(int color,int idx){
        // 색깔이 color 인 점의 idx 번째에 있는 점이 왼쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 왼쪽에 점이 없다면 무한대를 return.
        if(idx==0) return Integer.MAX_VALUE;//첫번재점은 왼쪽에 점이 없음
        return a[color].get(idx)-a[color].get(idx-1);//자기 위치에서 자기 앞의 위치를 빼주면 됨
    }

    //오른쪽점까지의 거리
    static int toRight(int color,int idx){
        // 색깔이 color 인 점의 idx 번째에 있는 점이 오른쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 오른쪽에 점이 없다면 무한대를 return.
        if(idx+1==a[color].size()) return Integer.MAX_VALUE;
        return a[color].get(idx+1)-a[color].get(idx);//오른쪽으로 줄 긋기
    }
    public static void main(String[] args){
        input();
        pro();
    }
}
