package sorting.boj.boj18870;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.valueOf(br.readLine());

        String line=br.readLine();
        StringTokenizer st=new StringTokenizer(line);
        int[] arr=new int[n];

        int i=0;

        while(st.hasMoreTokens()){
            arr[i++]=Integer.valueOf(st.nextToken());
        }


        int[] cloned=arr.clone();
        Arrays.sort(cloned);
        Map<Integer,Integer> map=new HashMap<>();

        i=0;
        for(int j:cloned){
            if(!map.containsKey(j)){
                map.put(j,i++);
            }//값,인덱스 조합
        }
        //정렬된 상태였기 때문에 현재 인덱스값이 나보다 작은 값을 확인할 수 있게 됨!
        StringBuilder sb= new StringBuilder();
        for(int j:arr){
            sb.append(map.get(j)).append(' ');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
