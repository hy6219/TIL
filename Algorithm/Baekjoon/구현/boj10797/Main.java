package com.implementation.boj10797;

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
	
	static FastReader r= new FastReader();
	static int cnt=0;
	static int N;
	
	static void pro(int n) {
		String t=String.valueOf(n);
		int flag=t.charAt(t.length()-1)-'0';
		if(flag==N) cnt++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=r.nextInt();
		for(int i=0;i<5;i++) {
			int temp=r.nextInt();
			pro(temp);
		}
		System.out.println(cnt);
		
	}

}
