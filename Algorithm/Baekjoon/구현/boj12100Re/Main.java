package com.samsungBoj.boj12100Re;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//bfs
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
	//�ٵ��� �迭
	static int[][] board1=new int[21][21];
	//���� ����ӿ� ���� ���������� �����̰� �� �迭
	static int[][] board2=new int[21][21];
	
	
	static void input() {
		N=r.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board1[i][j]=r.nextInt();

			}
		}
	}
	
	//���带 ȸ����Ű��
	static void rotate() {
		//�����صα�
		int[][] temp=new int[21][21];
		
		for(int i=0;i<N;i++) {
			//���� ���������� �迭�� �����صα�
			for(int j=0;j<N;j++) {
				temp[i][j]=board2[i][j];
			}
		}
		
		//ȸ��(temp�� ��Ƶ� ���� board2�� ȸ���� ���ÿ� �������ֱ�)
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board2[i][j]=temp[N-1-j][i];//B[x][y]=A[N-1-y][x]
			}
		}
	}
	
	
	//�������� �����¿�� ����̱�
	static void tilt(int dir) {
		while(dir-->=0) rotate();//���� �������� �ð�������� 90�� ȸ����Ű��
		for(int i=0;i<N;i++) {
			//��￴���� ����/������/�Ʒ�/�� �������� �򸮴µ�, �� ���� �������� �򸮵��� �ϱ�
			int[] tilted=new int[21];
			//������ ���� �� �ִ��� Ȯ���ϱ� ���� �ε���
			int idx=0;
			for(int j=0;j<N;j++) {
				//����ִٸ�  �� �ʿ����
				if(board2[i][j]==0) continue;
				//����ӹ迭�� ���� 0�̶��, ��￴���� �� ���� �ִٴ� ��
				//�� �ű��
				if(tilted[idx]==0) {
					tilted[idx]=board2[i][j];
				}else if(tilted[idx]==board2[i][j]) {
					//������� ������,���� ��￩�� �迭��ġ���� ���� ���� ������ ������ ������
					//2�� ó���� ���� '��', ����ĭ���� �̵�
					tilted[idx++]*=2;
				}else {
					//����ӹ迭�� ��������� �ʰ�, ���� ������ �ʴٸ�,
					//���� �� �� ������ �� �ڸ��� �̵���Ű��,
					//�� ���� �� ���� �ֱ�
					tilted[++idx]=board2[i][j];
				}
				
			}
			//����ӹ迭�� ����� �������� �����Ű�� ���ؼ� board2�� �����صα�
			for(int j=0;j<N;j++) {
				board2[i][j]=tilted[j];
			}
		}
	}

	static void pro() {
		//�ִ� ã��
		int max=Integer.MIN_VALUE;
		//��Ͽ� ���� �ִ� ���� 2���� ũ�ų� ����, 1024���� �۰ų� ���� 2�� ������
		for(int i=0;i<1024;i++) {
			//������ 4�����̰�, �� �� �� �� �ϳ��� ������ �Ŀ���
			//���� 'ȸ��'�� "Ž��"�ؾ� �ϹǷ� "Ž��"�̶�� �ǹ̿� �°� brute ���� ���
			//dir=brute%4, �� ���Ŀ��� brute/=4
			//�� �Ŀ��� ���带 ȸ����Ű��, ��￩�� ��ġ��
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					board2[j][k]=board1[j][k];//����
				}
			}
			int brute=i;
			
			for(int j=0;j<5;j++) {
				int dir=brute%4;
				brute/=4;
				tilt(dir);
				//System.out.println("board2: "+Arrays.deepToString(board2));
			}
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					max=Math.max(max, board2[j][k]);
				}
			}
		}
		
		
		
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
