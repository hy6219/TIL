package baekjoon.sort.boj2751;

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

        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(scan.nextLine());
        }
    }

    static void pro(){
        input();
        sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int i:arr){
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
    //control method
    static void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    /**
     * @param arr 정렬대상
     * @param low 가장 왼쪽에 있는 인덱스 부분
     * @param high 가장 오른쪽에 있는 인덱스 부분
     * */
    static void quickSort(int[] arr, int low, int high){
        //엇갈릴 때, 즉 크기가 1일때는 종료
        if(low>=high) return;

        //pivot 찾기
        //divide
        int pivot=partition(arr,low,high);

        //conquer
        //왼쪽 반복
        quickSort(arr,low,pivot-1);
        //오른쪽 반복
        quickSort(arr,pivot+1,high);
    }

    /**
     * @param arr 정렬 대상
     * @param left 가장 왼쪽에 있는 요소
     * @param right 가장 오른쪽에 있는 요소
     * @return 정렬을 위한 적절한 피벗위치
     * */
    static int partition(int[] arr, int left, int right){
        int low=left;
        int high=right;
        int pivot=arr[left];//처음에는 가장 왼쪽의 값을 피벗으로 넣어보기

        //엇갈리는 지점에서 피벗 찾기
        while(low<high){
            //가장 오른쪽 값이 피벗보다 작아지는 순간 찾기(잘못된 정렬임을 확인)
            //그 동안 가장 오른쪽 위치를 줄여가면서 왼쪽으로 진행
            while(arr[high] > pivot && low<high) high--;

            //가장 왼쪽 값이 피벗보다 커지는 순간을 찾기(잘못된 정렬임을 확인)
            //그동안 왼쪽 위치는 키워가면서 오른쪽으로 진행
            while(arr[low] <= pivot && low < high) low++;

            //기존 왼쪽위치와 현재 찾은 왼쪽 위치를 교환
            swap(arr,left, low);
        }
        //적절히 찾은 위치를 반환
        return low;
    }

    /**
     * @param arr 교환될 대상이 되는 배열
     * @param a 인덱스1
     * @param b 인덱스2
     * */
    static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        pro();
    }
}
