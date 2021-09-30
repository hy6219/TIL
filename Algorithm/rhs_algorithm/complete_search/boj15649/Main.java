package rhs_algo.complete_search.boj15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class FastReader{
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
            while(st==null|| !st.hasMoreTokens()){
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
        double nextDouble(){
            return Double.valueOf(next());
        }
    }
    //필드
    static int N,M;//testcase 입력
    static int[] selected;//탐색기록배열
    static int[] used;//중복체크
    //stringbuilder를 이용해서 문자열 결합시 복잡도를 감쇠시키도록
    static StringBuilder sb=new StringBuilder();
    //1.입력함수
    public static void input(){
        FastReader sc=new FastReader();
        N=sc.nextInt();
        M=sc.nextInt();
        selected=new int[M+1];
        used=new int[N+1];
    }
    /*
    **2. 재귀함수
        1. 만약 M개 자리를 모두 고른 경우, 조건에 맞는 탐색을 한 가지 성공한것
      2. 아직 M개를 고르지 않은 경우, k번째부터 M번째 원소를 조건에
    맞게 고르는 모든 방법을 시도
    * -중복을 제거하기 위해 배열값을 0(중복x, 이미 다 사용함), 1(중복o)으로 나누어 접근
    */
    public static void rec_func(int k){
        if(k==M+1){
            //다 고른 경우
            //selected[1..M]배열이 새롭게 탐색된 결과

            //🧡selected배열을 출력해주기
            for(int i=1;i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            boolean isUsed=false;//중복 막기
            //1~N 까지를 k번 원소로(_ _ _ 처럼 _에 채워지는 값) 한번씩 정하고
            for(int cand=1;cand<=N;cand++){
//-->n^2
//                for(int i=1;i<k;i++){
//                    if(cand==selected[i]){
//                        isUsed=true;
//                    }
//                }
//                //중복되지 않은 경우
//               if(!isUsed){
//                   selected[k]=cand;//후보로 중복되지 않은 값을 넣어주고
//                   // 매번 k+1번부터 M번까지 모두 탐색(재귀방식을 이용)
//                   rec_func(k+1);//다음빈칸을 채워주기 위함
//                   //탐색을 해주게 되면, k번째 원소는 탐색해줄 필요가 없기 때문에 0으로 마킹
//                   selected[k]=0;
//               }


                //1이면 중복되었다
                //0이면 중복되지 않았다

                //중복된 경우 다음 값 넣기
                if(used[cand]==1) continue;

                //k번째에 cand가 올 수 있는 경우== 중복이 안된 경우
                //->기록해두고, 중복체크배열에 1로 적용해주기
                selected[k]=cand; used[cand]=1;
                //완전탐색(k+1~M)
                rec_func(k+1);
                //k번째는 이제 탐색하지 않아도 되고, 더이상 candidate 값을 더이상 사용하지 말것임을 명시!
                selected[k]=0; used[cand]=0;
            }


        }
    }
    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb);
    }
}
