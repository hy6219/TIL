package baekjoon.brute_force.boj2503;

import java.io.*;
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
    static int ck;//찍은값
    //스트라이크, 볼
    static int strike,ball;
    //숫자
    static int[] arr=new int[1000];
    static int cnt=0;

    static void input(){
        ck=r.nextInt();
        strike=r.nextInt();
        ball=r.nextInt();
    }

    static void pro(){

        for(int i=123;i<=987;i++){
            int s_cnt=0;//스트라이크 비교
            int b_cnt=0;//볼 카운트 비교
            boolean flag=true;
            //0이 나오면 안됨
            if((i/100)==0 || (i%100)/10==0 || (i%100)%10==0) continue;
            //각 자리수가 같을 수는 없음
            //백-십, 십-일, 백-일
            if((i/100)==(i%100)/10 || (i%100)/10==(i%100)%10 || (i/100)==(i%100)%10) continue;

            if(arr[i]==-1) continue;

            String stand=String.valueOf(i);
            String comp=String.valueOf(ck);
            //스트라이크
            for(int j=0;j<3;j++){
                char s1=stand.charAt(j);
                char c1=comp.charAt(j);

                if(s1==c1){
                    s_cnt++;
                }
            }


            //볼
            for(int j=0;j<3;j++){
                char c1=stand.charAt(j);
                for(int k=0;k<3;k++){
                    char c2=comp.charAt(k);
                    if(c1==c2){
                        //자릿수가 달라야 함
                        if(j!=k){
                            b_cnt++;
                        }
                    }
                }
            }
            if(s_cnt==strike && b_cnt==ball){
                //스트라이크, 볼 수 만큼일 때만 기록
                arr[i]=1;
            }else{
                arr[i]=-1;
            }
        }
    }

    public static void main(String[] args) {
        N=r.nextInt();

        for(int i=0;i<N;i++){
            input();
            pro();
        }

        for(int i=123;i<=987;i++){
            if(arr[i]==1){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
