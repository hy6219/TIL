package com.samsungBoj.boj16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	/**
	 * 1. ���� �� �ִ� ����� ���� �ľ��ϱ�
	 * - ��ĭ�� ������->0 ��� �� ����
	 * - �Ʊ��� ũ��> �����ũ�� �� ��� ī��Ʈ ��, �� ���� 1���̸� �� ��ġ�� �̵��ϴ� �ּ� �ð� ���
	 * 
	 * 2. ����� ������ �������� ���, 
	 * - �׹������� �Ÿ��� Ȯ���Ű�鼭 �Ÿ��� �����Ҷ�, ������ �ִ� ����� ������ ���������� Ȯ���ϰ� ���ʹ���� �Ա�
	 * - ���� ���� ��쿡�� ����ٸ�, ���� ����� ����⸦ �Ա�
	 * */
	//����⳪ �� ��ǥ������ �Ÿ������� ������ �ʿ䰡 ����
	static class Fish{
		int x;
		int y;
		int dist;
		public Fish() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Fish(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getDist() {
			return dist;
		}
		public void setDist(int dist) {
			this.dist = dist;
		}
		
		
	}
	
	
	static FastReader r=new FastReader();
	static int N;
	static int[][] board;
	static ArrayList<Fish> fishes=new ArrayList<>();

	static int[][] dir= {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
	
	static int[][] rec;
	//�Ʊ���ũ��
	static int shark=2;
	//�Ʊ��� ��ġ
	static int sx,sy;
	//�ð� ���
	static int time;
	//���� ����� ���� ����
	static int sum=0;
	
	static void input() {
		N=r.nextInt();

		rec=new int[N+1][N+1];
		board=new int[N+1][N+1];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int numeric=r.nextInt();
				board[i][j]=numeric;
				if(numeric==9) {
					sx=i; sy=j;
					board[i][j]=0;//��ĭ���� �α�
				}
			}
		}
	}
	
	static boolean rangeCheck(int r,int c) {
		return (r<0||c<0||r>=N||c>=N);
	}
	
	
	static void dynamicBfs() {
		//�� �����̸鼭 ���캼 ��Ȳ���� ���� ����
		while(true) {
			fishes=new ArrayList<>();
			boolean[][] visit=new boolean[N+1][N+1];
			Queue<Fish> que=new LinkedList<>();
			
			que.add(new Fish(sx,sy,0));
			visit[sx][sy]=true;
			
			while(!que.isEmpty()) {
				Fish fish=que.poll();
				
				for(int i=0;i<4;i++) {
					//�׹������� Ž��
					int nx=fish.x+dir[i][0];
					int ny=fish.y+dir[i][1];
					
					boolean flag=rangeCheck(nx,ny);
					
					if(flag) continue;
					if(visit[nx][ny]) continue;
					
					//���̸� ã�� ���
					//�Ʊ���ũ�Ⱑ �� ũ��, ���忡 ��ϵ� ���� 0�� �ƴ� ���
					if(board[nx][ny]>0 && shark>board[nx][ny]) {
						que.add(new Fish(nx,ny,fish.dist+1));
						visit[nx][ny]=true;
						fishes.add(new Fish(nx,ny,fish.dist+1));
					}
					
					//�������� ������, ������ �� �ִ� ���(0�̰ų� �Ʊ���ũ�Ⱑ ������ ���)
					if(board[nx][ny]==0 || board[nx][ny]==shark) {
						//�������� ���� ������ ���� ����� fishes���� �߰����� ����
						que.add(new Fish(nx,ny,fish.dist+1));
						visit[nx][ny]=true;
					}
					
				}
			}
			//��ϵ� ���� ����� 0���� ���� �ƹ��͵� ���� �� ���ٴ� ���̹Ƿ� �ð� ��� �� ����
			if(fishes.size()==0) {
				System.out.println(time);
				return;
			}
			//���� ����Ⱑ �����ϴ� ���
			Fish target=fishes.get(0);
			for(int i=1;i<fishes.size();i++) {
				//�Ÿ��� �ּ��� �����Ա����� ��� ��ü
				if(fishes.get(i).dist<target.dist) {
					target=fishes.get(i);
				}
				//�Ÿ��� ���� ��� ������ �ֿ켱
				if(fishes.get(i).dist==target.dist) {
					if(fishes.get(i).x<target.x) {
						target=fishes.get(i);
					}else if(fishes.get(i).x==target.x) {
						//x�ప�� ���ٸ� ������ ����
						if(fishes.get(i).y<target.y) {
							target=fishes.get(i);
						}
					}
				}
			}
			
			//�Ÿ��̵��Ҷ����� �ð� 1������
			time+=target.dist;
			//���� ����� ���� ����
			sum++;
			board[target.x][target.y]=0;//��ĭ���� ������
			
			//���� ����==���ũ��->��� ũ�� ����
			if(sum==shark) {
				shark++;
				//���� ���� �ʱ�ȭ
				sum=0;
			}
			//��� ��ġ ����
			sx=target.x;
			sy=target.y;
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		dynamicBfs();
	}

}
