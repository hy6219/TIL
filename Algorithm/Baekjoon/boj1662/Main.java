package com.boj1662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nextLine() {
			String str="";
			
			try {
				str=br.readLine();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			return str;
		}
		
		String next() {
			while(st==null || !st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.valueOf(next());
		}
	}
	
	
	static FastReader r= new FastReader();
	static String str="";
	static Stack<Integer> stack=new Stack<>();
	//pair 이루어서 ) 위치 저장하기
	static int[] reverse;
	
	
	static void input() {
		str=r.nextLine();
		reverse=new int[50];
	}
	
	static void pro() {
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			
			if(c=='(') {
				stack.push(i);
			}else if(c==')'){
				reverse[stack.pop()]=i;
			}
			
		}
		
		//탐색
		int res=traversal(0,str.length());
		System.out.println(res);
	}
	
	static int traversal(int start, int end) {
		
		int len=0;
		
		for(int i=start;i<end;i++) {
			
			char c=str.charAt(i);
			
			if(c=='(') {
				len+=(str.charAt(i-1)-'0')*traversal(i+1,reverse[i])-1;
				i=reverse[i];
			}else {
				len++;
			}
			
		}
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
