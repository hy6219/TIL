package rhs_algo.sort.boj20291;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
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

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }

    }

    static FastReader r=new FastReader();
    static int N;
    static String[] expand;//확장자명만


    public static void input(){
        N=r.nextInt();
        expand=new String[N+1];

        for(int i=0;i<N;i++){
            String temp=r.nextLine();
            StringTokenizer st=new StringTokenizer(temp,".");
            int j=0;
            expand[i]=st.nextToken();
            expand[i]=st.nextToken();
        }
        expand[N]="0";

    }

    static StringBuilder sb=new StringBuilder();
    public static void pro(){
        //정렬
        Arrays.sort(expand, 0,N,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(expand));
        /**
         * @param curCnt: 현재 바라보고 있는 값의 등장 횟수
         * */
        int curCnt=1;

        for(int i=1;i<=N;i++){
            //이전값과 같으면
            if(expand[i].equals(expand[i-1])){
                //현재 등장횟수 증가
                curCnt++;
            }else{
                //이제는 curCnt와 확장자를 넣어줄 차례!
                sb.append(expand[i-1]).append(" ").append(curCnt).append('\n');
                //이전값과 다르면 새로운 값! curCnt=1로 초기화
                curCnt=1;
            }

        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        pro();
    }
}
