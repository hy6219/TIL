package com.samsungBoj.boj14889;

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
	static int N;
	static int[][] skill;

	//���� �ּڰ�
	static int min=Integer.MAX_VALUE;
	//�ߺ�üũ�� ���� �÷��׹迭
	static boolean[] visit;
	
	static void input() {
		N=r.nextInt();
		skill=new int[N][N];
		visit=new boolean[N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				skill[i][j]=r.nextInt();
			}
		}
		

	}
	
	static void calc() {
		//true->��ŸƮ��
		//false->��ũ��
		//�� ���� �ɷ�ġ ���
		int st=0;
		int link=0;
		
	//	System.out.println("visit: "+Arrays.toString(visit));
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				//��ŸƮ��
				if(visit[i] && visit[j]) {
					//i�� j�� ��� ��ŸƮ���� ���
					st+=skill[i][j];
					st+=skill[j][i];
				}
				//��ũ��
				else if(!visit[i] && !visit[j]) {
					//i�� j�� ��� ��ũ���� ���
					link+=skill[i][j];
					link+=skill[j][i];
				}
			}
		}
		
		//�� �� �������̰� 0�̸� �װ��� �ּڰ��̹Ƿ� ����
		int limit=Math.abs(st-link);
		
		if(limit==0) {
			System.out.println(limit);
			System.exit(0);
		}
		
		min=Math.min(min, limit);
//		System.out.println("��ŸƮ�� ����: "+st+", ��ũ�� ����: "+link);
	}
	
	
	static void rec_func(int idx,int k) {
		if(k==N/2) {
			//��ũ���� ��ŸƮ������ ������+
			//�� �� ���� ���
			calc();
			return;
		}else {
			//Ž��
			for(int cand=idx+1;cand<N;cand++) {
				//k��° ��ŸƮ�� �������� cand�� ���
				if(!visit[cand]) {
					visit[cand]=true;
					//����Ž��
					rec_func(cand,k+1);
					//�ʱ�ȭ
					visit[cand]=false;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		rec_func(0,0);
		System.out.println(min);
	}

}
