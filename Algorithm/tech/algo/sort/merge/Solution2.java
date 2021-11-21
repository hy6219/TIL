package tech.algo.sort.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
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
            return Integer.parseInt(next());
        }
    }

    static FastReader scan=new FastReader();
    static int N;
    static int[] arr;

    static void input(){
        N=scan.nextInt();
        arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=scan.nextInt();
        }
    }
    //퀵정렬은 피벗을 찾고, 왼쪽과 오른쪽 부분에 대해서 계속 피벗을 찾아 반복한다면
    //머지소트는 쪼갤수 있는 만큼 나누고 일련의 활동을 반복
    //control method with  divide & conquer
    static void mergeSplitFunc(int start, int end){
        //크기가 1개가 되는 경우는 별도 수행하지 않아도 됨
        if(start>=end) return;

        //크기가 1이 아닌 경우는
        //가운데를 기점으로 계속 n/2씩 나누기
        int mid=(start+end)/2;
        //divide
        mergeSplitFunc(start,mid);
        mergeSplitFunc(mid+1,end);
        //conquer
        merge(start,mid,end);
    }

    static void merge(int start, int mid, int end){
        int leftPointer=0, rightPointer=0;

        int[] left=new int[mid-start+1];//[start~mid]
        int[] right=new int[end-mid];//[mid+1~end]
        int lSize=left.length;
        int rSize=right.length;
        int idx=start;//start부터 채우기

        //반절씩 나누는데 배열복사가 필요함
        System.arraycopy(arr,start,left,0,left.length);
        System.arraycopy(arr,mid+1,right,0,right.length);

        //#1.왼쪽과 오른쪽 모두 살펴볼 것이 있는 경우
        while(leftPointer<lSize && rightPointer < rSize){
            if(left[leftPointer] > right[rightPointer]){
                arr[idx] = right[rightPointer++];
            }else{
                arr[idx] = left[leftPointer++];
            }
            idx++;
        }

        //#2.왼쪽만 남은 경우
        while(leftPointer<lSize){
            //왼쪽을 모두 넣기
            arr[idx++]=left[leftPointer++];
        }

        //#3.오른쪽만 남은 경우
        while (rightPointer<rSize){
            //오른쪽을 모두 넣기
            arr[idx++]=right[rightPointer++];
        }
    }

    //total
    static void pro(){
        input();
        mergeSplitFunc(0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        pro();
    }
}
