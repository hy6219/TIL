package com.samsungBoj.boj16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
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
	

	static class Tree{
		int r;
		int c;
		//���� ����
		int origin;
		public Tree() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Tree(int r, int c, int origin) {
			super();
			this.r = r;
			this.c = c;
			this.origin = origin;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getOrigin() {
			return origin;
		}
		public void setOrigin(int origin) {
			this.origin = origin;
		}
		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", origin=" + origin + "]";
		}
		
		
	}
	
	static FastReader r=new FastReader();
	static int N,M,K;
	static int[][] A;//�������
	static int[][] cp;//�������
	static LinkedList<Tree> tree=new LinkedList<>();//��������(��ǥ,[����])
	//���� �׾������� ���
	static Queue<Tree> death=new LinkedList<>();
	
	//�������
	static int[][] dir= {
			{-1,-1},{-1,0},{-1,1},
			{0,-1},{0,1},{1,-1},
			{1,0},{1,1}
	};
	static boolean[][] visit;
	//��Ƴ��� ������ ���ϱ�
	static int cnt=0;
	
	static void input() {
		N=r.nextInt();
		M=r.nextInt();
		K=r.nextInt();
		
		A=new int[N+1][N+1];
		cp=new int[N+1][N+1];
		visit=new boolean[N+1][N+1];
		//�������
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				A[i][j]=5;//ó������ ��� 5�� ����־���
				cp[i][j]=r.nextInt();
			}
		}

		
		for(int i=0;i<M;i++) {
			Tree t=new Tree(r.nextInt(),r.nextInt(),r.nextInt());
			tree.add(t);
		}
	}
	
	static void simulate() {
		int year=0;
		while(true) {
			if(year==K) return;
			
			//��
			Iterator<Tree> iterator=tree.iterator();
			
			while(iterator.hasNext()) {
				Tree t=iterator.next();
				int r=t.getR();
				int c=t.getC();
				int age=t.getOrigin();
				

				if(A[r][c]<age) {
					//����� ���� ���ϰ� ����
					death.add(t);
					iterator.remove();
				}else {
					//����� ���� �� ����!!
					A[r][c]-=age;
					//���̴� ����~
					t.origin++;
				}
			}
			
			//����
			while(!death.isEmpty()) {
				Tree t=death.poll();
				A[t.r][t.c]+=t.getOrigin()/2;//����� ������
			}
			
			//����(����)
			Queue<Tree> bunsik=new LinkedList<>();//>3<��մ�
			
			for(Tree t:tree) {
				int r=t.getR();
				int c=t.getC();
				
				//5��� ���̰� �ƴϸ� �� �ʿ䵵 ����
				if(t.getOrigin()%5!=0) continue;
				//5��� ������ ���~
				for(int d=0;d<8;d++) {
					int nr=r+dir[d][0];
					int nc=c+dir[d][1];
					
					//Ʋ�� ��� ���(r,c>=1)
					if(nr<1 || nc<1 || nr>=N+1 || nc>=N+1) continue;
					bunsik.add(new Tree(nr,nc,1));
					
				}
			}
			
			//��ü�� ��ü~
			tree.addAll(0,bunsik);
			
			//�ܿ�
			//��ĭ�� ��д��ֱ�~
			for(int r=1;r<=N;r++) {
				for(int c=1;c<=N;c++) {
					A[r][c]+=cp[r][c];
				}
			}
			
			year++;//���� ����
		}
	}
	
	
	static void pro() {
		simulate();
		System.out.println(tree.size());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
