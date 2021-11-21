package baekjoon.sort.boj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

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
            }catch (IOException e){
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

    static FastReader scan=new FastReader();
    static int N;
    static ArrayList<Integer> list=new ArrayList<>();

    static void input(){
        N=scan.nextInt();

        for(int i=0;i<N;i++){
            list.add(Integer.valueOf(scan.nextLine()));
        }
    }

    static void pro(){
        input();
       list=mergeSplitFunc(list);
       StringBuilder sb=new StringBuilder();

       for(int i:list){
           sb.append(i).append('\n');
       }
        System.out.print(sb);
    }
    //control method
    static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> param){
        int size=param.size();

        //크기가 1 이하면 볼 필요도 없음
        if(size<=1) return param;

        int mid=size/2;
        ArrayList<Integer> left=mergeSplitFunc(new ArrayList<>(param.subList(0,mid)));
        ArrayList<Integer> right=mergeSplitFunc(new ArrayList<>(param.subList(mid,size)));

        return mergeFunc(left,right);
    }

    static ArrayList<Integer> mergeFunc(ArrayList<Integer> left,
                                        ArrayList<Integer> right){
        ArrayList<Integer> res=new ArrayList<>();
        int leftPointer=0, rightPointer=0;
        int lSize=left.size();
        int rSize=right.size();

        while(leftPointer< lSize && rightPointer < rSize){
            if(left.get(leftPointer) > right.get(rightPointer)){
                res.add(right.get(rightPointer++));
            }else{
                res.add(left.get(leftPointer++));
            }
        }
        //포인터를 옮기는 것도 중요해서 addAll을 사용하지는 않았음!
        while(leftPointer<lSize){
            res.add(left.get(leftPointer++));
        }

        while(rightPointer<rSize){
            res.add(right.get(rightPointer++));
        }

        return res;
    }



    public static void main(String[] args) {
        pro();
    }
}
