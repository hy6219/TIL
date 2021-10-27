package baekjoon.boj1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        long nextInt(){
            return Long.valueOf(next());
        }

    }

    static FastReader scan= new FastReader();
    static long min,max;
    static long[] numeric;

    static void input(){
        min= scan.nextInt();
        max= scan.nextInt();
        numeric=new long[1000001];
        int j=0;
        for(long i=min;i<=max;i++){
            numeric[j++]=i;
        }
    }

    static void marking(){
        int sqrt= (int) Math.sqrt(max);
        for(long i=2;i<=sqrt;i++){
            long r=i*i;
            //최솟값부터 시작->
            //1)나누어 떨어지는 경우: min/(i*i)~몫*(i*i)<=max
            //2)나누어 떨어지지 않는 경우: min/(i*i)+1~몫*(i*i)<=max
            long start=(min%r==0)?(min/(i*i)):(min/(i*i))+1;//몫
            for(long cand=start;cand*r<=max;cand++){
                //몫*(i*i)-min인덱스값을 -1로 설정
                numeric[(int)(cand*r-min)]=-1;//min을 빼는 이유는 0부터 떨어진 거리가 min부터 시작되기 때문
            }
        }
    }

    static void pro(){
        int cnt=0;

        for(int i=0;i<(max-min+1);i++){
            if(numeric[i]!=-1) cnt++;
        }
        System.out.println(cnt);
        System.exit(0);
    }

    public static void main(String[] args) {
        input();
        marking();
        pro();

    }
}
