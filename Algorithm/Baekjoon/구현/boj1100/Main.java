package com.implementation.boj1100;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 1.2단위로 움직이면서 색깔먼저 마킹해두기(흰곳만)
	 * 2.1마킹배열과 함께 F인곳 살피기
	 * */
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		
		public FastReader(String s) throws FileNotFoundException{
			br=new BufferedReader(new FileReader(new File(s)));
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
		
		long nextLong() {
			return Long.valueOf(next());
		}
		
		double nextDouble() {
			return Double.valueOf(next());
		}
		
	}
	
	
	static FastReader r=new FastReader();
	static int[][] colors=new int[8][8];//색상미리 마킹해두기
	static char[][] boards=new char[8][8];//체스판
	static int[][] dir= {
			{0,2},
			{0,-2},
			{2,0},
			{-2,0}
	};
	static boolean[][] visit=new boolean[8][8];
	
	static void setUp() {
		Queue<int[]> que=new LinkedList<>();
		visit[0][0]=true;
		que.add(new int[] {0,0});
		que.add(new int[] {1,1});
		
		while(!que.isEmpty()) {
			int[] temp=que.poll();
			int x=temp[0];
			int y=temp[1];
			colors[x][y]=1;//흰색
			
			for(int i=0;i<4;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				
				if(nx<0 || nx>=8 || ny<0 || ny>=8) continue;
				if(visit[nx][ny]) continue;
				
				visit[nx][ny]=true;
				colors[nx][ny]=1;
				que.add(new int[] {nx,ny});
			}
		}
		
	}
	
	static void input() {
		for(int i=0;i<8;i++) {
			String[] s=r.nextLine().split("");
			for(int j=0;j<s.length;j++) {
				boards[i][j]=s[j].charAt(0);
			}
		}
	}
	
	static void pro() {
		int ans=0;
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(boards[i][j]=='F' && colors[i][j]==1) ans++;
			}
		}
	
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setUp();//흰색 마킹
		input();
		pro();
	}

}
