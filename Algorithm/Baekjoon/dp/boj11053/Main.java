package com.dp.boj11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
	static int N;
	static int[] arr;
	static int max=Integer.MIN_VALUE;
	static int[] dp;
	
	static void input() {
		N=r.nextInt();
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=r.nextInt();
		}
		dp=new int[N];
	//	dp[0]=1;
	}

	static void pro() {
		/*
		 * 이전값들보다 큰지 확인하면서 값 기록하기
		 * 
		 * */
		
		for(int i=0;i<N;i++) {
			dp[i]=1;//시작점
			
			//현재 노드 이전까지를 확인
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && dp[j]>=dp[i]) {
					dp[i]=dp[j]+1;
				}
			}
		}
		//System.out.println("dp: "+Arrays.toString(dp));
		for(int i=0;i<N;i++) {
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
