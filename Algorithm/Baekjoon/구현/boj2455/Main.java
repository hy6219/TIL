package com.implementation.boj2455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	static FastReader r=new FastReader();
	static int max=0;
	static int minus=0;
	static int plus=0;
	static int current=0;
	
	
	static void setUp() {
		r.nextInt();//첫번째 역에서 탄사람은 0일것!
		plus=r.nextInt();
		max=plus;//첫번째 역에서 탄사람수로 초기화
		current=plus;
	}
	
	static void pro() {
		for(int i=1;i<4;i++) {
			minus=r.nextInt()*(-1);
			plus=r.nextInt();
			if(current<minus) {
				//각 역에서 현재 기차에 있는 사람보다 더 많은 사람이 내리는 경우는 없다.
				/*
				 * 반례)
				 * 0 32
13 3
25 28
25 0
				 * */
				minus=0;
			}
			int diff=minus+plus;
			//그 역에서 있는 사람수 계산
			int temp=current+diff;
			current=temp;
			max=Math.max(max, temp);
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setUp();
		pro();
	}

}
