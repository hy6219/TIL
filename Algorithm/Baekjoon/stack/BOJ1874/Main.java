package com.stack.boj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=
				new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());
		int[] tmp = new int[T];
		Stack s = new Stack();
		
		int val = 0;
		ArrayList<String> res=new ArrayList<>();
		ArrayList<String> temp=new ArrayList<>();
		int k = 0;
		for(int i = 0 ; i < T; i++) {
			tmp[i] = Integer.valueOf(br.readLine());
		}
		for(int j = 1; j <=T; j++) {
			
			//첫번째 요소
			if(j==1) {
				
				for(k = 1; k <= tmp[0]; k++) {
					res.add("+");
					s.push(k);
				}
				val = (Integer)s.peek();
				int l = 0;
				while(l < k) {
					if(val==tmp[l]) {
						val = (Integer)s.peek();
						temp.add(String.valueOf(s.pop()));
						res.add("-");
					}
					l++;
				}
			
			}else{
				//그 이후
				//int c= 0;
				
				//tmp[j-1] 까지 push
				for(; k <= tmp[j-1];k++) {
					s.push(k);
					res.add("+");
				}
				int c =0;
				while(c < j) {
					val=(Integer)s.peek();
					if(val==tmp[c] && (!s.empty())) {
						temp.add(String.valueOf(s.pop()));
						res.add("-");
					}
					c++;
				}

			}
			
		}
		//비어있거나, 값이 요소값과 다르면 계속 push
		//값이 요소값과 같으면 pop
		
		String str1= temp.toString();
		String str2= Arrays.toString(tmp);
		String prt = res.toString();

		if(str1.equals(str2)) {
			System.out.println(prt);
		}else {
			System.out.println("NO");
		}
	}

}

