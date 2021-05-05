package com.stack.boj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		
		int T = 0;
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
				);
		
		T = Integer.valueOf(br.readLine());
		
		for(int i = 0 ; i < T; i++) {
			String inp = br.readLine();
			int open =0;
			int close =0;

			for(int j=0; j< inp.length();j++) {
				
				char tmp = inp.charAt(j);
				if(tmp =='(') {
					++open;
					stack.push(tmp);
				}else {
					++close;
					//비어있지 않으면 == ( 가 있다면, pop
					if(!stack.empty()) {
						stack.pop();
					}
				}
			}
			//(( 경우와 같은 케이스를 위해서 ) 갯수도 세어두기
			if(open==close) {
				//짝이 맞지만, 스택이 비어있지 않으면 NO
				if(!stack.empty()) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			}else {
				//짝이 안맞으면 무조건 NO
				System.out.println("NO");
			}
			
			

			
			/*스택 초기화*/
			stack.clear();
		}
		
		
		
		
	}

}
