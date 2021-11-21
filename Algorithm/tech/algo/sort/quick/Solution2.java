package tech.algo.sort.quick;

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

    //control method
    static void sort(){
        quickSort(0,arr.length-1);
    }

    static void quickSort(int low, int high){
        //크기가 1인 경우는 종료
        if(low>=high) return;

        //divide
        //pivot 설정
        int pivot=partition(low,high);

        //conquer
        //왼쪽과 오른쪽으로 쪼개어 접근
        quickSort(low,pivot-1);
        quickSort(pivot+1,high);
    }

    static int partition(int left, int right){
        int low=left;
        int high=right;
        int pivot=arr[left];

        //엇갈리지 않은 한 계속 반복
        while(low < high){
            //오른쪽 끝의 값이 기존 피벗값보다 작은 경우, 즉 피벗값보다 왼쪽에 와야 하는데
            //오른쪽에 있는 경우를 찾을때까지 오른쪽 끝 인덱스를 줄여나가기
            while(arr[high] > pivot && low < high) high--;

            //왼쪽 끝값이 기존 피벗값보다 큰 경우, 즉 피벗값보다 오른쪽에 와야 하는데
            //왼쪽에 있는 경우를 찾을때까지 오른쪽으로 진행
            while(arr[low] <= pivot && low < high) low++;

            //기존 피벗위치와 교환
            swap(low,left);
        }

        return low;//조절된 왼쪽 끝부분 위치를 피벗으로 삼기
    }

    static void swap(int a, int b){
        int temp=arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }

    static void pro(){
        input();
        sort();
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        pro();
    }
}
