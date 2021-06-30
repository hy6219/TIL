package com.swea.swea1983;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
        for(int i =0 ; i < T; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.valueOf(st.nextToken());
            int k = 0;

            while(st.hasMoreTokens()){
                k = Integer.valueOf(st.nextToken());
            }
            //-----------------n,k입력 완료---------------//
            //----------------총합 입력받기----------------//
            Double[] sums = new Double[n];
            double find = 0;
            int idx = 0;

            for(int j = 0; j < n; j++){
                double temp = 0;
                int mid = 0;
                int fin = 0;
                int assign = 0;
                int l = 0;
                //총합이 같은 경우는 존재하지 않음

                line = br.readLine();

                st = new StringTokenizer(line);
                mid = Integer.valueOf(st.nextToken());

                while(st.hasMoreTokens()){
                    if(l == 0){
                        fin = Integer.valueOf(st.nextToken());
                    }else if(l==1){
                        assign=Integer.valueOf(st.nextToken());
                    }
                    l++;
                }
                //---각 인덱스별 총합 저장하기
                temp = 0.35*mid + 0.45*fin+0.2*assign;

                sums[j] = temp;//합 저장하기

                if(j+1==k){
                    find = temp;//찾았다!
                }
            }

            //정렬-Array.sort는 primitive가 아닌 wrapper 클래스를 지원
            Arrays.sort(sums, Collections.reverseOrder());

            for(int j = 0 ; j < sums.length; j++){
                if(sums[j]==find){
                    idx = j;
                }
            }
            StringBuilder sb = new StringBuilder();
            idx = (idx/(n/10));
            sb.append("#"+(i+1)+" "+grade[idx]);
            if(i!=T-1){
                sb.append("\n");
            }
            bw.write(sb.toString());
        }

        bw.close();
        br.close();

    }
}
