package com.swea.swea2056;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트케이스
        int T = Integer.valueOf(br.readLine());

        for(int i = 0 ; i < T; i++){
            String line = br.readLine();//생년월일입력받기
            //결과
            String res     = "";
            String yrTemp =line.substring(0,4);
            String monTemp=line.substring(4,6);
            String dayTemp=line.substring(6);
            int year    = Integer.valueOf(yrTemp);
            int month   = Integer.valueOf(monTemp);
            int day     = Integer.valueOf(dayTemp);
            StringBuilder sb = new StringBuilder();
            if(month<=0 || month>12||day<=0){
                res="-1";//월입력 혹은 일자가 0이하인 경우로 잘못된 경우
            }else{
                //월입력이 잘된 경우지만 일자가 유효하지 않은경우는 걸러내기
                if(month==1 || month==3||month==5||month==7||month==8||month==10||month==12){
                    if(day<=31){
                        res = sb.append(yrTemp).append("/").append(monTemp).append("/").append(dayTemp).toString();
                    }else{
                        //일자가 유효하지 않은 경우
                        res = "-1";
                    }
                }else if(month==4 || month==6||month==9||month==11){
                    if(day<=30){
                        res = sb.append(yrTemp).append("/").append(monTemp).append("/").append(dayTemp).toString();
                    }else{
                        //일자가 유효하지 않은 경우
                        res = "-1";
                    }
                }else{
                    //2월
                    if(day<=28){
                        res = sb.append(yrTemp).append("/").append(monTemp).append("/").append(dayTemp).toString();
                    }else{
                        //일자가 유효하지 않은 경우
                        res = "-1";
                    }
                }
            }
            bw.write("#"+(i+1)+" "+res+"\n");
        }
        bw.close();
        br.close();
    }
}
