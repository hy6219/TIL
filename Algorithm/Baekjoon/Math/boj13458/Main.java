package com.samsungBoj.boj13458;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	static int N,B,C;
	static int[] people;
	static long ans;
	
	
	static void input() {
		N=r.nextInt();
		
		people=new int[N];
		
		for(int i=0;i<N;i++) {
			people[i]=r.nextInt();
		}
		
		B=r.nextInt(); C=r.nextInt();
	}
	
	
	static void pro() {
		long more=0;
		for(int i=0;i<N;i++) {
			//�Ѱ������� ������ �Ѹ� �־�� ��
			ans+=1L;
			long start=people[i]-B;
			//�߰��ο� �ʿ���� ���
			if(start<=0) continue;
			//�ΰ����� �ֱ�
			more=start/C;
			if(start%C==0) {
				//������ �������� ���
				ans+=more;
			}else {
				ans+=more+1;//������ �������� �ʴ� ���
			}
		}
			
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
