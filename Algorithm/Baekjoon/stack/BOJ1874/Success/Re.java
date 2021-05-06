package com.stack.boj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://hongku.tistory.com/248
public class Re {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T = 0;
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
				);
		
		T = Integer.valueOf(br.readLine());
		int[] values=new int[T];
		//peek
//		int peek = 0;
		//pointer
		int pointer =0;
		//한계
		int max =0;
		//stack body
		int[] stack = new int[T];
		//StringBuffer는 동기화로 인해 차이는 별로 안나지만 성능차이가 다소 있음
		//(+,-,...)담기
		StringBuilder sb =new StringBuilder();
		
		//1부터~n까지
		int i = 1;
		int tmp =0;
		while(T-- > 0) {
			tmp=Integer.valueOf(br.readLine());

			if(tmp > max) {
				//스택이 비워져 있는 상태 혹은 입력값 > 한계값인 경우는 push
				for(;i <= tmp;i++) {
					stack[pointer++]=i;//push
					sb.append("+\n");
				}
				//한계 설정
				max = tmp;
			}else if(stack[pointer-1] != tmp) {
				//스택이 비워져 있지 않은데
				//입력값이 채워진 가장 상단 요소와 같지 않으면 순열로 사용x
				System.out.println("NO");
				return;
			}
			pointer--;
			sb.append("-\n");
		}
		System.out.println(sb);
	}

}
