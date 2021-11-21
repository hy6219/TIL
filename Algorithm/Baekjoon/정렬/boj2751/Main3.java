package baekjoon.sort.boj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {

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
    static int[] arr;

    static void input(){
        N=scan.nextInt();
        arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.valueOf(scan.nextLine());
        }
    }

    static void pro(){
        input();
        mergeSplitFunc(0,arr.length-1);
       StringBuilder sb=new StringBuilder();

       for(int i:arr){
           sb.append(i).append('\n');
       }
        System.out.print(sb);
    }
    //control method
    static void mergeSplitFunc(int left, int right){

        //크기가 1 이하면 볼 필요도 없음
        //따라서 크기가 1 이하가 되는 경우가 되기 전까지 수행
        if(left<right){
            int mid=(left+right)/2;

            mergeSplitFunc(left,mid);
            mergeSplitFunc(mid+1,right);
            mergeFunc(left,mid,right);
        }

    }

    static void mergeFunc(int left, int mid, int right){

        int[] lArr= new int[mid-left+1];//left~mid
        int[] rArr= new int[right-mid];//mid+1~right

        System.arraycopy(arr,left,lArr,0,lArr.length);
        System.arraycopy(arr,mid+1,rArr,0,rArr.length);

        int leftPointer=0, rightPointer=0;
        int lSize= lArr.length;
        int rSize= rArr.length;
        int i=left;

        while(leftPointer< lSize && rightPointer < rSize){
            if(lArr[leftPointer] > rArr[rightPointer]){
               arr[i]=rArr[rightPointer++];
            }else{
                arr[i]=lArr[leftPointer++];
            }
            i++;
        }

        while(leftPointer<lSize){
            arr[i++]=lArr[leftPointer++];
        }

        while(rightPointer<rSize){
            arr[i++]=rArr[rightPointer++];
        }

    }



    public static void main(String[] args) {
        pro();
    }
}
