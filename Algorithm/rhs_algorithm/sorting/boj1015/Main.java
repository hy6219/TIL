package rhs_algo.sort.boj1015;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * A        P       B
 * 2       ?       1
 * 3       ?       2
 * 1      ?         3
 * ->인덱스를 활용
 * -> * A        P       B
 *  * 2       ?       (1,원래 A에서의 인덱스 2)
 *  * 3       ?       (2,원래 A에서의 인덱스 0)
 *  * 1      ?         (3,원래 A에서의 인덱스 1)
 *  
 ->B[P[i]]=A[i]<=>P[i]=i<=>P[idx]=b_idx
 idx:A의 원 인덱스
 * */
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

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }

    }

    //(A[i],i)==(A배열의 값, 인덱스값)을 클래스로 관리
    static class Elem implements Comparable<Elem>{

        /**
        * @param idx A배열의 idx위치를 기억하는 변수
         * @param num A[idx]의 원래 값
        * */
        public int num,idx;

        @Override
        public int compareTo(Elem o) {
            //TODO
            //정렬 조건에 맞게 정렬하기
            //1.num의 비내림차순
            if(num!=o.num) return num-o.num;
            //2.num이 같으면 idx오름차순(. 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.)
            return idx-o.idx;//object에 대해서 Tim sort가 있기 때문에(자바에서)
            //이부분이 생략되어도 됨

        }
    }
    static int N;
    static int[] A;
    static Elem[] B;
    static int[] P;
    static FastReader r=new FastReader();
    static StringBuilder sb=new StringBuilder();

    static void input(){
        N=r.nextInt();
        A=new int[N];
        P=new int[N];
        B=new Elem[N];
        for(int i=0;i<N;i++){
            A[i]=r.nextInt();
            //TODO:Elem의 정의에 맞게 B[i]에 값을 넣어주기
            B[i]=new Elem();
            B[i].num=A[i];
            B[i].idx=i;
            //->처음에는 이름은 B지만 A배열이나 마찬가지가 됨
            //->이를 정렬시켜줘야 함
        }
    }
    static void pro(){
        // TO DO
        // B배열 정렬
        Arrays.sort(B);
        // B배열값을 이용해서 P배열 채우기
        //P[idx]=b_idx
        for(int i=0;i<N;i++){
            P[B[i].idx]=i;
        }
        //P배열 출력하기
        for(int x:P){
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
    public static void main(String[] args){
        input();
        pro();
    }
}
