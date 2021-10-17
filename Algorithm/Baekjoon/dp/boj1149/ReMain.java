package com.dp.boj1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReMain {
	
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
	static int[][] cost;
	static int[][] dp;
	
	static void input() {
		N=r.nextInt();
		cost=new int[N][3];
		dp=new int[N][3];
		
		for(int i=0;i<N;i++) {
			cost[i][0]=r.nextInt();
			cost[i][1]=r.nextInt();
			cost[i][2]=r.nextInt();
		}
	}
	
	
	static void dynamic() {
		//초기값
		//1번집
		dp[0][0]=cost[0][0];
		dp[0][1]=cost[0][1];
		dp[0][2]=cost[0][2];
		
		int res=Math.min(rec_func(N-1,0), Math.min(rec_func(N-1,1), rec_func(N-1,2)));
		System.out.println(res);
	}

	static int rec_func(int idx,int color) {
	
		if(dp[idx][color]==0) {
			if(color==0) {
				dp[idx][color]=Math.min(rec_func(idx-1,1),rec_func(idx-1,2))+cost[idx][color];
			}else if(color==1) {
				dp[idx][color]=Math.min(rec_func(idx-1,0),rec_func(idx-1,2))+cost[idx][color];
			}else {
				dp[idx][color]=Math.min(rec_func(idx-1,0),rec_func(idx-1,1))+cost[idx][color];
			}
		}
		return dp[idx][color];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		dynamic();
	//	System.out.println("dp: "+Arrays.deepToString(dp));
	}

}
