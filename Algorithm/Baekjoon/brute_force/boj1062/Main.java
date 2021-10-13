package baekjoon.brute_force.boj1062;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
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
    static int N,K;
    //단어배열
    static String[] words;
    //중복체크 기록
    static boolean[] check=new boolean[26];
    static int ans;

    static void input(){
        N=r.nextInt(); K=r.nextInt();

        words=new String[N];
        if(K < 5){
            System.out.println(0);
            System.exit(0);
        }

        if(K==26){
            //모든 단어를 가르칠 수 있음
            System.out.println(N);
            System.exit(0);
        }

        for(int i=0;i<N;i++){
            words[i]=r.nextLine();
        }
    }

    static void pro(){
        //anta->4부터 인덱스 신경쓰기
        //tica->길이-5까지 신경쓰기
        //단, anta,tica는 포함되어 있기 때문에, K<5 이면 0!!

        check['a'-'a']=true;
        check['n'-'a']=true;
        check['t'-'a']=true;
        check['i'-'a']=true;
        check['c'-'a']=true;



      //anta.tica 제외하고 시작하기

        rec_func(0,0);
        System.out.println(ans);
    }

    static void rec_func(int cur,int start){
        if(cur==K-5){
            //배울 수 있는 글자,단어가 있는지 탐색
            int cnt=0;
            for(int i=0;i<N;i++){
                boolean flag=true;
                for(int j=0;j<words[i].length();j++){

                    if(!check[words[i].charAt(j)-'a']){
                        //방문하지 않은 경우, 즉 배울 수 없는 경우
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    //배울 수 있는 경우
                    cnt++;
                }
            }
            ans=Math.max(ans,cnt);
            return;
        }else{
            //K(anta tica 제외된. 에서 배울 수 있는 글자/단어 등록
            for(int i=start;i<26;i++){
                //이미 등록되어 있으면 체크하지 않기
                if(check[i]) continue;
                check[i]=true;
                rec_func(cur+1,i+1);
                check[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
