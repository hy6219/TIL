package com.samsungBoj.boj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	
	
	static FastReader scan=new FastReader();
	static int N,M;
	//�κ�û�ұ� rcd
	static int r,c,d;
	//����
	static int[][] room;
	//����
	//�Ϻη� �ε����� d�� ��ġ���Ѽ� �����־���
	static int[][] dir= {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
	//û�ҿ��� ����
	static int cnt=0;
	
	static void input() {
		N=scan.nextInt();
		M=scan.nextInt();
		
		room=new int[N][M];
		
		r=scan.nextInt();
		c=scan.nextInt();
		d=scan.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				room[i][j]=scan.nextInt();
			}
		}
		
	}
	
	//��������� Ž���� �ʿ䰡 ����
	
	static void dfs(int raw,int col,int direction) {
		//�� ���� û�� Ȯ��
		boolean flag=false;
		//���� ŵ
		int t=direction;
		//1.���� ��ġ û��
		if(room[raw][col]==0) {
			room[raw][col]=3;
			cnt++;
		}
		
		for(int i=0;i<4;i++) {
			//���ʺ��� õõ�� ���Ǹ鼭 û��
			int nd=(direction+3)%4;//���� ���ʺ��� Ž��
			int nx=raw+dir[nd][0];
			int ny=col+dir[nd][1];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				//û�Ұ� ���� ���� ���
				if(room[nx][ny]==0) {
					dfs(nx,ny,nd);//ó���� �־��� ���Ⱚ���� û�Ұ� ���� �ʾҴٸ� i=3 �� ���ʺ��� ���캸�� �� ��
					flag=true;
					return;//����-�� ���� �� û�Ұ� ���� ���� �κп� ���ؼ��� ó���Ϸ�->����
				}
			}
			direction=(direction+3)%4;
		}
		
		if(!flag) {
			//�� ���� ��� û�ҵ� ���
			int nd=(t+2)%4;
			int nx=raw+dir[nd][0];
			int ny=col+dir[nd][1];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				//û�Ұ� �ȵǾ� �ְų�, Ȥ�� û�Ұ� �� ��� <=>���� �ƴ� ���
				//�ٶ� ���� ������ ä ����(�׷��� ���� �ܰ迡�� �ڿ������� ����ɰ�)
				if(room[nx][ny]!=1) {
					//�ٶ� ���� �״�� ����
					dfs(nx,ny,t);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		dfs(r,c,d);

		System.out.println(cnt);
	}

}
