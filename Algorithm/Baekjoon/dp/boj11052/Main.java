package com.dp.boj11052;

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
	static int N;
	static int[] cards;
	static int[] dp;
	
	static void input() {
		N=r.nextInt();
		cards=new int[N+1];
		dp=new int[N+1];
		for(int i=1;i<=N;i++) {
			cards[i]=r.nextInt();
		}
	}

	
	static void rec_func() {

		dp[1]=cards[1];

		//i:총 장수
		for(int i=2;i<=N;i++) {
			//1~N번째 카드
			for(int j=1;j<=i;j++) {
				dp[i]=Math.max(dp[i], dp[i-j]+cards[j]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		rec_func();
		
		int max=Integer.MIN_VALUE;
		
		for(int i=1;i<=N;i++) {
			max=Math.max(max, dp[i]);
		}
		//System.out.println("dp: "+Arrays.toString(dp));
		System.out.println(max);
		
	}

}
