package com.samsungBoj.boj15683;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReMain {
	
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
	static int N,M;
	//cctv ��ǥ
	static Stack<int[]> cctv=new Stack<>();
	//���ʿ� �Է¹��� board ����
	static int[][] board1;
	//�簢���� ���� ����
	static int[][] board2;
	//�簢���� �ּ� ũ��
	static int min=0;
	
	static int[][] dir= {
			{1,0},//��
			{0,1},//��
			{-1,0},//��
			{0,-1}//��
	};
	
	static void input() {
		N=r.nextInt(); M=r.nextInt();
		
		board1=new int[10][10];
		board2=new int[10][10];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				board1[i][j]=r.nextInt();
				
				if(board1[i][j]!=0 && board1[i][j]!=6) cctv.push(new int[] {i,j});
				//ó�� ��ĭ������ �簢���� �ʱ�ȭ
				if(board1[i][j]==0) min++;
			}
		}
	}
	
	//4����->���� ����
	static void direction() {
		for(int i=0;i<(1<<(2*cctv.size()));i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					//�迭 ����
					board2[j][k]=board1[j][k];
				}
			}
			
			//���� ���ϱ�
			int brute=i;
			
			for(int j=0;j<cctv.size();j++) {
				int d=brute%4;
				brute/=4;
				int[] o=cctv.get(j);
				int x=o[0];
				int y=o[1];
				
				//���� �־��� cctv�� ���������� ���������� �� �� ����
				if(board1[x][y]==1) {
					wall(x,y,d);
				}else if(board1[x][y]==2) {
					//cctv 2
					//�Ϻη� ������ ���缭 ��Ҹ� ��ġ�صξ���
					wall(x,y,d);
					wall(x,y,d+2);
				}else if(board1[x][y]==3) {
					//cctv3
					wall(x,y,d);
					wall(x,y,d+1);
				}else if(board1[x][y]==4) {
					//cctv4
					wall(x,y,d);
					wall(x,y,d+1);
					wall(x,y,d+2);
				}else {
					//cctv5
					wall(x,y,d);
					wall(x,y,d+1);
					wall(x,y,d+2);
					wall(x,y,d+3);
				}
			}
	//		System.out.println("board2: "+Arrays.deepToString(board2));
			
			//�ּڰ� ã��
			int v=0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(board2[j][k]==0) {
						v++;
					}
				}
			}
			min=Math.min(min, v);
		}
	}

	
	//Ư���������� ���������� ���� ������ ������ 7�� ���� ä���
	static void wall(int x, int y ,int d) {
		d%=4;
		while(true) {
			x+=dir[d][0];
			y+=dir[d][1];
			if(x<0||y<0||x>=N || y>=M) return;
			if(board2[x][y]==6) return;
			if(board2[x][y]!=0) continue;//���� �ִ� ��Ȳ�� ������ ��Ȳ���� cctv�� �����Ѵٸ� �Ѿ
			board2[x][y]=7;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		direction();
		System.out.println(min);
	}

}
