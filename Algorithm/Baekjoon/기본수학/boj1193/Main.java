package com.boj1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int   order = Integer.valueOf(br.readLine());
		//해당 대각선 내의 요소 갯수
		int  ele     = 1;
		//누적합(이전 대각선)
		int  cum     = 0;
		
		while(true) {
			//현재 순서 <=이전대각선+갯수이면  해당 범위에서 작업 수행
			if(order <= cum+ele) {
				//대각선 내 요소 갯수가 홀수라면 가장 마지막수(분모가 가장 큰 수=행이 가장 큰 수)부터 시작
				//분모 = 대각선 내 요소 갯수-(X(순서)-마지막(ENDING=직전까지의 누적합)-1)
				//분자=X-직전까지의 누적합
				if(ele%2==1) {
					System.out.println((ele-(order-cum-1))+"/"+(order-cum));
					break;
				}else {
					//대각선 내 요소 갯수가 짝수라면
					//분모=X-직전까지의 누적합
					//분자=대각선 내 요소 갯수-(순서-직전누적합-1)
					System.out.println((order-cum)+"/"+(ele-(order-cum-1)));
					break;
				}
			}else {
				cum+=ele;
				ele++;
			}
		}
		
		br.close();
	}
	
	
}
