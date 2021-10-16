package com.implementation.boj2563;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * x,y��ǥ�� �Է¹ް� +10������ ���ؼ� 1�� ��ŷ������,
 * �̹� 1�� �κ��� ���ܵǱ� ������
 * �ڿ������� ���κκ�
 * ��, ��ģ�κ� ���� ������ ���� 
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
	static int N;//�����̼�
	static int[][] paper;
	static int area=0;
	
	static void pro() {
		N=r.nextInt();
		paper=new int[100][100];
		bfs();
		System.out.println(area);
	}
	
	static void bfs() {
	
		//��� ������ ��ǥ �ֱ�
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
