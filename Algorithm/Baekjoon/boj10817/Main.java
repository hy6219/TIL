package baekjoon.boj10817;

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
            }catch (IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

    }

    static FastReader scan=new FastReader();
    static int[] arr=new int[3];

    static void input(){
        arr[0]= scan.nextInt();
        arr[1]= scan.nextInt();
        arr[2]= scan.nextInt();
    }

    static void mergeSplitFunc(int start, int end){
        if(start>=end) return;

        int mid=(start+end)/2;

        //divide
        //왼쪽
        mergeSplitFunc(start,mid);
        //오른쪽
        mergeSplitFunc(mid+1,end);
        //conquer
        //병합
        merge(start,mid,end);
    }

    //내림차순 정렬
    static void merge(int start, int mid, int end){
        int leftPointer=0, rightPointer=0;
        int[] left=new int[mid-start+1];//[start,mid]
        int[] right=new int[end-mid];//[mid+1,end]

        int lSize=left.length;
        int rSize=right.length;
        //배열 복사(<-반절씩 진행할 것이기 때문)
        System.arraycopy(arr,start,left,0,lSize);
        System.arraycopy(arr,mid+1,right,0,rSize);
        int idx=start;
        //왼쪽,오른쪽 모두 진행
        while(leftPointer< lSize && rightPointer<rSize){
            if(left[leftPointer] > right[rightPointer]){
                arr[idx]=left[leftPointer++];
            }else{
                arr[idx]=right[rightPointer++];
            }
            idx++;
        }

        //왼쪽
        while(leftPointer<lSize){
            arr[idx++]=left[leftPointer++];
        }

        //오른쪽
        while(rightPointer<rSize){
            arr[idx++]=right[rightPointer++];
        }
    }

    static void pro(){
        input();
        mergeSplitFunc(0,arr.length-1);
        System.out.print(arr[1]);
    }

    public static void main(String[] args) {
        pro();
    }
}
