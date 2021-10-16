package com.implementation.boj2563;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * x,y좌표를 입력받고 +10영역에 대해서 1로 마킹해준후,
 * 이미 1인 부분은 제외되기 때문에
 * 자연스럽게 붙인부분
 * 즉, 겹친부분 외의 영역이 계산됨 
 * */

public class Main {
	
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
	static int N;//색종이수
	static int[][] paper;
	static int area=0;
	
	static void pro() {
		N=r.nextInt();
		paper=new int[100][100];
		bfs();
		System.out.println(area);
	}
	
	static void bfs() {
	
		//모든 시작점 좌표 넣기
		for(int i=0;i<N;i++) {
			int f=r.nextInt();
			int s=r.nextInt();
			//x
			for(int j=f;j<f+10;j++) {
				//y
				for(int k=s;k<s+10;k++) {
					if(paper[j][k]==1) continue;
					paper[j][k]=1;
					++area;
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro();
	}

}
